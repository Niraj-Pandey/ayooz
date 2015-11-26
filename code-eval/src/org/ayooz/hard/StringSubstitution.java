package org.ayooz.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringSubstitution {
    
	public static String substitutString(String s,String[] items){
		String res=s;
		for(int i=0;i<items.length;i+=2){
			res=res.replaceAll(items[i], "R"+(i+2));
		}
		for(int i=0;i<items.length;i+=2){
			res=res.replaceAll("R"+(i+2),items[i+1]);
		}
		return res;
	}
    public static void main (String[] args) {
    File file = new File("stringsubstitution.txt");
    BufferedReader in = null;
	try {
		in = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
    String line;
    String s="";
    try {
		while ((line = in.readLine()) != null) {
		        //Process line of input Here
		        String[] sub1=line.split(";");
			    String[] sub2=sub1[1].split(",");
			    s=substitutString(sub1[0],sub2);
			    System.out.println(s);
		}
		    
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
}
