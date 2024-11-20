package com.synechron.morgan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class profileService {
	
	public static void main(String[] args) {
		//profile p = new profile("Nitin", 40);
		
		//System.out.println(service(p));
		
		List<profile> profleList = new ArrayList<profile>();
		
		List<profile> list = profleList.stream().filter(p -> p.getAge() >= 40 && p.getAge() <=60).collect(Collectors.toList());
		
		//
		
	}
	
	public static String service(profile profile) {
		
		String template = "My name is {Title} {FName} {LastName} and I am from {Place} and I studied {collegeName} and working {CurrentOrg}\r\n"
				+ "	i have work experience {yrs}.";
		
		String[] a = {"My", "name", "{Title}", "{FName}", "{LastName}"};
		StringBuilder sb = new StringBuilder();
		
		for(String s : a) {
			if(String.valueOf(s.charAt(0)).equals("{")) {
				String tem = s.substring(1, s.length()-1);
				System.out.println("tem = " + tem);
				if(tem.equals("FName"))
					sb.append(profile.getName());
				else if(tem.equals("age"))
					sb.append(profile.getAge());
			}
			else
				sb.append(s);
		}
		
		return sb.toString(); // My name  Nitin 	}
	}
}
