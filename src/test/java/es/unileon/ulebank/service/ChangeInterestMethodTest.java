package es.unileon.ulebank.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChangeInterestMethodTest {
	private ChangeInterestMethod method;
	
	@Before
    public void setUp() throws Exception {
		this.method = new ChangeInterestMethod();
	}
	
	@Test
	public void testSetTypeGetType() {
		double type = 2;
		
		assertEquals(this.method.getTypeOfInterest(), 0);
		
		this.method.setType(type);
		
		assertEquals(type, this.method.getTypeOfInterest());
	}

}
