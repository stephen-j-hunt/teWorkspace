package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// working with a list "OF strings"
//		List<Lecture>
//		List<int> myInts; // won't work
//		List<double> myDoubles; // won't work;
		List<int[]> myListOfArrays;
		List<Integer> myIntList;
		List<Double> myDoubleList;
//		List<String> x = new List(); // also won't work

		List<String> names = new ArrayList<>();
		names.add("jake");
		names.add("mike");
		names.add("josh");
		names.add("amy");

		for(int i=0; i < names.size(); i++) {
			// arr[index]
			System.out.println(names.get(i));
		}

		names.add(0, "luis");
		System.out.println("======");
		for(int i=0; i < names.size(); i++) {
			// arr[index]
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("josh");
		System.out.println("======");
		for(int i=0; i < names.size(); i++) {
			// arr[index]
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(5);
		names.remove("josh");
		System.out.println("======");
		for(int i=0; i < names.size(); i++) {
			// arr[index]
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println("jake is in the list: " + names.contains("jake"));
		System.out.println("josh is in the list: " + names.contains("josh"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("jake is at index: " + names.indexOf("jake"));
		System.out.println("josh is at index: " + names.indexOf("josh"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// provide a zero-length array as a template for the array to be returned
		String[] namesArray =  names.toArray(new String[0]);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		System.out.println("==============");
		System.out.println("before sorting");
		for(int i=0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}
		Collections.sort(names); // will mutate our list
		System.out.println("after sorting");
		for(int i=0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		Collections.reverse(names);
		System.out.println("after reversing");
		for(int i=0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}

		List<String> strings = new ArrayList<>(Arrays.asList("bbb", "abc", "abb", "aaa", "abbbc"));
		Collections.sort(strings);
		for (int i=0; i<strings.size(); i++) {
			System.out.println(strings.get(i));
		}




		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


	}
}
