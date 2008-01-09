package sgf;

import sgf.GameCollection;
import sgf.Node;
import sgf.Property;
import sgf.types.ValueType;
import sgf.types.ValueEList;
import sgf.types.ValueList;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.CharacterIterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

import util.TalkativeCharacterIterator;
import util.Logger;

/**
 */

public class SGFParser {

    private GameType gameType;

    public SGFParser() {
        this(GameType.Go);
    }

    public SGFParser(GameType type) {
        this.gameType = type;
    }

    public static void setLogger(PrintWriter pw) {
        logger = pw;
    }

    public GameType getGameType() {
        return gameType;
    }

    public GameCollection parseSGF(File file) throws IOException {
        return parseSGF(new FileInputStream(file));
    }

    public GameCollection parseSGF(InputStream sgf) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(sgf));
        StringBuilder content = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            content.append(line);
            content.append('\n');
        }
        return parseSGF(content.toString());
    }

    public GameCollection parseSGF(String content) {
        GameCollection collection = new GameCollection();
        TalkativeCharacterIterator iterator = new TalkativeCharacterIterator(content);
        for(char c = iterator.first();c != CharacterIterator.DONE; c = iterator.next()) {
            if(c == '(') {
                collection.add((Node)parseGameTree(iterator));
            }
        }
        return collection;
    }

    private Node parseGameTree(TalkativeCharacterIterator iterator)
    {
        int start = -1;
        int end = -1;
        int level = -1;
        boolean insideValue = false;
        boolean escaped = false;
        Node first = null;
        Node current = null;
        for(char c = iterator.current();c != CharacterIterator.DONE; c = iterator.next()) {
            if(escaped) {
                escaped = false;
                continue;
            }
            if(c == '\\') {
                escaped = true;
                continue;
            }
            if(insideValue) {
                if (c == ']') {
                    insideValue = false;
                }
            } else if(c == '[') {
                insideValue = true;
            }
            if(insideValue) continue;
            if(c != ')' && c != '(' && level > 0 ) continue;
            switch(c) {
                case ';':
                    if(start != -1) {
                        end = iterator.getPosition();
                        Node node = parseNode(iterator.getText().substring(start,end));
                        if(node != null) {
                            if(current != null) {
                                current.addChild(node);
                            }
                            current = node;
                            if(first == null) {
                                first = node;
                            }
                        }
                    }
                    start = iterator.getPosition() + 1;
                    break;
                case '(':
                    if(level == 0) {
                        if(start != -1) {
                            end = iterator.getPosition();
                            Node node = parseNode(iterator.getText().substring(start,end));
                            if(node != null) {
                                if(current != null) {
                                    current.addChild(node);
                                }
                                current = node;
                                if(first == null) {
                                    first = node;
                                }
                            }
                        }
                        start = iterator.getPosition();
                    }
                    level++;
                    break;
                case ')':
                    level--;
                    if(level == 0) {
                        end = iterator.getPosition() + 1;
                        Node node = parseGameTree(new TalkativeCharacterIterator(iterator.getText().substring(start,end)));
                        if(current == null) {
                            first = current = node;
                        }
                        else {
                            current.addChild(node);
                        }
                        start = -1;
                    } else if (level == -1) {
                        if (start != -1) {
                            end = iterator.getPosition();
                            Node node = parseNode(iterator.getText().substring(start,end));
                            if(node != null) {
                                if(current != null) {
                                    current.addChild(node);
                                }
                                current = node;
                                if(first == null) {
                                    first = node;
                                }
                            }
                        }
                        return first;
                    }
            }
        }
        return first;
    }

    private Pattern nodePattern = Pattern.compile("\\s*([a-zA-Z]+)\\s*((?:\\[\\s*(?:(?:\\\\.)|[^\\]\\\\])*\\]\\s*)+)");

    private Node parseNode(String text) {        
        Node node = new Node();
        String id = null;
        Property property = null;
//Logger.debug("node: matching "+nodePattern.pattern()+" against "+ limit(text,300));
        Matcher matcher = nodePattern.matcher(text);
        while(matcher.find()) {
//String dbg="  found prop: "+matcher.group()+" with "+matcher.groupCount()+" groups:";
//for(int i=1;i<=matcher.groupCount();i++)dbg+=" group #"+i+" = "+matcher.group(i);
//Logger.debug(dbg);
            id = matcher.group(1);
            if(id.length() > 2) {
                // Some SGF files contain properties like "VieW" for VW
                String tmp = "";
                for(int i=0;i<id.length();i++) {
                    char c = id.charAt(i);
                    if (Character.isUpperCase(c)) {
                        tmp+=c;
                    }
                }
                id = tmp;
            }
            property = Property.getInstance(id,gameType);
            if(property == null) {
                warn("sgf parser: property '"+id+"' not found (input was \""+text+"\")");
            } else {
                if(parseValue(matcher.group(2),property)) {
                    node.addProperty(property);
                }
            }
        }
        return node;
    }

    private boolean parseValue(String value,Property target) {
        ValueType valueType = target.getValueType();
        Pattern valuePattern = Pattern.compile("\\["+valueType.getPattern()+"\\]");
        Matcher matcher = valuePattern.matcher(value);
        boolean success = false;
//Logger.debug("property: matching "+valuePattern.pattern()+" against "+limit(value,80));
        while(matcher.find()) {
//String dbg="  found value: "+matcher.group()+" with "+matcher.groupCount()+" groups:";
//for(int i=1;i<=matcher.groupCount();i++)dbg+=" group #"+i+" = "+matcher.group(i);
//Logger.debug(dbg);            
            if(success && !(valueType instanceof ValueEList) && !(valueType instanceof ValueList)) {
                warn("sgf parser: property "+target.getId()+": extra value ignored: "+matcher.group());
            } else {
                List<String> list = new ArrayList<String>();
                for (int i=1;i<=matcher.groupCount();i++) {
                    if(matcher.group(i) != null) {
                        list.add(matcher.group(i));
                    }
                }
                success = target.addValue(list);
                if(!success) break;
            }
        }
        if(!success) {
            warn("sgf parser: property "+target.getId()+": bad value: "+value);

        }
        return success;
    }

    // testing
    public static void main(String args[]) {
        try {
//            Logger.log2Stderr();
            Logger.log2Stdout();
            Logger.setLogLevel(Logger.DEBUG_ID);
            GameCollection collection = new SGFParser(GameType.Go).parseSGF(new File(args[0]));
            System.out.println("GameCollection="+collection);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String limit(String input,int size) {
        if(input.length() <= size) {
            return input;
        } else {
            return input.substring(0,size)+"...";
        }
    }

    private static PrintWriter logger = null;

    public static void warn(String msg) {
        Logger.warn(msg);
        logger.println("warning: "+msg);
    }
}
