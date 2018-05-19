package edu.handong.csee.java.chatcounter;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		DataReader DR = new DataReader();
		ArrayList<String> result = DR.getData(args[0]);
		
		
		DataWriter DW = new DataWriter();
		DW.fileWirte(result);
	}

}
