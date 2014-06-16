package es.unileon.ulebank.assets.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.groups.Default;

import org.apache.catalina.connector.Request;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.annotations.PostConstructAnnotationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.repository.LoanDao;
import es.unileon.ulebank.assets.service.ChangeMethod;
import es.unileon.ulebank.assets.service.ModifyInterest;
import es.unileon.ulebank.assets.strategy.loan.AmericanMethod;
import es.unileon.ulebank.assets.strategy.loan.FrenchMethod;
import es.unileon.ulebank.assets.strategy.loan.GermanMethod;
import es.unileon.ulebank.assets.strategy.loan.ItalianMethod;
import es.unileon.ulebank.assets.strategy.loan.ProgressiveMethod;
import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;

@Controller
@Component
@RequestMapping(value="/modifyInterest.htm")
public class ModifyInterestController {
	
	protected final Log LOGGER = LogFactory.getLog(getClass());
	
	@Autowired
	private LoanDao loanDao;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid ModifyInterest modifyInteres, @Valid ChangeMethod changeMethod, BindingResult result) {
		
		int type = changeMethod.getType();
		double typeOfInterest = modifyInteres.getTypeOfInterest();
		String now = (new Date().toString());
		
		LOGGER.info("Select the type of interest: " + typeOfInterest);
		LOGGER.info("Select the loan method: " + type);
		LOGGER.info("Returning fees view with " + now);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		myModel.put("now", now);
		
		List<Loan> lista = loanDao.getLoanList();
		
		switch (type) {
		case 1:
			Loan loanAmericanMethod = lista.get(0);
			AmericanMethod aM = new AmericanMethod(loanAmericanMethod, 12);
			ArrayList<ScheduledPayment> paymentsAmericanMethod = aM.doCalculationOfPayments();
			myModel.put("products", paymentsAmericanMethod);
			return new ModelAndView("fees", "model", myModel);
		case 2:
			Loan loanFrechMethod = lista.get(0);
			FrenchMethod fM = new FrenchMethod(loanFrechMethod);
			ArrayList<ScheduledPayment> paymentsFrechMethod = fM.doCalculationOfPayments();
			myModel.put("products", paymentsFrechMethod);
			return new ModelAndView("fees", "model", myModel);
		case 3:
			Loan loanGermanMethod = lista.get(0);
			GermanMethod gM = new GermanMethod(loanGermanMethod);
			ArrayList<ScheduledPayment> paymentsGermanMethod = gM.doCalculationOfPayments();
			myModel.put("products", paymentsGermanMethod);
			return new ModelAndView("fees", "model", myModel);
		case 4:
			Loan loanItalianMethod = lista.get(0);
			ItalianMethod iM = new ItalianMethod(loanItalianMethod);
			ArrayList<ScheduledPayment> paymentsItalianMethod = iM.doCalculationOfPayments();
			myModel.put("products", paymentsItalianMethod);
			return new ModelAndView("fees", "model", myModel);
		case 5:
			Loan loanProgressiveMethod = lista.get(0);
			ProgressiveMethod pM = new ProgressiveMethod(loanProgressiveMethod, 5);
			ArrayList<ScheduledPayment> paymentsProgressiveMethod = pM.doCalculationOfPayments();
			myModel.put("products", paymentsProgressiveMethod);
			return new ModelAndView("fees", "model", myModel);
		default:
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModifyInterest formBModifyInterest(HttpServletRequest request) throws ServletException {
		ModifyInterest modifyInterest = new ModifyInterest();
		double interestForModification;
		modifyInterest.setTypeOfInterest(interestForModification);
		return modifyInterest;
	}

}
