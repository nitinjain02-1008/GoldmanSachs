package com.GS;

public class DistanceBetweenTwoWords {
	
	/*
	 <b>Problem Statement</b>
	    Input two words returns the shortest distance between their two midpoints in number of characters
	    Words can appear multiple times in any order and should be case insensitive.
	    E.g. for the document="Example we just made up" shortestDistance( document, "we", "just" ) == 4
	 */	
	
	private static final String document;
	
	static {
		final StringBuffer sb = new StringBuffer();
		sb.append("In publishing and Graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
		sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
		sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");
		
		document = sb.toString();
	}

	public static double shortestDistance(final String document, String w1, String w2) {
		double shortestDistance = Double.MAX_VALUE;
		
		String[] words = document.split("[,. ]");
		
		int wordCount = 0;
		double w1Count = 0;
		double w2Count = 0;
		
		for(String word : words) {
			if(word.equalsIgnoreCase(w1)) w1Count = wordCount + (word.length()/2d);
			if(word.equalsIgnoreCase(w2))	w2Count = wordCount + (word.length()/2d);
			
			if(w1Count > 0 && w2Count > 0) {
				shortestDistance = Math.min(shortestDistance, Math.abs(w2Count - w1Count));
			}
			
			wordCount += word.length() + 1;
		}
		
		return shortestDistance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String d="Example we, just made up";
		System.out.println("Shortest Distance is = " + shortestDistance(d, "we", "made"));
		
		System.out.println("Shortest Distance is = " + shortestDistance(document, "and", "graphic"));
	}

}
