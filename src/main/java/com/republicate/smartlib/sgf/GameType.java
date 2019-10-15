package com.republicate.smartlib.sgf;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
* User: claude
* Date: 10 déc. 2007
* Time: 15:40:41
* To change this template use File | Settings | File Templates.
*/
public enum GameType {
    Go(1), Othello(2), Chess(3),
    GomokuRenju(4), NineMensMorris(5), Backgammon(6),
    ChineseChess(7), Shogi(8), LinesOfAction(9),
    Ataxx(10), Hex(11), Jungle(12), Neutron(13),
    PhilosophersFootball(14), Quadrature(15), Trax(16),
    Tantrix(17), Amazons(18), Octi(19), Gess(20),
    Twixt(21), Zertz(22), Plateau(23), Yinsh(24),
    Punct(25), Gobblet(26), hive(27), Exxit(28),
    Hnefatal(29), Kuba(30), Tripples(31), Chase(32),
    TumblingDown(33), Sahara(34), Byte(35), Focus(36),
    Dvonn(37), Tamsk(38), Gipf(39), Kropki(40);

    private int type;
    private static Map<Integer,GameType> map = null;
    public int getType() {
        return type;
    }
    public static synchronized GameType getType(int n) {
        if(map == null) {
            map = new TreeMap<Integer,GameType>();
            for(GameType type:GameType.values()) {
                map.put(type.getType(),type);
            }
        }
        return map.get(n);
    }

    GameType(int type) { this.type = type; }
}
