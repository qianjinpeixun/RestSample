package com.qianjin.java.sss.java2s.a1101.lab3;

public class IceCreamTruckDemo {

    public static void main(String args[]) {

        double price=2.00;
        IceCreamTruck.setCost(price);

        IceCreamTruck truck1 = new IceCreamTruck(1);
        IceCreamTruck truck2 = new IceCreamTruck(2);
        IceCreamTruck truck3 = new IceCreamTruck(3);
        IceCreamTruck truck4 = new IceCreamTruck(4);
        IceCreamTruck truck5 = new IceCreamTruck(5);

        truck1.sale();
        truck1.sale();

        truck2.sale();
        truck3.sale();
        truck4.sale();
        truck5.sale();

        System.out.println("Ice-cream Sales by Truck: \n");
        System.out.println(truck1.toString());
        System.out.println("");
        System.out.println(truck2.toString());
        System.out.println("");
        System.out.println(truck3.toString());
        System.out.println("");
        System.out.println(truck4.toString());
        System.out.println("");
        System.out.println(truck5.toString());
        System.out.println("");
        System.out.println("");
        System.out.println("Total Ice-cream sold by all trucks: " + IceCreamTruck.getTotal());
        System.out.println("");
        System.out.println("Total sales: $" + IceCreamTruck.revenue());
        System.out.println("");
        System.out.println("Average sales per truck: $" + IceCreamTruck.getAverageNumber(5)*price);

    }
}
