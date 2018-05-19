package edu.handong.csee.java.chatcounter;

import java.util.ArrayList;

public class MessageCounter {
	public ArrayList<String> messageCount(ArrayList<String> resultF){
		ArrayList<String> people = countName(resultF);
		ArrayList<String> resultC = countNumber(resultF, people);
		return resultC;
	}
	
	public ArrayList<String> countName(ArrayList<String> resultF) {
		ArrayList<String> people = new ArrayList<String>();
		//read resultF
		//while resultF is null
			//if there is not exist the name in the arraylist named people 
				//add the name in arraylist person
			//already exist the name
				//don't anything
			//point resultF to next resultF
		return people;
	}
	
	public ArrayList<String> countNumber(ArrayList<String> reusultF, ArrayList<String> people){
		ArrayList<String> resultC  = new ArrayList<String>();
		int count = 0;
		//while people ArrayList is NULL 
			//while resultF is null
				//set count to 0;
				//find name in point Arraylist of resultF
				//if the resultF's name same as people's name
					//add count 1
				//point next resultF
			//add reulstC ArrayList the name, count
			//point next in people ArrayList
		return resultC;
	}
}
