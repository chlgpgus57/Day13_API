package com.iu.n2.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class NetWork {

	public String receive(Socket sc) throws IOException {
		
		InputStream is = sc.getInputStream();
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		String msg = br.readLine();
		return msg;
	}
	
	
	
	public void send(Socket sc, String msg) throws IOException {
		
		OutputStream os = sc.getOutputStream();
		OutputStreamWriter ow = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(ow);
		bw.write(msg+"\r\n");
		bw.flush();
		
	}
	
	
	
	
}







