package com.qianjin.java.sss.java2s.a1101.lab3;

public class RectangleDemo {

    public static void main(String args[]) {

        Rectangle.setPrintChar('*');
        Rectangle r1 = new Rectangle(3, 3);
        Rectangle r2 = new Rectangle(5, 4);
        System.out.println("The area of Rectangle 1 is: " + r1.getArea());
        System.out.println(r1.toString());
        System.out.println("");
        System.out.println("The area of Rectangle 2 is: " + r2.getArea());
        System.out.println(r2.toString());

        r1.setPrintChar('%');
        r2.setPrintChar('+');
        System.out.println("The area of Rectangle 1 is: " + r1.getArea());
        System.out.println(r1.toString());
        System.out.println("");
        System.out.println("The area of Rectangle 2 is: " + r2.getArea());
        System.out.println(r2.toString());
    }
}
