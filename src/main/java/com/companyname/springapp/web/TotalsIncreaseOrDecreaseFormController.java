package com.companyname.springapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.companyname.springapp.service.TotalsIncreaseOrDecrease;
import com.companyname.springapp.service.LoanIteratorManager;

@Controller
@RequestMapping(value="/priceincrease.htm")
public class TotalsIncreaseOrDecreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private LoanIteratorManager loanIteratorManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid TotalsIncreaseOrDecrease totalsIncreaseOrDecrease, BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }
		
        int increase = totalsIncreaseOrDecrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        loanIteratorManager.recalculateInterest(increase);

        return "redirect:/hello.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected TotalsIncreaseOrDecrease formBackingObject(HttpServletRequest request) throws ServletException {
        TotalsIncreaseOrDecrease totalsIncreaseOrDecrease = new TotalsIncreaseOrDecrease();
        totalsIncreaseOrDecrease.setPercentage(15);
        return totalsIncreaseOrDecrease;
    }

    public void setLoanIteratorManager(LoanIteratorManager loanIteratorManager) {
        this.loanIteratorManager = loanIteratorManager;
    }

    public LoanIteratorManager getLoanIteratorManager() {
        return loanIteratorManager;
    }

}