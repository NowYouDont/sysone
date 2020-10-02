package com.amediavilla.spring.model.vehicles;

import com.amediavilla.spring.exception.ProductNotFoundException;

public class VehicleFactory {

	private static VehicleFactory instance;

	public static VehicleFactory getInstance() {
		if (instance == null) {
			instance = new VehicleFactory();
		}

		return instance;
	}

	public AbstractProduct createVehicleByCode(String code) throws ProductNotFoundException {
		BasicVehicle bv = null;
		switch (code) {
		case "SE":
			bv = createSedan();
			break;
		case "FA":
			bv = createFamiliar();
			break;
		case "CO":
			bv = createCoupe();
			break;
		default:
			throw new ProductNotFoundException("Invalid car code: " + code);
		}
		return bv;
	}

	public BasicVehicle createSedan() {
		return new BasicVehicle("Basico Sedan", 230000d);
	}

	public BasicVehicle createFamiliar() {
		return new BasicVehicle("Basico Familiar", 245000d);
	}

	public BasicVehicle createCoupe() {
		return new BasicVehicle("Basico Coupe", 270000d);
	}
}
