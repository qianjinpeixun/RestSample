package com.qianjin.java.sss.java2s.a1101.ass25;

public class Chip {

    private String colour;

    public Chip(String c) {
        this.colour = c;
    }

    public String getColour() {
        return colour;
    }

    public boolean equals(Chip c) {
        if (c == null)
            return false;
        return c.getColour().equals(colour);
    }

    public String toString() {
        return this.colour;
    }

}
