package com.katapotter.core;

import java.util.Map;

public class PotterService {

	public static int[] sortOrderedBooks(Map<HPBook, Integer> orderedBooks) {
		int sortSize = getHighestBookCountPerTitle(orderedBooks);
		int sortBook[] = new int[sortSize];

		int i = 0;
		for (int ctr = 0; ctr < sortSize; ctr++) {
			int newSize = 0;
			for (Map.Entry<HPBook, Integer> entry : orderedBooks.entrySet()) {
				i = entry.getValue();
				if (entry.getValue() > 0) {
					newSize += 1;
				}
				i--;
				entry.setValue(i);
			}
			sortBook[ctr] = newSize;
		}
		
		return sortBook;
	}
	
	private static int getHighestBookCountPerTitle(Map<HPBook, Integer> orderedBooks) {
		int highestCount = 0;
		for (Map.Entry<HPBook, Integer> entry : orderedBooks.entrySet()) {
			if (highestCount < entry.getValue()) {
				highestCount = entry.getValue();
			}
		}
		return highestCount;
	}
	
	public static int[] optimizeCt(int[] arr) {
		int first = arr[0];
		if (arr.length > 1) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[0] - arr[1] >= 2) {
					arr[i] += 1;
					first--;
				}
				arr[0] = first;
			}
		}

		for (int i = 0; i < arr.length; i++) {
		}
		return arr;
	}
}
