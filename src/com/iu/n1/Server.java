package com.iu.n1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		Scanner ssc = new Scanner(System.in);
		ServerSocket ss = null;
		Socket  sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		
		try {
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비중");
			sc = ss.accept();
			is = sc.getInputStream(); //byte
			ir = new InputStreamReader(is); //char
			br = new BufferedReader(ir);
			String str = br.readLine();
			System.out.println(str);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				
				br.close();
				ir.close();
				is.close();
				sc.close();
				ss.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
		
	}

}
