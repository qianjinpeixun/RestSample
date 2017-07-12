package com.qianjin.java.sss.java2s.a1101.ass23;

public class Board {

    private int rows;
    private int cols;
    private Chip[][] board;

    public Board(int r, int c) {
        this.rows = r;
        this.cols = c;
        board = new Chip[r][c];
    }

    public boolean isEmpty(int r, int c) {
        boolean empty = false;
        if (board[r][c] == null)
            empty = true;
        else
            empty = false;
        return empty;
    }

    public boolean add(int r, int c, Chip chip) {
        if (isEmpty(r,c)==false)
            return false;
        else {
            board[r][c] = chip;
            return true;
        }
    }

    public int getRows() {
        return rows;
    }


    public int getCols() {
        return cols;
    }


    public Chip getChip(int r,int c) {
        return board[r][c];
    }

   

}
