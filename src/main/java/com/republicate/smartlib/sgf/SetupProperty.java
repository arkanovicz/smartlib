package com.republicate.smartlib.sgf;


public abstract class SetupProperty extends Property {

    public PropertyType getPropertyType() {
        return PropertyType.setup;
    }

    public boolean doesPersist() { return true; }
}
