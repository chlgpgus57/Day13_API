package com.iu.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	
	public static void main(String[] args) {

		Socket sc = null;
		ServerSocket ss = null;
		InputStream is = null;
		InputStreamReader ir = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);
		BufferedReader br = null;
		boolean check = true;
		//1단계
		
		while(check) {
			
			try {
				sc = new Socket("211.238.142.33", 8282);
				System.out.println("서버로 전송할 메세지 입력");
				String str = ssc.next();
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);//char
				bw = new BufferedWriter(ow);
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("서버에 전송완료");
				
				if(str.toUpperCase().equals("Q")) {
					System.out.println("종료.");
					break;
				}
				
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				String str2 = br.readLine();
				
				if(str2.toUpperCase().equals("Q")) {
					System.out.println("종료.");
					break;
				}
				
				System.out.println(str2);
				System.out.println("서버에서 전송받기 완료.");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally {
				
				try {
					
					bw.close();
					ow.close();
					os.close();
					sc.close();
					br.close();
					ir.close();
					is.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
