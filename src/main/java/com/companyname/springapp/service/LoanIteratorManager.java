package com.companyname.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.assets.iterator.LoanIterator;

public interface LoanIteratorManager extends Serializable {
	public void recalculateInterest(int percentage);
	
	public List<LoanIterator> getLoanIterators();
}