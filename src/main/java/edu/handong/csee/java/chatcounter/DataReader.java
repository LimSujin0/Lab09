package edu.handong.csee.java.chatcounter;

import java.io.File;
import java.util.ArrayList;

public class DataReader {
	
	public ArrayList<String> getData(String strDir){
		File myDir = getDirectory(strDir);
		
		File[] files = getListOfFiles(myDir);
		
		ArrayList<String> messages = readFiles(files);
		
		return messages;
	}
	
	public File getDirectory(String fDir) {
		File myDirectory = new File(fDir);
		return myDirectory;
	}
	
	public File[] getListOfFiles(File dataDir) {
		return dataDir.listFiles();
	}
	
	public ArrayList<String> readFiles(File[] files){
		ArrayList<String> message = new ArrayList<String>();
		//read file logic
		return message;
	}

}
