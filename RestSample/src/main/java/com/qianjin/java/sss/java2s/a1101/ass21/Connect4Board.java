package com.qianjin.java.sss.java2s.a1101.ass21;

public class Connect4Board extends Board {

    private static final int rows = 6;
    private static final int cols = 7;
    private final int winCount = 4;
    private String winnerType;
    
    private Chip winChip;

    public Connect4Board() {
        super(rows, cols);
    }

    public boolean add(int col, String colour) {
        Chip chip = new Chip(colour);
        for (int i = rows - 1; i >= 0; i--) {
            if (isEmpty(i, col)) {
                return super.add(i, col, chip);
            }
        }
        return false;
    }

    public String winType() {
        return winnerType;

    }

    public boolean winner() {
        if (hasRowWin()) {
            winnerType = "horizontal";
            return true;
        }

        if (hasColWin()) {
            winnerType = "vertical";
            return true;
        }
        
        if (hasDigWin()) {
            winnerType = "diagonal";
            return true;
        }
        
        if (hasDig2Win()) {
            winnerType = "diagonal2";
            return true;
        }
        
        
        return false;
    }

    private boolean hasColWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {

                    boolean colWin = colHasFour(i, j);
                    if (colWin) {
                        winChip = getBoard()[i][j];
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean hasRowWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {
                    boolean rowWin = rowHasFour(i, j);
                    // System.out.println("rowWin="+rowWin+",i="+i+",j="+j);
                    if (rowWin) {
                        winChip = getBoard()[i][j];
                        return true;
                    }

                }
            }
        }
        return false;
    }
    
    private boolean hasDigWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {
                    boolean diaWin = diaHasFour(i, j);
                    // System.out.println("rowWin="+rowWin+",i="+i+",j="+j);
                    if (diaWin) {
                        winChip = getBoard()[i][j];
                        return true;
                    }

                }
            }
        }
        return false;
    }
    
    private boolean hasDig2Win() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBoard()[i][j] != null) {
                    boolean diaWin = dia2HasFour(i, j);
                    // System.out.println("rowWin="+rowWin+",i="+i+",j="+j);
                    if (diaWin) {
                        winChip = getBoard()[i][j];
                        return true;
                    }

                }
            }
        }
        return false;
    }

    
    private boolean dia2HasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        if (row < rows - 1 && col >0)
            for (int i = row + 1, j = col - 1; i < rows && j>0; i++, j--) {
                if (getBoard()[i][j] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }

        if (row > 0 && col <cols-1)
            for (int i = row - 1, j = col + 1; i > 0 && j <cols; i--, j++) {
                if (getBoard()[i][j] == null) {
                    break;
                }

                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }
        if (colCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    private boolean diaHasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        if (row < rows - 1 && col < cols - 1)
            for (int i = row + 1, j = col + 1; i < rows && j < cols; i++, j++) {
                if (getBoard()[i][j] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }

        if (row > 0 && col > 0)
            for (int i = row - 1, j = col - 1; i > 0 && j > 0; i--, j--) {
                if (getBoard()[i][j] == null) {
                    break;
                }

                if (getBoard()[row][col].equals(getBoard()[i][j])) {
                    colCount++;
                } else {
                    break;
                }
            }
        if (colCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    private boolean colHasFour(int row, int col) {
        boolean four = false;
        int colCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        if (col < cols - 1) {
            for (int i = col + 1; i < cols; i++) {
                if (getBoard()[row][i] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[row][i])) {
                    colCount++;
                } else {
                    break;
                }
            }
        }
        if (col > 0) {
            for (int i = col - 1; i > 0; i--) {
                if (getBoard()[row][i] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[row][i])) {
                    colCount++;
                } else {
                    break;
                }
            }
        }
        // System.out.println("rowCount="+rowCount);
        if (colCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    private boolean rowHasFour(int row, int col) {
        boolean four = false;
        int rowCount = 0;
        if (getBoard()[row][col] == null)
            return false;
        rowCount = 0;
        if (row < rows - 1) {
            for (int i = row + 1; i < rows; i++) {
                if (getBoard()[i][col] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][col])) {
                    rowCount++;
                } else {
                    break;
                }
            }
        }
        if (row > 0) {
            for (int i = row - 1; i > 0; i--) {
                if (getBoard()[i][col] == null) {
                    break;
                }
                if (getBoard()[row][col].equals(getBoard()[i][col])) {
                    rowCount++;
                } else {
                    break;
                }
            }
        }
        // System.out.println("rowCount="+rowCount);
        if (rowCount >= (winCount - 1)) {
            four = true;
        }
        return four;
    }

    public String toString() {
        System.out.println();
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < cols + 1; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                    continue;
                }
                if (i == 0) {
                    if (j > 0) {
                        System.out.print(j + " ");
                    }
                    if (j == 8) {
                        System.out.println();
                    }
                } else {
                    if (j > 0) {
                        if (!isEmpty(i - 1, j - 1)) {
                            System.out.print(getBoard()[i - 1][j - 1] + " ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                if (j == 0) {
                    System.out.print(i + " ");
                }

            }
            System.out.println();
        }
        return "";
    }
}
