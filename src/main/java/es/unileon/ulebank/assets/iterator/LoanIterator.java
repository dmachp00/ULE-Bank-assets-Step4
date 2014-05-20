package es.unileon.ulebank.assets.iterator;

import java.io.Serializable;

import java.util.Iterator;
import java.util.List;

import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;

public class LoanIterator implements Serializable, Iterator<ScheduledPayment> {
	
	private static final long serialVersionUID = 1L;

	/**
	 * List where the fees of a loan are stored
	 */
	private List<ScheduledPayment> loanPayments;
	/**
	 * Position that a fee are stored in the list
	 */
	private int position;
	
	private String tableOfAmortization;
	private Double totals;
	
	public String getTableOfAmortization() {
		return tableOfAmortization;
	}
	
	public void setTableOfAmortization(String tableOfAmortization) {
		this.tableOfAmortization = tableOfAmortization;
	}
	
	public Double getTotals() {
		return totals;
	}
	
	public void setTotals(Double totals) {
		this.totals = totals;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Table of amortization: " + tableOfAmortization + ";");
		buffer.append("Totals: " + totals);
		return buffer.toString();
	}
	
	public LoanIterator(List<ScheduledPayment> loanPayments) {
		this.loanPayments = loanPayments;
		this.position = 0;
	}

	/**
	 * Check if one fee is not the last of the loan
	 */
	@Override
	public boolean hasNext() {
		if(this.position < this.loanPayments.size()) return true;
		return false;
	}

	/**
	 * Change the position of the iterator in the fees list
	 */
	@Override
	public ScheduledPayment next() {
		ScheduledPayment payment = this.loanPayments.get(this.position);
		this.position++;
		return payment;
	}

	@Override
	public void remove() {
		
	}

}