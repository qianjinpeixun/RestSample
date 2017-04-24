package com.qianjin.java.math.csci3421.assignment3;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.*;

/**
 * A simple mail client with the ability to send an email over SMTP protocol.
 * Before programming, all the SMTP commands have been checked and verified in a ubuntu Linux environment as below:
 * 1.  sudo apt-get install telnet-ssl 
 * 2.  telnet -z ssl smtp.gmail.com 465
 * 3.  HELO local
 * 4.  AUTH LOGIN Y3NjaTM0MjFAZ21haWwuY29t  (base64 for the username: csci3421@gmail.com)
 * 5.  MTk4MFF3ZXJ0							(base64 for the password)
 * 6.  MAIL FROM:<csci3421@gmail.com>
 * 7.  RCPT TO:<smu3421@gmail.com>
 * 8.  DATA
 * 9.  Subject: Csci3421 assignment 3
 * 10. This is test body
 * 11. .
 * 12. QUIT
 * 
 * the screen shot of the above can be found in the attached assignment documents.
 * 
 * Generally, this class uses the SMTP commands to communicate with gmail smtp server in order to send a test email.
 * the default sender is csci3421@gmail.com
 * the default receiver is:smu3421@gmail.com
 * in order to test smoothly, both of the password is 1980Qwert
 * 
 * According to the introduction in the class, there are three types of smtp server:simple, SSl or TLS. basiclly, 25 port is for simple mode.
 * 465 is for SSL, 587 is for TLS.
 * According to the google's document, this assignment choose to SSL mode to test.
 * In order to use SSL, create a SSL socket to communicate with gmail.
 * 
 * In order to test the telnet-ssl command in Linux and run java program, an online ide was used in this assignment: https://codeanywhere.com/editor
 * 
 */

public class MailClient {

	/**
	 * In order to practice the basic theory of SMTP protocol, no other class or methods are introduced in the class
	 * all of the logic were fixed in the main method
	 * 
	 */
	public static void main(String[] args) {

		System.out.println("This is a test program for sending an email:");
		System.out.println("An emial will be sent to smu3421@gmail.com");
		System.out.println("The sender will be fixed with csci3421@gmail.com");
		System.out.println("Please enter the subject of the email:");
		/*
		 * In order to simple the process, just need user to enter the email
		 * subject the body message will be fixed in a String variable
		 */
		Scanner scanner = new Scanner(System.in);
		String email_subject = scanner.nextLine();
		String email_body = "This is a test email for CSCI 3421 assignment 3!";

		System.out.println("Please enter the receiver emaill address:");
		String email_to = scanner.nextLine();

		/*
		 * the default sender and receiver have been fixed as well
		 */
		String email_from = "csci3421@gmail.com";
		if (email_to == null || email_to.length() < 3)
			email_to = "smu3421@gmail.com";

		String mail_host_address = "smtp.gmail.com";
		int mail_host_port = 465;

		/*
		 * According to the gmail document, the AUTH LOGIN needs username and
		 * password with Base64 encoding format In order to simple the process,
		 * put the base64 encoding in a fixed string variable as below:
		 */
		String userName = "Y3NjaTM0MjFAZ21haWwuY29t";
		String passWord = "MTk4MFF3ZXJ0";

		/*
		 * both of the account password is 1980Qwert
		 */

		try {
			// Firstly, creating a SSL socket for gmail
			SSLSocket socket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault())
					.createSocket(mail_host_address, mail_host_port);

			InputStream socketIn = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socketIn));
			OutputStream socketOut = socket.getOutputStream();

			// localhost will be used in HELO command
			String localhost = InetAddress.getLocalHost().getHostName();

			// Strat to communicate with SMTPServer, first step is handshake
			System.out.println(reader.readLine());
			socketOut.write(("HELO " + localhost + "\r\n").getBytes());

			// then begin to check username and password
			System.out.println(reader.readLine());
			socketOut.write(("AUTH LOGIN " + userName + "\r\n").getBytes());

			System.out.println(reader.readLine());
			socketOut.write((passWord + "\r\n").getBytes());

			// set the sender
			System.out.println(reader.readLine());
			socketOut.write(("MAIL FROM:<" + email_from + ">" + "\r\n").getBytes());

			// set the receiver
			System.out.println(reader.readLine());
			socketOut.write(("RCPT TO:<" + email_to + ">" + "\r\n").getBytes());

			// begin to set message
			System.out.println(reader.readLine());
			socketOut.write(("DATA" + "\r\n").getBytes());

			System.out.println(reader.readLine());
			socketOut.write(("SUBJECT:" + email_subject + "\r\n").getBytes());
			socketOut.write((email_body + "\r\n").getBytes());
			socketOut.write(("." + "\r\n").getBytes());

			// prepare to finish
			System.out.println(reader.readLine());
			socketOut.write(("QUIT" + "\r\n").getBytes());
			System.out.println(reader.readLine());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("An email with this subject has been sent to smu3421@gmail.com.");
		System.out.println("The body message will be: This is a test email for CSCI 3421 assignment 3!");
		System.out.println("Please check the inbox!");

		/*
		 * The screen shot of this program's running result can be found in the
		 * answer document. A tested confirm email can be found as well.
		 */
	}

}
