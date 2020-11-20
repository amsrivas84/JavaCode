package com.amrita.java.collections;

import java.util.*;
//kk


public class SetsDemo {

	public static void main(String args[]) {
		// Sets
		// Sets do not allow duplicates
		// Lets look at HashSet first. HashSet does not support any ordering.
		//Set<String> family = new HashSet<String>();
		Set<String> family = new HashSet<>();//allowed in java 1.7
		family.add("Tejas");
		family.add("fgfggh");
		family.add("Aarna");
		family.add("Amrita");
		System.out.println(family);
		Iterator<String> iterator = family.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

		// Lets look at TreeSet next. TreeSet stores objects in Sorted Order.

		Set<String> treeSet = new TreeSet<String>();

		treeSet.add("Tejas");
		treeSet.add("Amrita");
		treeSet.add("Aarna");
		System.out.println("Treeset values printed in sorted order");
		System.out.println(treeSet);// 5
		Iterator<String> iterator1 = treeSet.iterator();
		while (iterator1.hasNext())
			System.out.println(iterator1.next());
		// Objects that are inserted into a TreeSet should be comparable

		// NavigableSet interface
		// Two classes implement them - TreeSet and TreeMap

		TreeSet<String> treeSetOrig = new TreeSet<String>();
		treeSetOrig.add("Tejas");
		treeSetOrig.add("Amrita");
		treeSetOrig.add("Aarna");
		System.out.println("lower" + treeSetOrig.lower("Amrita"));// 5
		System.out.println(treeSetOrig.floor("Amrita"));
		System.out.println(treeSetOrig.higher("Amrita"));
		System.out.println(treeSetOrig.ceiling("Amrita"));

		TreeSet<String> treeSetDesc = (TreeSet<String>) treeSetOrig.descendingSet();
		System.out.println("Original Treeset" + treeSetOrig);
		System.out.println("Descended order of treeset" + treeSetDesc);
		// pollLast returns the last element and
		// removes it from the set
		System.out.println(treeSetOrig.pollFirst());
		System.out.println("Updated Treeset" + treeSetOrig);
		System.out.println(treeSetOrig.pollLast());
		System.out.println("Updated Treeset" + treeSetOrig);

		
		// subSet,headSet,tailSet Methods in TreeSet
		
		TreeSet<Integer> intSet = new TreeSet<Integer>();
		intSet.add(1);
		intSet.add(2);
		intSet.add(3);
		intSet.add(4);
		intSet.add(5);
		//TreeSet<Integer> sortedSet = (TreeSet<Integer>) intSet.subSet(2, 4);
		SortedSet<Integer> subSet = intSet.subSet(2, 4);
		//SortedSet<Integer> subSet = intSet.subSet(2,true, 4,true);
		//SortedSet<Integer> subSet = intSet.subSet(2, false, 4, true);
		System.out.println(subSet);
		// In the sub set, Lower Limit inclusive - 2 included. Higher limit not
				// inclusive - 4 excluded.
		
		//SortedSet<Integer> headSet = intSet.headSet(3);
		SortedSet<Integer> headSet = intSet.headSet(3, true);
		// In the sub set, Higher limit not inclusive - 3 excluded.
		System.out.println(headSet);
		
		//SortedSet<Integer> tailSet = intSet.tailSet(4);
		SortedSet<Integer> tailSet = intSet.tailSet(4, false);
		// In the sub set, Lower limit inclusive - 4 included.
		System.out.println(tailSet);
		// All the sub set methods - subSet,headSet,tailSet - return dynamic sub
				// sets.
				// When original set is modified (addition or deletion), corresponding
				// changes
				// can affect the sub sets as well (if

				System.out.println(intSet);// [1,2,3,4,5]
				System.out.println(subSet);// [2,3]
				System.out.println(headSet);// [1,2]
				System.out.println(tailSet);// [4,5]

				intSet.add(30);

				System.out.println(intSet);// [5, 25, 35, 55, 105]
				System.out.println(subSet);// [25, 35]
				System.out.println(headSet);// [5, 25, 35]
				System.out.println(tailSet);// [35, 55, 105]
				// Methods similar to subSet,headSet,tailSet (of TreeSet) are available
				// in TreeMap as well.
				// They are called subMap, headMap, tailMap.
	}
}
