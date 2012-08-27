package sgf;

public abstract class AnnotationProperty extends Property {

    public PropertyType getPropertyType() {
        return PropertyType.annotation;
    }

    public boolean doesPersist() { return false; }
}
