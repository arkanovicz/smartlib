package com.republicate.smartlib.sgf;

public abstract class TimingProperty extends Property {

    public PropertyType getPropertyType() {
      return PropertyType.timing;
    }

    public boolean doesPersist() { return false; }
}
