package com.companyname.springapp.service;

import java.util.List;

import es.unileon.ulebank.assets.iterator.LoanIterator;

public class SimpleLoanIteratorManager implements LoanIteratorManager {
	
	private static final long serialVersionUID = 1L;
	
	private List<LoanIterator> loanIterators;
	
	@Override
	public List<LoanIterator> getLoanIterators() {
		return loanIterators;
	}

	@Override
	public void recalculateInterest(int percentage) {
		if (loanIterators != null) {
			for (LoanIterator loanIterator : loanIterators) {
				double newTotals = loanIterator.getTotals().doubleValue() * (100 + percentage)/100;
				loanIterator.setTotals(newTotals);
			}
		}
	}

	public void setLoanIterators(List<LoanIterator> loanIterators) {
		this.loanIterators = loanIterators;
	}

}