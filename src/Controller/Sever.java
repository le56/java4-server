package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import Model.Account;
import Service.AccountService;

public class Sever {
	private static DataInputStream dataInputStream;
	private static DataOutputStream dataOutputStream;
	public static void main(String[] args) {
		try {
			
			ServerSocket serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			System.out.println("Ket noi thanh cong");
			
			try {
				dataInputStream= new DataInputStream(socket.getInputStream());
				dataOutputStream= new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while (true) {
				String messages = dataInputStream.readUTF();
				String[] messagesSlip = messages.split(",");
				if(messagesSlip[0].equals("request-login")) {
					String string = Decryption.getAccount(messagesSlip[1]);
					String[] account = string.split(",");
					Account acc = new Account(account[0].trim(), account[1].trim());
					
					Boolean check = AccountService.checkAccount(acc.getNameAccount(), acc.getPassword());
					
					System.out.println(check);
					if(check==true) {
						dataOutputStream.writeUTF("login-succses,Le Khanh Duong");
						dataOutputStream.flush();
					}
					else {
						dataOutputStream.writeUTF("login-false");
						dataOutputStream.flush();
					}
				}
				if(messagesSlip[0].trim().equals("request-addUser")) {
					String string = Decryption.getAccount(messages);
					System.out.println(string);
				}
	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
