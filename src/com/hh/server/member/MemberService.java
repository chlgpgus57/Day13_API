package com.hh.server.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;




public class MemberService {
	Scanner ssc = new Scanner(System.in);

	private HashMap<String, Member> map;
	
	private  Member member;
	//init 메서드
	//파일의 내용을 읽어서 파싱작업.

public void init() {
	
	this.map = new HashMap<String, Member>(); //초기에 널값만 있기 때문에 새로 객체 생성
	
	File file = null;
	FileReader fr = null;
	InputStream is = null;
	InputStreamReader ir = null;
	BufferedReader br = null;
	String members = null;
	boolean check = true;

	file = new File("c:\\choihyehyeon\\test","member.txt");

	
	try {
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	
		while(check) {
			String str = br.readLine();
			if(str==null) {
				break;
			}
			str.trim();
			StringTokenizer st = new StringTokenizer(str,",");

			while(st.hasMoreTokens()) {
				Member member = new Member();
				member.setId(st.nextToken().trim()); //id
				member.setPw(st.nextToken().trim()); //pw
				map.put(member.getId(), member);
				map.put(member.getPw(), member);
			}
	
		} //밖 while 끝
//		
//		Iterator<String> it = map.keySet().iterator();
//		while (it.hasNext()) {
//			String k = it.next();//꺼내오기
//			Member m = map.get(k);
//			System.out.println(m.getId());
//			System.out.println(m.getPw());
//		}
//		
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	//memberLogin 메서드
	//id, pw 매개변수로 받아서 로그인 유무 검증
	public Member memberLogin(Member member) {

		Member m = map.get(member.getId());
		
		if(m!=null) {
		
			if(m.getPw().equals(member.getPw())) {
				////추가정보대입..나중에
				
			}else {
				
				m = null;
			}
		}
		
		return m;
	}
}
