package es.unileon.ulebank.assets.strategy.loan;

import java.util.ArrayList;
import java.util.Date;

import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.handler.ScheduledPaymentHandler;
import es.unileon.ulebank.assets.support.DateWrap;
import es.unileon.ulebank.assets.support.PaymentPeriod;

public class AmericanMethod implements StrategyLoan {

	/**
	 * Object reference to the loan that wait calculating the fees
	 */
	private Loan loan;
	/**
	 * Array with all payments that you need for pay this loan
	 */

	private ArrayList<ScheduledPayment> payments;

	/**
	 * Effective interest for calculate the fees with this method
	 */
	private double effectiveRate;
	/**
	 * Object with the date for do the payments
	 */
	private DateWrap date;
	
	/**
	 * Constructor of the class
	 * @param loan
	 * @param effectiveRate
	 */
	public AmericanMethod(Loan loan, double effectiveRate) {
		this.payments = new ArrayList<ScheduledPayment>();
		this.effectiveRate = effectiveRate / 100;
		this.loan = loan;
		this.date = new DateWrap(new Date(), this.loan.getPaymentPeriod());
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<ScheduledPayment> doCalculationOfPayments() {
		ArrayList<ScheduledPayment> paymentsAmerican = new ArrayList<>();

		double money = this.loan.getDebt();
		double paymentInterest = this.loan.getDebt() * this.loan.getInterest();
		double s = ((Math.pow((1.0 + 0.12), this.loan.getAmortizationTime())) - 1.0) / 0.12;
		double paymentAmortization = this.loan.getDebt() / s;
		double payment = paymentInterest + paymentAmortization;

		double F = 0;

		while (F < this.loan.getDebt()) {
			paymentAmortization = round(paymentAmortization, 100);
			paymentInterest = round(paymentInterest, 100);
			payment = round(payment, 100);

			F = F * (1 + this.effectiveRate) + paymentAmortization;

			F = AmericanMethod.round(F, 1);

			money = this.loan.getDebt() - F;

			paymentsAmerican.add(new ScheduledPayment(this.date.getDate(),
					payment, paymentAmortization, paymentInterest, money,
					new ScheduledPaymentHandler(this.loan.getId(), this.loan.getLinkedAccount()
							.getTitulars(), this.date.getDate())));

			this.date.updateDate();
		}

		this.payments = paymentsAmerican;
		return paymentsAmerican;

	}

	private static double round(double num, int factor) {
		num = Math.round(num * factor);
		return num / factor;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (ScheduledPayment payment : this.payments) {
			sb.append(payment.toString());
			sb.append("\n");
		}

		return sb.toString();
	}

}
