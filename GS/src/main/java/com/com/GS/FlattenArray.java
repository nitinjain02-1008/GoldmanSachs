package com.GS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlattenArray {

	public static void main(String[] args) throws Exception{
	    
		Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
	    	    
        Stream<Object> flattenedArray = flatten(array);
        
        System.out.println(Arrays.toString(flattenedArray.toArray()));
	    
	    System.out.println(Arrays.toString(flattenInt(array)));
	}
	
	public static Stream<Object> flatten(Object[] inputArray) {
	   
		return Arrays.stream(inputArray).flatMap( e -> e instanceof Object[]? flatten((Object[]) e):Stream.of(e));
		
	}
	
	public static Integer[] flattenInt(Object[] objArray) {
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i< objArray.length; i++) {
			if(objArray[i] instanceof Object[]) {
				list.addAll(Arrays.asList(flattenInt((Object[]) objArray[i])));
			}else {
				list.add((Integer) objArray[i]);
			}
		}
		
		return list.toArray(new Integer[list.size()]);
	}
}
