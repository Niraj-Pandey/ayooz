package org.ayooz.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class LongestLines{

	   public static void main (String[] args) {
		    File file = new File("longestlines.txt");
		    BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		    String line;
		    int n=0;
		    TreeMap<Integer, String> tm=new TreeMap<Integer, String>();
		    try {
		    	if ((line = in.readLine()) != null) {
		    		n=Integer.parseInt(line);
		    	}
				while ((line = in.readLine()) != null) {
					tm.put(line.length(), line);
				}
		        ArrayList<Integer> keys = new ArrayList<Integer>(tm.keySet());
		        for(int i=keys.size()-1; i>keys.size()-n-1;i--){
		            System.out.println(tm.get(keys.get(i)));
		        }
			} catch (IOException e) {
				e.printStackTrace();
			}
		    }
}