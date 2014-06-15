package es.unileon.ulebank.assets.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ModifyInterest {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Min(0)
	@Max(100)
	private static double typeOfInterest;
	
	public void setTypeOfInterest(double interestForModification) {
		typeOfInterest = interestForModification;
		logger.info("Type of interest for modification " + interestForModification);
		
	}
	
	public double getTypeOfInterest() {
		return typeOfInterest;
	}

}
