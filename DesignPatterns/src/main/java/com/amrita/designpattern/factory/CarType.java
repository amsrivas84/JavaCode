/**
 * 
 */
package com.amrita.designpattern.factory;

import java.util.function.Supplier;

/**
 * @author amritasrivastava
 *
 */
public enum CarType {
	FERRARI(Ferrari::new),
	FORD(Ford::new);
	
	private final Supplier<Car> carName;

	CarType(Supplier<Car> carName) {
		// TODO Auto-generated constructor stub
		this.carName=carName;
		
	}

	public Supplier<Car> getCarName() {
		return carName;
	}
	
	

}
