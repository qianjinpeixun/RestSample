package com.qianjin.java.math.csci3421.assignment3;

import java.io.*;
import java.net.*;

public class Mailer {

	 private static BufferedReader reader;
	    private static OutputStream outputStream;

	    public static void main(String args[]) {
	        args = new String[]{"smtp.gmail.com","my_id@gmail.com","your_id@gmail.com"};
	        try {
	            if (args.length == 3) {
	                Socket socket = new Socket(args[0], 465);
	                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                outputStream = socket.getOutputStream();
	                smtpCommand("HELO " + args[0]);
	                smtpCommand("MAIL From: " + args[1]);
	                smtpCommand("RCPT To: " + args[2]);
	                smtpCommand("DATA");
	                smtpCommand("From: " + args[1] + "\nTo: " + args[2] + "\nContent-Type:text/html;\nSubject: test\n MAIL CONTENT \n.\n");
	                System.out.println("\nMessage Sent Successfully to" + args[1].substring(0, args[1].indexOf("@")));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static void smtpCommand(String command) throws Exception {
	        System.out.println(command);
	        reader.readLine();
	        outputStream.write((command + "\r\n").getBytes());
	    }
}
