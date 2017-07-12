package com.qianjin.java.sss.java2s.a1101.ass21;

public class Chip {

    private final String colour;

    public Chip(String colour) {
        this.colour = colour.toLowerCase();
    }

    public String getColour() {
        return colour;
    }

    public boolean equals(Chip chip) {
        if (chip.getColour().toLowerCase().equals(colour))
            return true;
        else
            return false;
    }

    public String toString() {
        if (colour.toLowerCase().equals("red"))
            return "R";
        else
            return "Y";
    }

}
