package com.amrita.designpattern.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		
		var car1=CarsFactory.getCar(CarType.FERRARI);
		var car2=CarsFactory.getCar(CarType.FORD);
		// TODO Auto-generated method stub
		LOGGER.info(car1.getDescription());
		LOGGER.info(car2.getDescription());
		

	}

}
