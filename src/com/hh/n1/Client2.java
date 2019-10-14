package com.hh.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ssc = new Scanner(System.in);
		Socket sc = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		
		try {
			//서버와 연결, 메뉴 번호를 전송하는 코드.
			System.out.println("1번은 점심메뉴, 2번은 저녁메뉴를 추천해드립니다.");
			sc = new Socket("211.238.142.32",8282);
			System.out.println("서버로 전송할 메세지 입력.");
			
			String str = ssc.next();
			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(str+"\r\n");
			bw.flush();
			System.out.println("서버에 전송완료");
			
			//서버에서 메뉴를 받아오는 코드
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			
			//쌍따옴표 프린트하는법 \" \"
			String str2 = br.readLine();
			System.out.println("오늘의 추천메뉴는 \"" + str2 + "\"입니다!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				sc.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
