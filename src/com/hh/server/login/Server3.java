package com.hh.server.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.hh.server.member.Member;
import com.hh.server.member.MemberService;
import com.iu.n2.network.NetWork;

public class Server3 {

	public static void main(String[] args) {
		//클라이언트의 문자를 받아서 아디, 비번을 분리해서 구분하고
		//설정값과 맞다면 로그인 성공실패 여부를 클라이언트에게 보내준다.
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		MemberService memberservice = new MemberService();
		NetWork nw = new NetWork();
	
		try {
			memberservice.init();
			ss = new ServerSocket(8282);
			sc = new Socket();
			sc = ss.accept();
			String msg = nw.receive(sc); //id,pw 로 받을 것임			
			String [] info = msg.split(",");
			Member member = new Member();
			member.setId(info[0]);
			member.setPw(info[1]);
			
			member = memberservice.memberLogin(member);
			msg = "0"; //로그인 실패
			if(member != null ) {
			
				msg = "1"; //로그인 성공
			}
	
			nw.send(sc, msg);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
