package com.iu.n2;

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

public class Client2_1 {

	public static void main(String[] args) {

		Scanner ssc = new Scanner(System.in);
		NetWork nw = new NetWork();
		
		
		try {
			
			Socket sc = new Socket("211.238.142.32",8282);
			System.out.println("1. 점심메뉴");
			System.out.println("2. 저녁메뉴");
			String select = ssc.next();
			
			nw.send(sc, select);
			
			select = nw.receive(sc);
			System.out.println(select);
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 
		}

	}

}
