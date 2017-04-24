package com.qianjin.java.math.csci3421.assignment3;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.*;

public class GmailClient {

	// http://www.360doc.com/content/14/0823/12/2613145_404024551.shtml

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Please enter the subject:");
		// String email_subject = scanner.nextLine();
		// System.out.println("Please enter the message body in one line:");
		// String email_body = scanner.nextLine();

		String email_subject = "Test from client";
		String email_body = "This is email body";

		String email_from = "qianjincanada@gmail.com";
		String email_to = "jin.qian.canada@gmail.com";

		String mail_host_address = "smtp.gmail.com";
		int mail_host_port = 587;
		// int mail_host_port = 465;

		Socket socket = null;

		try {
			socket = new Socket(mail_host_address, mail_host_port);
			InputStream socketIn = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socketIn));
			OutputStream socketOut = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(socketOut, true);

			String localhost = InetAddress.getLocalHost().getHostName();

			String user_name = "qianjincanada@gmail.com";
			String user_password = "1977Qwert";

			String userName = "cWlhbmppbmNhbmFkYUBnbWFpbC5jb20=";
			String passWord = "MTk3N1F3ZXJ0";

			// String userName = new
			// String(Base64.getEncoder().encode(user_name.getBytes()));
			// String passWord = new String(
			// Base64.getEncoder().encode(user_password.getBytes()));

			SendAndReceive(null, reader, writer);
			SendAndReceive("EHLO " + localhost, reader, writer);
			SendAndReceive("STARTTLS " + localhost, reader, writer);

			SSLSocket sslSocket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(socket,
					socket.getInetAddress().getHostAddress(), socket.getPort(), true);
			InputStream inputStream = sslSocket.getInputStream();
			OutputStream sslSocketOut = sslSocket.getOutputStream();
			PrintWriter sslWriter = new PrintWriter(sslSocketOut, true);
			BufferedReader sslReader = new BufferedReader(new InputStreamReader(inputStream));
			
			SendAndReceive("EHLO " + localhost, sslReader, sslWriter);
			SendAndReceive("AUTH LOGIN", sslReader, sslWriter);
			SendAndReceive(userName, sslReader, sslWriter);
			SendAndReceive(passWord, sslReader, sslWriter);
			SendAndReceive("MAIL FROM:<" + email_from + ">", sslReader, sslWriter);

			SendAndReceive("RCPT TO:<" + email_to + ">", sslReader, sslWriter);
			SendAndReceive("DATA", sslReader, sslWriter);
			writer.println("SUBJECT:" + email_subject + "\r\n");
			writer.println(email_body);
			System.out.println("Client>" + email_body);
			SendAndReceive(".", sslReader, sslWriter);
			SendAndReceive("QUIT", sslReader, sslWriter);

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
