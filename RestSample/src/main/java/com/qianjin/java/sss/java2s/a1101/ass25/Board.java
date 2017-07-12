package com.qianjin.java.sss.java2s.a1101.ass25;

public class Board {

    private int rows;
    private int cols;
    private Chip[][] board;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Chip[rows][cols];
    }

    public boolean isEmpty(int r, int c) {
        return (board[r][c] == null);
    }

    public boolean add(int r, int c, Chip chip) {
        if (!isEmpty(r, c))
            return false;
        else {
            board[r][c] = chip;
            return true;
        }
    }

    public Chip[][] getBoard() {
        return board;
    }

    public boolean compareChips(int row1, int col1, Chip chip) {
        Chip chip1 = board[row1][col1];
        if (chip1 == null)
            return false;
        if (chip == null)
            return false;
        return chip1.equals(chip);
    }

}
