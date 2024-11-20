package com.GS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MaxAvg2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String [][]scores = {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}} ;
		String [][]scores = {{ "Bob", "100" }, { "Mike", "60" }, { "Bob", "50" }, { "Jason", "55" }} ;
		
		Entry<Object, Double> maxMarks = average(scores);
		System.out.println(maxMarks.getKey() + " : " + maxMarks.getValue());
		
		findAverage(scores);

	}
	
	public static Entry<Object, Double> average(String[][] scores) {
		
		Map<Object, Double> collect = Arrays.stream(scores).collect(Collectors.groupingBy(s -> s[0], Collectors.averagingInt(s -> Integer.parseInt(s[1]))));
		
		Entry<Object, Double> maxMarks = collect.entrySet().stream().max((s1,s2) -> Double.compare(s1.getValue(), s2.getValue())).get();
		
		return maxMarks;
	}
	
	public static void findAverage(String[][] input) {
		
		Map<String, Student> map = new HashMap<>();
		//Map<String, List<Integer>> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		
		for(String[] a:input) {
			if(map.containsKey(a[0])) {
				Student s = map.get(a[0]);
				map.put(a[0], new Student(a[0], s.mark+Integer.parseInt(a[1]), s.count+1));
			//	max = Math.max(max, (s.mark+Integer.parseInt(a[1]))/(s.count+1));
			}else {
				map.put(a[0], new Student(a[0], Integer.parseInt(a[1]), 1));
			//	max = Math.max(max, Integer.parseInt(a[1]));
			}
		}
		
		for(Student s : map.values()) {
			max = Math.max(max, (s.mark/s.count));
		}
		
		System.out.println("Maximum average = " + max);
	}
	
	static class Student{
		String name;
		int mark;
		int count;
		
		public Student(String name, int mark, int count) {
			this.name = name;
			this.mark = mark;
			this.count = count;
		}
	}
}
