package com.qianjin.java.math.csci3421.assignment3;


import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.*;

public class SSLMailClient {

	
	//https://linuxmeerkat.wordpress.com/2013/10/10/emailing-from-a-gmail-acount-via-telnet/
	//http://www.360doc.com/content/14/0823/12/2613145_404024551.shtml
	
	
	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please enter the subject:");
//		String email_subject = scanner.nextLine();
//		System.out.println("Please enter the message body in one line:");
//		String email_body = scanner.nextLine();
		
		String email_subject ="CSCI Test from client";
		String email_body = "This is email body";
		
		String email_from="qianjincanada@gmail.com";
		String email_to="jin.qian.canada@gmail.com";

		String mail_host_address = "smtp.gmail.com";
		//int mail_host_port = 587;
		int mail_host_port = 465;
		
		//Socket socket = null;

		try {
			  SSLSocket socket = (SSLSocket)((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket("smtp.gmail.com", 465);
			  
			//socket = new Socket(mail_host_address, mail_host_port);
			InputStream socketIn = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socketIn));
			OutputStream socketOut = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(socketOut, true);

			String localhost = InetAddress.getLocalHost().getHostName();

			String user_name = "qianjincanada@gmail.com";
			String user_password = "1977Qwert";
			
			String userName = "cWlhbmppbmNhbmFkYUBnbWFpbC5jb20=";
			String passWord = "MTk3N1F3ZXJ0";

//			String userName = new String(Base64.getEncoder().encode(user_name.getBytes()));
//			String passWord = new String( Base64.getEncoder().encode(user_password.getBytes()));

			
			SendAndReceive(null,reader,writer);
			SendAndReceive("EHLO "+localhost, reader, writer);
			SendAndReceive("AUTH LOGIN "+userName, reader, writer);
			//SendAndReceive(userName,reader,writer);
			SendAndReceive(passWord,reader,writer);
			SendAndReceive("MAIL FROM:<"+email_from+">",reader,writer);
			
			SendAndReceive("RCPT TO:<"+email_to+">",reader, writer);
			SendAndReceive("DATA",reader, writer);
			writer.println("SUBJECT:" + email_subject + "\r\n");
			writer.println(email_body);
			System.out.println("Client>"+email_body);
			SendAndReceive(".",reader,writer);
			SendAndReceive("QUIT",reader,writer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void SendAndReceive(String str, BufferedReader reader, PrintWriter writer) throws IOException {
		if (str != null) {
			System.out.println("Client>" + str);
			writer.flush();
			writer.println(str);
		}
		String response;
		if ((response = reader.readLine()) != null) {
			System.out.println("Server>" + response);
		}
	}

}
