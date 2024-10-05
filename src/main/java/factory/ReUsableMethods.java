package factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ReUsableMethods {
	
	
	public static void main(String args[]) {
		getUniqueRandomText();
		getUniqueRandomInteger();
		}
	
	
	public static String getUniqueRandomText() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss sss");
		String stringDate = DateFor.format(date);
		String RandomText = ((stringDate.replace(" ", "")).replace(",", "")).replace(":", "");
		System.out.println(RandomText);	
		return RandomText;
	
	}
	
	public static String  getUniqueRandomInteger() {
		
		int  rand = ThreadLocalRandom.current().nextInt();
		String temp = Integer.toString(rand);
		return temp;
		
		/*
		Date date = new Date();		
		SimpleDateFormat DateFor = new SimpleDateFormat("mm:ss sss");
		String stringDate = DateFor.format(date);
		String RandomText = ((stringDate.replace(" ", "")).replace(",", "")).replace(":", "");
		return RandomText;
		*/
		}}
	
	
	
	

