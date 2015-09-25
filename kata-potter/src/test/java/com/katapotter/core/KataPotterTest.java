package com.katapotter.core;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

public class KataPotterTest {

	/*
	 * discounted price of distinct books
	 * 
	 * 2 books is 1520 
	 * 3 books is 2160 
	 * 4 books is 2560 
	 * 5 books is 3000
	 * 
	 */

	protected static final Log LOG = LogFactory.getLog(KataPotterTest.class);

	private PotterReducio potterReducio;

	@Before
	public void setup() {
		LOG.info("----- Before Test -----");
		potterReducio = new PotterReducio();
	}

	@Test
	public void oneBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		assertTotalPrice(800);
	}

	@Test
	public void twoSameBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		assertTotalPrice(1600);
	}

	@Test
	public void threeSameBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		assertTotalPrice(2400);
	}

	@Test
	public void fourSameBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		assertTotalPrice(3200);
	}

	@Test
	public void fiveSameBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		assertTotalPrice(4000);
	}

	@Test
	public void twoDifferentBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		assertTotalPrice(1520);
	}

	@Test
	public void threeDifferentBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		assertTotalPrice(2160);
	}

	@Test
	public void fourDifferentBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.FOUR);
		assertTotalPrice(2560);
	}

	@Test
	public void fiveDifferentBookTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.FOUR);
		potterReducio.addToCart(HPBook.FIVE);
		assertTotalPrice(3000);
	}
	
	@Test
	public void twoDuplicateTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		assertTotalPrice(3040);
	}
	
	@Test
	public void threeDuplicateTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.THREE);
		assertTotalPrice(4320);
	}
	
	@Test
	public void fourDuplicateTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.FOUR);
		potterReducio.addToCart(HPBook.FOUR);
		assertTotalPrice(5120);
	}
	
	@Test
	public void threeByTwoTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		assertTotalPrice(4560);
	}
	
	@Test
	public void threeByThreeTest() {

		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.THREE);
		assertTotalPrice(6480);
	}
	
	@Test
	public void tripleDoubleTest() {
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		assertTotalPrice(3840);
	}
	
	@Test
	public void randomDuplicateTest() {
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.ONE);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.TWO);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.THREE);
		potterReducio.addToCart(HPBook.FOUR);
		potterReducio.addToCart(HPBook.FOUR);
		potterReducio.addToCart(HPBook.FOUR);
		potterReducio.addToCart(HPBook.FOUR);
		potterReducio.addToCart(HPBook.FIVE);
		assertTotalPrice(10040);
	}

	private void assertTotalPrice(int amt) {
		int totalPrice = potterReducio.getTotalPrice();
		assertEquals(totalPrice, amt);
	}
}

