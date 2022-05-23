package Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
	public static void main(String[] args) {
		try {
			
			ServerSocket serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			System.out.println("Ket noi thanh cong");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
