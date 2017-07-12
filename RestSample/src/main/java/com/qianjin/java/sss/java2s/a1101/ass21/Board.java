package com.qianjin.java.sss.java2s.a1101.ass21;

public class Board {

    private int rows;
    private int cols;
    private Chip[][] board;
    
    

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Chip[][] getBoard() {
        return board;
    }

    public void setBoard(Chip[][] board) {
        this.board = board;
    }

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols =cols;
        board=new Chip[rows][cols];
        
    }

    public boolean isEmpty(int row, int col) {
        if (board[row][col] == null)
            return true;
        else
            return false;
    }

    public boolean add(int row, int col, Chip chip) {
        if (isEmpty(row, col)) {
            board[row][col] = chip;
            return true;
        } else {
            return false;
        }
    }

}
