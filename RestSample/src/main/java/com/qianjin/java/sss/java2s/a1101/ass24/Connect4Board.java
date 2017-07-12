package com.qianjin.java.sss.java2s.a1101.ass24;

public class Connect4Board extends Board {

    public Connect4Board() {
        super(6, 7);
    }

    public boolean add(int c, String colour) {
        Chip chip = new Chip(colour);
        for (int i = 5; i >= 0; i--) {
            if (getBoard()[i][c] == null) {
                return super.add(i, c, chip);
            }
        }
        return false;
    }

    public boolean winner() {
        String ret = winType();
        if (ret.equals("h") || ret.equals("v") || ret.equals("d"))
            return true;
        else
            return false;
    }

    public String winType() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Chip chip = getBoard()[i][j];
                if (chip != null) {
                    if (hasWinner(chip, i, j, 0, 1))
                        return "v";
                    if (hasWinner(chip, i, j, 0, -1))
                        return "v";
                    if (hasWinner(chip, i, j, 1, 0))
                        return "h";
                    if (hasWinner(chip, i, j, -1, 0))
                        return "h";
                    if (hasWinner(chip, i, j, -1, -1))
                        return "d";
                    if (hasWinner(chip, i, j, 1, 1))
                        return "d";
                    if (hasWinner(chip, i, j, -1, 1))
                        return "d";
                    if (hasWinner(chip, i, j, 1, -1))
                        return "d";
                }
            }
        }
        return "";
    }

    private boolean hasWinner(Chip chip, int row, int col, int rowStep, int colStep) {
        boolean match = false;
        int matches = 0;
        while (row < 6 && row >= 0 && col < 7 && col >= 0) {
            if (getBoard()[row][col] == null)
                break;
            if (!getBoard()[row][col].equals(chip) && match) {
                break;
            } else if (getBoard()[row][col].equals(chip)) {
                match = true;
                matches++;
            }
            row += rowStep;
            col += colStep;
        }
        return matches == 4;
    }

    public String toString() {
        String ss="";
        for (int i = 0; i < 7; i++) {
            if(i==0){
                ss="     1    2    3    4    5    6    7\n";
                continue;
            }
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    ss=ss+i + "    ";
                } else {
                    if (getBoard()[i - 1][j - 1] == null) {
                       ss=ss+"     ";
                    } else {
                       ss=ss+getBoard()[i - 1][j - 1] + "    ";
                    }
                }
            }
            ss=ss+"\n";
        }
        return ss;
    }
}
