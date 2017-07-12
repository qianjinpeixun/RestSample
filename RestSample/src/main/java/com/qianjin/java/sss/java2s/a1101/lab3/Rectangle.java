package com.qianjin.java.sss.java2s.a1101.lab3;

public class Rectangle {

    private double width;
    private double height;
    private static char printChar;

    public Rectangle() {
        
        
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public static void setPrintChar(char p) {
        printChar = p;
    }

    public String toString() {
        String rows = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    rows = rows + String.valueOf(printChar);
                } else if (j == 0 || j == width - 1) {
                    rows = rows + String.valueOf(printChar);
                } else {
                    rows = rows + " ";
                }
            }
            rows = rows + "\n";
        }
        return rows;
    }

}
