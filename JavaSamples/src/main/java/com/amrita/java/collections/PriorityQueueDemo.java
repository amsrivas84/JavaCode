package com.amrita.java.collections;

import java.util.*;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
	priorityQueue.offer(1);
	priorityQueue.offer(6);
	priorityQueue.offer(14);
	priorityQueue.offer(9);
	priorityQueue.offer(4);
	priorityQueue.offer(8);
	
	System.out.println(priorityQueue);
	System.out.println(priorityQueue.peek());
	System.out.println(priorityQueue.poll());
	System.out.println(priorityQueue);
	
	// This comparator gives high priority to the biggest number.
			Comparator reverseComparator = new Comparator<Integer>() {
				public int compare(Integer paramT1, Integer paramT2) {
					return paramT2 - paramT1;
				}

			};

			// We can create priority queue using a comparator class i.e. custom
			// defined priority
			PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<Integer>(
					20, reverseComparator);
			priorityQueueDesc.offer(24);
			priorityQueueDesc.offer(15);
			priorityQueueDesc.offer(9);
			priorityQueueDesc.offer(45);

			// 45 is the largest element. Our custom comparator gives priority to
			// highest number.
			System.out.println(priorityQueueDesc);
			System.out.println(priorityQueueDesc.peek());// 45

			// Collections static methods
			// static int binarySearch(List, key)
			// static int binarySearch(List, key, Comparator)
			// static void reverse(List)//Reverse the order of elements in a List.
			// static Comparator reverseOrder();//Return a Comparator that sorts the
			// reverse of the collection�s current sort sequence.
			// static void sort(List)
			// static void sort(List, Comparator)
		
	}

}
