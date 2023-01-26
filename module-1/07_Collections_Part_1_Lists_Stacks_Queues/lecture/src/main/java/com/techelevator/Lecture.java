package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		//working with a list of strings
		//List<int> myInts//wont work
		//List<double> myDoubles//wont work
		List<String> myList = new ArrayList<>();
		List<Integer> myIntList;
		List<Double> myDoubleLIst;
		List<int[]> myListOfArrays;
		//List<String> x = new List();//also wont work
		new com.Hunt.ArrayList();


		List<String> myList1 = new ArrayList<>();
		myList1.add("jake");
		myList1.add("mike");
		myList1.add("josh");
		myList1.add("amy");

		for(int i = 0; i < myList1.size(); i++) {
			System.out.println(myList1.get(i));
		}
		System.out.println("========");
		myList1.add(0,"luis");
		for(int i = 0; i < myList1.size(); i++) {

		}


		//arr[index]




		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


	}
}
