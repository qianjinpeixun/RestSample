package com.qianjin.java.sss.java2s.a1101.ass23;

public class Chip {

    private String colour;

    public Chip(String c) {
        this.colour = c;
    }

    public String getColour() {
        return colour;
    }

    public boolean equals(Chip c) {
        boolean same = false;
        same = c.getColour().equalsIgnoreCase(colour);
        return same;
    }

    public String toString() {
        return this.colour;
    }

}
