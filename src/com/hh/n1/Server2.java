package com.hh.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server2 {
	
public static void main (String [] args) {	

		
		//1. 점심매뉴중에 하나 골라주기
		//2. 저녁메뉴중에 하나 골라주기
		Random rand = new Random();
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		File file = null;
		File file2 = null;
		FileReader fr = null;
		//FileReader fr2 = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		ArrayList<String> lun = new ArrayList<String>();
		ArrayList<String> din = new ArrayList<String>();

		String lunch =null;
		String dinner = null;
		
		file = new File("c:\\choihyehyeon\\test","lunch.txt");
		file2 = new File("c:\\choihyehyeon\\test","dinner.txt");
		
		
		
		try {
			//클라이언트와 연결해서 클라이언트한테 받은 메세지 출력하기
			ss = new ServerSocket(8282);
			System.out.println("클라이언트 접속 받을 준비 중");
			sc = ss.accept();
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String str = br.readLine();			
			
			//파일읽어와서 랜덤찍기
			if(str.equals("1")) {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				
				while((lunch = br.readLine()) != null) {
						//파일에서 -랑 공백 제거해서 찍기.			
						lunch.trim();
						String [] lun2 = lunch.split("-"); //lun2 = 런치를 잘라서 하나하나 넣을 배열
						
						for(int i=0; i< lun2.length ; i++) {
							lun.add(lun2[i]); //lun = lun2에서 자른 문자열을 받을 어레이리스트
						}
				}
				
				//저중에서 랜덤으로 하나 골라주기
				int lunchRandom = rand.nextInt(lun.size()); //lun어레이리스트의 인덱스번호를 받을 랜덤번호
				bw.write(lun.get(lunchRandom)+"\r\n"); //lun.get(lunchRandom) lun어레이리스트에서 런치렌덤인트값인덱스에 해당하는 문자를 출력
				bw.flush();
				
				System.out.println("클라이언트에 메뉴 추천 완료");
				
			}else if(str.equals("2")) {
				
				fr = new FileReader(file2);
				br = new BufferedReader(fr);
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				
				while((dinner = br.readLine()) != null) {
					
					dinner.trim();
					String [] din2 = dinner.split(",");
					
/**					StringTokenizer st = new StringTokenizer(str,",");
					while(st.hasMoreTokens()) {
						din.add(st.nextToken().trim());
					}														*/
					
					for(int i=0; i<din2.length ; i++) {
						din.add(din2[i]);
					}

				}
				
				int dinnerRandom = rand.nextInt(din.size());
				bw.write(din.get(dinnerRandom)+"\r\n");
				bw.flush();
				
				System.out.println("클라이언트에 추천 완료");
				
			}else {
				System.out.println("1번이나 2번만 선택하세요.");
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				br.close();
				fr.close();
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
	
