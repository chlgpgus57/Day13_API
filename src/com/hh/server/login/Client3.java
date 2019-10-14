package com.hh.server.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.iu.n2.network.NetWork;

public class Client3 {

	public static void main(String[] args) {
		Scanner ssc = new Scanner(System.in);
		NetWork nw = new NetWork();
			
			System.out.println("아이디를 입력 해 주세요");
			String id = ssc.next();
			System.out.println("패스워드를 입력 해 주세요");
			String pw = ssc.next();
			
			String msg = id+","+pw;
			
			Socket sk = null;
			
			try {
				sk = new Socket("211.238.142.32",8282);
				nw.send(sk,msg);
				
				
				msg = nw.receive(sk);
				if(msg.equals("1")) {
					
					System.out.println(id+"님 환영합니다");
					
				}else{
					System.out.println("로그인실패");
				}
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	
		//아이디 입력, 패스워드 입력.
		//서버로 전송
	
	}

}
