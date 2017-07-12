package com.qianjin.java.sss.java2s.a1101.ass12;

/*
 * Assignment1, Question 2 CSCI 1101 MovieDemo.java is a test program for the
 * Movie class. It tests all the method are works in Movie class. July 6, 2017
 * Yiping Liang B00744822 This is entirely my own work.
 */
public class MovieDemo {

    public static void main(String[] args) {
        Movie Resi = new Movie("Resident Evil", " Americ", 2017, 135, 2400000);
        Movie Hanni = new Movie("Never die", "THSO", 2017, 125, 2400000);// get
        Movie newmovie = Resi.copy();
        Movie neww = Hanni.copy();
        System.out.println(Resi.isLonger(Hanni));
        System.out.println(Resi.isEqual(Hanni));
        System.out.println(Resi);// toString method
        System.out.println(Hanni);
        System.out.println(newmovie);
        System.out.println(neww);// copy method

    }

}
