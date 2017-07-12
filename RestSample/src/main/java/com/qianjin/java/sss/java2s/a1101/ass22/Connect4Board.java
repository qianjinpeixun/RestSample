package com.qianjin.java.sss.java2s.a1101.ass22;

public class Connect4Board extends Board {

    private int currentRow;
    private int currentCol;

    public Connect4Board() {
        super(6, 7);
    }

    public boolean add(int c, String colour) {
        c = c - 1;
        Chip chip = new Chip(colour);
        if (!isEmpty(0, c))
            return false;
        int row = 0;
        for (int i = 0; i < 6; i++) {
            row = i;
            if (!isEmpty(i, c)) {
                row = i - 1;
                break;
            }
        }
        boolean a = super.add(row, c, chip);
        currentRow = row;
        currentCol = c;
        return a;
    }

    private boolean checkH() {
        int left = currentCol;
        int right = currentCol;
        for (int i = currentCol - 1; i >= 0; i--) {
            if (i >= 0) {
                if (getBoard()[currentRow][i] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[currentRow][i])) {
                    left = i;
                } else {
                    break;
                }
            }
        }

        for (int i = currentCol + 1; i <= 7; i++) {
            if (i <= 6) {
                if (getBoard()[currentRow][i] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[currentRow][i])) {
                    right = i;
                } else {
                    break;
                }
            }
        }
        if ((right - left) == 3)
            return true;
        else
            return false;
    }

    private boolean checkV() {

        int top = currentRow;
        int bottom = currentRow;
        for (int i = currentRow - 1; i >= 0; i--) {
            if (i >= 0) {
                if (getBoard()[i][currentCol] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[i][currentCol])) {
                    top = i;
                } else {
                    break;
                }
            }
        }

        for (int i = currentRow + 1; i <= 6; i++) {
            if (i <= 5) {
                if (getBoard()[i][currentCol] == null) {
                    break;
                }
                if (getBoard()[currentRow][currentCol].equals(getBoard()[i][currentCol])) {
                    bottom = i;
                } else {
                    break;
                }
            }
        }
        if ((bottom - top) == 3)
            return true;
        else
            return false;
    }

    private boolean checkD() {
        int top = 0;
        int bottom = 0;
        int newRow = currentRow;
        int newCol = currentCol;
        for (int i = currentRow; i >= 0; i--) {
            newRow--;
            newCol--;
            if (newRow < 0 || newCol < 0) {
                break;
            }
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    top++;
                } else {
                    break;
                }
            }
        }

        newRow = currentRow;
        newCol = currentCol;
        for (int i = currentRow; i < 7; i++) {
            newRow++;
            newCol++;
            if (newRow > 5 || newCol > 6)
                break;
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    bottom++;
                } else {
                    break;
                }
            }
        }

        if ((top + bottom) == 3)
            return true;

        top = 0;
        bottom = 0;
        newRow = currentRow;
        newCol = currentCol;
        for (int i = currentRow; i >= 0; i--) {
            newRow--;
            newCol++;
            if (newRow < 0 || newCol > 6) {
                break;
            }
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    top++;
                } else {
                    break;
                }
            }
        }

        newRow = currentRow;
        newCol = currentCol;
        for (int i = currentRow; i < 7; i++) {
            newRow++;
            newCol--;
            if (newRow > 5 || newCol < 0)
                break;
            if (getBoard()[newRow][newCol] == null)
                break;
            else {
                if (getBoard()[currentRow][currentCol].equals(getBoard()[newRow][newCol])) {
                    bottom++;
                } else {
                    break;
                }
            }
        }

        if ((top + bottom) == 3)
            return true;

        return false;
    }

    public String winType() {
        if (checkH())
            return "H";
        if (checkV())
            return "V";
        if (checkD())
            return "D";
        return "N";
    }

    public boolean winner() {
        String s = winType();
        if (s.equals("H") || s.equals("V") || s.equals("D"))
            return true;
        else
            return false;
    }

    public String toString() {
        String s = "       1  2  3  4  5  6  7\n";
        for (int i = 0; i < 6; i++) {
            s = s + "    "+String.valueOf(i + 1) + "  ";
            for (int j = 0; j < 7; j++) {
                if (getBoard()[i][j] == null) {
                    s = s + "   ";
                } else {
                    s = s + getBoard()[i][j].toString() + "  ";
                }
            }
            s = s + "\n\n";
        }
        return s;
    }
}
