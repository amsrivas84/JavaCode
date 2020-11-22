package com.amrita.designpattern.factorykit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		var factory = WeaponFactory.factory(builder -> {
			builder.add(WeaponType.SWORD, Sword::new);
			builder.add(WeaponType.AXE, Axe::new);
			builder.add(WeaponType.SPEAR, Spear::new);
			builder.add(WeaponType.BOW, Bow::new);
		});
		var axe = factory.create(WeaponType.AXE);
		//System.out.println(axe);
		LOGGER.info(axe.toString());

	}

}
