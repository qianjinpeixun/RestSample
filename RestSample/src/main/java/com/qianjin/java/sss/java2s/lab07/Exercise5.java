package com.qianjin.java.sss.java2s.lab07;

import javax.swing.JOptionPane;

public class Exercise5 {

    public static void main(String[] args) {

        String result=JOptionPane.showInputDialog("Please enter an interger for a grid of squares:");  
        int value=Integer.parseInt(result);
        String s=makeGrid(value);
        System.out.println(s);
    }

    /*
     * The method returns a String representing a single line that is formed
     * from the two characters given as parameters.
     * 
     * takes one integer and two char parameters (element and separator)
     * 
     * returns a String
     */
    public static String makeLine(int value, char c1, char c2) {
        String result = "";
        result = result + c2;
        for (int i = 0; i < value; i++) {
            result = result + c1 + c2;
        }
        return result;

    }

    /*
     * The method returns a String representing a grid of squares, made up of –
     * (hyphen), | (vertical line), and space characters.
     * 
     * takes one integer as a parameter
     * 
     * returns a String
     */
    public static String makeGrid(int value) {
        String result = "";
        String line1="";
        String line2="";
        line1=makeLine(value,'-',' ');
        line2=makeLine(value,' ','|');
        
        for(int i=0;i<value;i++){
            result=result+line1+"\n"+line2+"\n";
        }
        result=result+line1+"\n";
        return result;
    }

}
