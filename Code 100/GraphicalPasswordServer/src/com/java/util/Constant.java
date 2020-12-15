package com.java.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.java.bean.InnerOuterBean;


public class Constant {

	private static int PASSWORD_LENGTH=8;
	private static HashMap<String, ArrayList<InnerOuterBean>> map;
	private static String CHAR_L="abcdef";
	private static String CHAR_D="12345678";
	private static String CHAR_S="@#";
	
	
	public static HashMap<String, ArrayList<InnerOuterBean>> populateMap()
	{
		map=new HashMap<String,ArrayList<InnerOuterBean>>();
		
		ArrayList<InnerOuterBean> colorArr;
		
		colorArr=CharacterArrayClass.populateCharArrayForRed();
		
		map.put("#ff0000", colorArr);
		
		colorArr=CharacterArrayClass.populateCharArrayForYellow();
		map.put("#ffff00",colorArr);

		colorArr=CharacterArrayClass.populateCharArrayForGreen();
		map.put("#00ff00",colorArr);
		
		colorArr=CharacterArrayClass.populateCharArrayForBlue();
		map.put("#0000ff",colorArr);
		
		colorArr=CharacterArrayClass.populateCharArrayForViolet();
		map.put("#bf00ff",colorArr);
		
		colorArr=CharacterArrayClass.populateCharArrayForPink();
		map.put("#ff00bf",colorArr);
		
		colorArr=CharacterArrayClass.populateCharArrayForGrey();
		map.put("#8c7373",colorArr);
		
		colorArr=CharacterArrayClass.populateCharArrayForBlack();
		map.put("#000000",colorArr);
		
		return map;
	}
	
	public static int getRandomNumber(int index) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(index-1);
        return randomInt;
    }
	
	
	
	public static String generateRandomPassword(){
        StringBuffer randPass = new StringBuffer();
        Random r = new Random();
        char ch;
        
        randPass.append(CHAR_L.charAt(r.nextInt(CHAR_L.length())));
        randPass.append(CHAR_L.charAt(r.nextInt(CHAR_L.length())));
        randPass.append(CHAR_D.charAt(r.nextInt(CHAR_D.length())));
        randPass.append(CHAR_S.charAt(r.nextInt(CHAR_S.length())));
        
        System.out.println("before:"+randPass.toString());
        
        for(int i=0; i<PASSWORD_LENGTH-4; i++){
            if(randPass.length() < PASSWORD_LENGTH )
            {
                ch = CHAR_L.charAt(r.nextInt(CHAR_L.length()));
                 randPass.append(ch);
            }
            if(randPass.length() < PASSWORD_LENGTH )
            {
                 ch = CHAR_D.charAt(r.nextInt(CHAR_D.length()));
                 randPass.append(ch);
            }
        }
        return randPass.toString();
    }
	
	
	
	public static void main(String[] args) {
		
		String str=generateRandomPassword();
		System.out.println("str:"+str);
		
		
	}
}
