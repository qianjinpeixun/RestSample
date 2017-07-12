package com.qianjin.java.sss.java2s.a1101.lab3;

public class IceCreamTruck {

    private int truckID;
    private int soldIce;
    private static int soldTotal;
    private static double price;

    public IceCreamTruck(int truckID) {
        this.truckID = truckID;
        soldIce = 0;
    }

    public void sale() {
        soldIce++;
        soldTotal++;
    }

    public String toString() {
        return "Ice-creams sold by truck" + truckID + ": " + soldIce + " Total Sales for truck" + truckID + ": $" + soldIce * price;
    }

    public static void setCost(double cost) {
        price = cost;
    }

    public static int getTotal() {
        return soldTotal;
    }

    public static double getAverageNumber(int count) {
        double ave = (double) soldTotal / count;
        return ave;
    }

    public static double revenue() {
        return soldTotal * price;
    }
}
