package com.republicate.sgf;

public abstract class MarkupProperty extends Property {

    public PropertyType getPropertyType() {
      return PropertyType.markup;
    }

    public boolean doesPersist() { return false; }
}
