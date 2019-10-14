package com.iu.n2;

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
import java.util.StringTokenizer;

import com.iu.n2.Food.MenuMaker;
import com.iu.n2.network.NetWork;
import com.sun.glass.ui.Menu;


public class Server2_1 {

	
	public static void main(String [] args) {
		NetWork  nw = new NetWork();
		MenuMaker m = new MenuMaker();
		m.init();
		
			try {
				ServerSocket ss = new ServerSocket(8282);
				Socket sc = ss.accept();
				String select = nw.receive(sc);
				String menu = m.selectMenu(select);

				nw.send(sc, menu);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}	
	
	
}
