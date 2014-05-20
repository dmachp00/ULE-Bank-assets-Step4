package com.companyname.springapp.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.service.SimpleLoanIteratorManager;

public class LoanControllerTest {

	@Test
	public void testHandleRequest() throws Exception {
		LoanController controller = new LoanController();
		controller.setLoanIteratorManager(new SimpleLoanIteratorManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}

}