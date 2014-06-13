package es.unileon.ulebank.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChangeInterestMethod {
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Min(1)
	@Max(100)
	private static double typeOfInterest;
	public void setType(double i) {
		typeOfInterest = i;
		logger.info("An interest chooses to modify: " + i);
	}
	
	public static double getTypeOfInterest() {
		return typeOfInterest;
	}
	
}
