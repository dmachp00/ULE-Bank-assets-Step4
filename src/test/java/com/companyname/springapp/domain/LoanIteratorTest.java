package com.companyname.springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.assets.iterator.LoanIterator;

public class LoanIteratorTest {
	
	private LoanIterator loanIterator;
	
	@Before
	public void setUp() throws Exception {
		loanIterator = new LoanIterator(null);
    }
	
	@Test
	public void testSetAndGetTableOfAmortization() {
		String testTableOfAmortization = "aTableOfAmortization";
		assertNull(loanIterator.getTableOfAmortization());
		loanIterator.setTableOfAmortization(testTableOfAmortization);
		assertEquals(testTableOfAmortization, loanIterator.getTableOfAmortization());
	}

	@Test
	public void testSetAndTotals() {
		double testTotals = 100.00;
		assertEquals(0, 0, 0);
		loanIterator.setTotals(testTotals);
		assertEquals(testTotals, loanIterator.getTotals(), 0);
	}

}