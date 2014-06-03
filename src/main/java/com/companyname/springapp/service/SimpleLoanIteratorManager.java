package com.companyname.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.assets.iterator.LoanIterator;
import com.companyname.springapp.repository.LoanIteratorDao;

public class SimpleLoanIteratorManager implements LoanIteratorManager {
	
	private static final long serialVersionUID = 1L;
	
	 @Autowired
	    private LoanIteratorDao loanIteratorDao;

	    public void setProductDao(LoanIteratorDao loanIteratorDao) {
	        this.loanIteratorDao = loanIteratorDao;
	    }
	
	private LoanIteratorManager loanIterators;
	
	@Override
	public List<LoanIterator> getLoanIterators() {
		return loanIteratorDao.getLoanIteratorDoaList();
	}

	@Override
	public void recalculateInterest(int percentage) {
		List<LoanIterator> loanIterators = loanIteratorDao.getLoanIteratorDoaList();
		if (loanIterators != null) {
			for (LoanIterator loanIterator : loanIterators) {
				double newTotals = loanIterator.getTotals().doubleValue() * (100 + percentage)/100;
				loanIterator.setTotals(newTotals);
				 loanIteratorDao.saveLoanIteratorDoa(loanIterators);
			}
		}
	}

	public void setLoanIterators(LoanIteratorManager loanIterators) {
		this.loanIterators = loanIterators;
	}

}