package com.companyname.springapp.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.assets.iterator.LoanIterator;

public class SimpleLoanIteratorManagerTest {
	
	private SimpleLoanIteratorManager loanIteratorManager;
	
	private List<LoanIterator> loanIterators;
	
	private static int LOANITERATOR_COUNT = 2;
	
	private static Double CHAIR_TOTALS = new Double(20.50);
	private static String CHAIR_TABLEOFAMORTIZATION = "Chair";
	
	private static String TABLE_TABLEOFAMORTIZATION = "Table";
	private static Double TABLE_TOTALS = new Double(150.10);
	
	private static int POSITIVE_TOTALS_INCREASE_OR_DECREASE = 10; 
	
	@Before
	public void setUp() throws Exception {
		loanIteratorManager = new SimpleLoanIteratorManager();
		loanIterators = new ArrayList<LoanIterator>();
        
        // stub up a list of products
        LoanIterator loanIterator = new LoanIterator(null);
        loanIterator.setTableOfAmortization("Chair");
        loanIterator.setTotals(CHAIR_TOTALS);
        loanIterators.add(loanIterator);
        
        loanIterator = new LoanIterator(null);
        loanIterator.setTableOfAmortization("Table");
        loanIterator.setTotals(TABLE_TOTALS);
        loanIterators.add(loanIterator);
        
        loanIteratorManager.setLoanIterators(loanIterators);
	}
	
	@Test
	public void testGetLoanIteratorsWithNoLoanIterators() {
		loanIteratorManager = new SimpleLoanIteratorManager();
		assertNull(loanIteratorManager.getLoanIterators());
	}
	
	@Test
	public void testGetLoanIterators() {
		List<LoanIterator> loanIterators = loanIteratorManager.getLoanIterators();
		assertNotNull(loanIterators);
		assertEquals(LOANITERATOR_COUNT, loanIteratorManager.getLoanIterators().size());
		
		LoanIterator loanIterator = loanIterators.get(0);
		assertEquals(CHAIR_TABLEOFAMORTIZATION, loanIterator.getTableOfAmortization());
		assertEquals(CHAIR_TOTALS, loanIterator.getTotals());
		
		loanIterator = loanIterators.get(1);
		assertEquals(TABLE_TABLEOFAMORTIZATION, loanIterator.getTableOfAmortization());
		assertEquals(TABLE_TOTALS, loanIterator.getTotals());
	}
	
	@Test
	public void testIncreaseOrDecreaseTotalsWithNullListOfProducts() {
		try {
			loanIteratorManager = new SimpleLoanIteratorManager();
			loanIteratorManager.recalculateInterest(POSITIVE_TOTALS_INCREASE_OR_DECREASE);
		} catch (NullPointerException ex) {
			fail("TableOfAmortization list is null.");
		}
	}
	
	@Test
	public void testIncreaseOrDecreaseTotalsWithEmptyListOfLoanIterators() {
		try {
			loanIteratorManager = new SimpleLoanIteratorManager();
			loanIteratorManager.setLoanIterators(new ArrayList<LoanIterator>());
			loanIteratorManager.recalculateInterest(POSITIVE_TOTALS_INCREASE_OR_DECREASE);
		} catch (Exception ex) {
			fail("TableOfAmortization list is empty.");
		}
	}
	
	@Test
	public void testIncreaseOrDecreaseTotalsWhithPositivePercentage() {
		loanIteratorManager.recalculateInterest(POSITIVE_TOTALS_INCREASE_OR_DECREASE);
		double expectedChairTotalsWithIncreaseOrDecrease = 22.55;
		double expectedTableTotalsWithIncreaseOrDecrease = 165.11;
		
		List<LoanIterator> loanIterators = loanIteratorManager.getLoanIterators();
		LoanIterator loanIterator = loanIterators.get(0);
		assertEquals(expectedChairTotalsWithIncreaseOrDecrease, loanIterator.getTotals(), 0);
		
		loanIterator = loanIterators.get(1);
		assertEquals(expectedTableTotalsWithIncreaseOrDecrease, loanIterator.getTotals(), 0);
	}
	
}