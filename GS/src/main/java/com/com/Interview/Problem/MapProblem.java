package com.Interview.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Interview.Problem.model.Employee;

public class MapProblem {

	public static void main(String[] args) {
		
		Map<String, List<Employee>> deptEmpMap = new HashMap<>();
		
		Employee e1 = new Employee(1, "Nitin Jain", 40, 10000, "Java");
		Employee e2 = new Employee(2, "Niya Jain", 4, 1000, "Java");
		Employee e3 = new Employee(3, "Advik Jain", 7, 5000, "Java");
		Employee e4 = new Employee(4, "Arnav Jain", 12, 2000, "Java");
		Employee e5 = new Employee(5, "Ishika Jain", 15, 3000, "DevOps");
		Employee e6 = new Employee(6, "Cherry Jain", 2, 100, "DevOps");
		Employee e7 = new Employee(7, "Shubh Jain", 4, 1000, "DevOps");
		Employee e8 = new Employee(8, "Bhavik Jain", 7, 15000, "DevOps");
		Employee e9 = new Employee(9, "Vivan Jain", 4, 12000, "Tester");
		Employee e10 = new Employee(10, "Nayu Jain", 5, 11000, "Tester");
		Employee e11 = new Employee(11, "Pihu Jain", 4, 1200, "Tester");
		Employee e12 = new Employee(12, "Reyansh Jain", 6, 1500, "Tester");
		Employee e13 = new Employee(13, "Adrith Jain", 4, 1400, "UI");
		Employee e14 = new Employee(14, "Mridula Jain", 4, 1600, "UI");
		Employee e15 = new Employee(15, "Vaishnavi Jain", 4, 1000, "UI");
		Employee e16 = new Employee(16, "Vega Jain", 3, 10500, "UI");
		Employee e17 = new Employee(17, "Shalini Jain", 13, 1300, "Architect");
		Employee e18 = new Employee(18, "Risha Jain", 14, 1400, "Architect");
		Employee e19 = new Employee(19, "Lucky Jain", 12, 1500, "Architect");
		Employee e20 = new Employee(20, "Prisha Jain", 3, 100, "Architect");
		Employee e21 = new Employee(21, "Gisha Jain", 4, 1000, "Architect");
		
		List<Employee> empList1 = new ArrayList<Employee>(Arrays.asList(e1,e2,e3,e4));
		List<Employee> empList2 = new ArrayList<Employee>(Arrays.asList(e5,e6,e7,e8));
		List<Employee> empList3 = new ArrayList<Employee>(Arrays.asList(e9,e10,e11,e12));
		List<Employee> empList4 = new ArrayList<Employee>(Arrays.asList(e13,e14,e15,e16));
		List<Employee> empList5 = new ArrayList<Employee>(Arrays.asList(e17,e18,e19,e20,e21));
		
		deptEmpMap.put("Java", empList1);
		deptEmpMap.put("DevOps", empList2);
		deptEmpMap.put("Tester", empList3);
		deptEmpMap.put("UI", empList4);
		deptEmpMap.put("Architect", empList5);
		
		deptEmpMap.entrySet().stream().map(m -> {
			Map<String, Employee> map = new HashMap<>();
			
			List<Employee> empListbyDept = m.getValue();
			
			Optional<Employee> maxSalEmp = empListbyDept.stream().max(Comparator.comparingDouble(Employee::getSal));
			
			map.put(m.getKey(), maxSalEmp.get());
			
			return map;
			
		});
		
		
		List<Employee> empList = new ArrayList<Employee>(Arrays.asList(e1,e2,e3,e4, e5,e6,e7,e8, e9,e10,e11,e12, e13,e14,e15,e16, e17,e18,e19,e20,e21 ));
		
		empList.stream()
			.collect(
					Collectors.groupingBy(
							Employee::getDept, 
							Collectors.collectingAndThen(
									Collectors.maxBy(
											Comparator.comparingDouble(Employee::getSal)),
									Optional::get)
							)
					).forEach((k, v) -> System.out.println("For Dept = " + k + " , max Sal employee details are = " + v));

	}

}
