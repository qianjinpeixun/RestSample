package com.qianjin.java.sss.java2s.a1101.ass12;

/*
 * Assignment1, Question 2 CSCI 1101 Movie.java track the details of the movie
 * July 6, 2017 Yiping Liang B00744822 This is entirely my own work.
 */
public class Movie {
    private String title;
    private String publisher;
    private int year;
    private double runningTime;
    private double budget;

    public Movie() {

    }

    public Movie(String t, String p, int y, double rt, double b) {
        this.title = t;
        this.publisher = p;
        this.year = y;
        this.runningTime = rt;
        this.budget = b;
    }

    // set methods for all the attributes
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRunningTime(double runningTime) {
        this.runningTime = runningTime;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    // get methods for all the attributes
    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public double getRunningTime() {
        return runningTime;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isLonger(Movie m) { // compares this Movie's running time
                                       // with another Movie's running time
        if (this.getRunningTime() > m.getRunningTime())
            return true;
        else
            return false;

    }

    public boolean isEqual(Movie m) {//// checks to see if this Movie's
                                     //// attributes are the same as another
                                     //// Movie's
        if (this.getBudget() == m.getBudget() && this.getPublisher().equals(m.getPublisher()) && this.getRunningTime() == m.getRunningTime() && this.getTitle().equals(m.getTitle())
                && this.getYear() == m.getYear())
            return true;
        else
            return false;
    }

    public Movie copy() {// creates a copy of this Movie and returns it
        Movie a = new Movie(this.getTitle(), this.getPublisher(), this.getYear(), this.getRunningTime(), this.getBudget());

        return a;

    }

    public String toString() {
        return "Movie title is " + title + ". Publisher is " + publisher + ". The year of the movie is " + year + ".";
    }
}
