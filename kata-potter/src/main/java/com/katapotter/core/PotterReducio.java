package com.katapotter.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PotterReducio {

	/*
	 * discounted price of distinct books
	 * 
	 * 2 books 1520 
	 * 3 books 2160 
	 * 4 books 2560 
	 * 5 books 3000
	 * 
	 */

	protected static final Log LOG = LogFactory.getLog(PotterReducio.class);
	private static final int BOOK_PRICE = 800;
	private Map<HPBook, Integer> orderedBooks = new HashMap<>();

	public int getTotalPrice() {

		int netPrice = 0;
		int[] computeFactor = PotterService.optimizeCt((PotterService.sortOrderedBooks(orderedBooks)));
		for (int i = 0; i < computeFactor.length; i++) {
			netPrice += computePrice(computeFactor[i], BOOK_PRICE * computeFactor[i]);
		}
		
		return netPrice;
	}

	public void addToCart(HPBook book) {

		int bookCount = 0;
		if (orderedBooks.containsKey(book)) {
			bookCount = orderedBooks.get(book);
		}
		orderedBooks.put(book, bookCount + 1);
	}


	private int computePrice(int discountIndex, int grossPrice) {
		
		LOG.info("discountIndex: " + discountIndex);
		LOG.info("grossPrice: " + grossPrice);
		
		int price = 0;
		switch (discountIndex) {
		case 1:
			price = grossPrice;
			break;
		case 2:
			price = (int) (grossPrice * 0.95);
			break;
		case 3:
			price = (int) (grossPrice * 0.9);
			break;
		case 4:
			price = (int) (grossPrice * 0.8);
			break;
		case 5:
			price = (int) (grossPrice * 0.75);
			break;
		default:
			break;
		}
		return price;
	}

}
