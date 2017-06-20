package com.boot;

import org.junit.Test;

import kwant.carapp.controller.HomeController;

import static org.junit.Assert.assertEquals;

public class AppTest {

	@Test
    public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
        assertEquals( result, "Dar Boot, reporting for duty" );
	}
}
