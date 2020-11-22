package com.amrita.designpattern.factory;

public class CarsFactory {
	
	public static Car getCar(CarType type)
	{
		return type.getCarName().get();
	}

}
