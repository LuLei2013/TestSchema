package com.build.proto.testschema;

import java.io.Serializable;

public class Test implements Serializable {
    public String man;
    public String woman;

    Test(String man, String woman) {
        this.man = man;
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "man = " + man + " , woman = " + woman;
    }
}
