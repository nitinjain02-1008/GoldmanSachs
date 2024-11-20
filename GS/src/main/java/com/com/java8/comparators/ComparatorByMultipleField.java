package com.java8.comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.Interview.Problem.model.Employee;

public class ComparatorByMultipleField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		
		empList.stream()
			.sorted(
					Comparator.comparing(Employee :: getSal)
								.thenComparing(Comparator.comparing(Employee::getName))
					)
			.map(Employee::getName).forEach(System.out::println);
	}

}
