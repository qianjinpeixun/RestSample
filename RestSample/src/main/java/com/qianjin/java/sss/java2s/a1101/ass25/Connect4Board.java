package com.qianjin.java.sss.java2s.a1101.ass25;

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
        if (ret.equals("H") || ret.equals("V") || ret.equals("D"))
            return true;
        else
            return false;
    }

    public String winType() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Chip chip = getBoard()[i][j];
                if (chip != null) {
                    String ss = hasWinner(chip);
                    if (!ss.equals(""))
                        return ss;
                }
            }
        }
        return "";
    }

    private String hasWinner(Chip chip) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (compareChips(i, j, chip) && compareChips(i, j + 1, chip) && compareChips(i, j + 2, chip) && compareChips(i, j + 3, chip)) {
                    return "H";
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 5; j >= 3; j--) {
                if (compareChips(j, i, chip) && compareChips(j - 1, i, chip) && compareChips(j - 2, i, chip) && compareChips(j - 3, i, chip)) {
                    return "V";
                }
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (compareChips(i, j, chip) && compareChips(i - 1, j + 1, chip) && compareChips(i - 2, j + 2, chip) && compareChips(i - 3, j + 3, chip)) {
                    return "D";
                }
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 7; j++) {
                if (compareChips(i, j, chip) && compareChips(i - 1, j - 1, chip) && compareChips(i - 2, j - 2, chip) && compareChips(i - 3, j - 3, chip)) {
                    return "D";
                }
            }
        }

        return "";

    }

    public String toString() {
        String ss = "";
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                ss = "     1    2    3    4    5    6    7\n";
                continue;
            }
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    ss = ss + i + "    ";
                } else {
                    if (getBoard()[i - 1][j - 1] == null) {
                        ss = ss + "     ";
                    } else {
                        ss = ss + getBoard()[i - 1][j - 1] + "    ";
                    }
                }
            }
            ss = ss + "\n";
        }
        return ss;
    }
}
