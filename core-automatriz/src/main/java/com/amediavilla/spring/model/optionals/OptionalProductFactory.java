package com.amediavilla.spring.model.optionals;

import com.amediavilla.spring.exception.ProductNotFoundException;
import com.amediavilla.spring.model.vehicles.AbstractProduct;

public class OptionalProductFactory {

	private static OptionalProductFactory instance;

	public static OptionalProductFactory getInstance() {
		if (instance == null) {
			instance = new OptionalProductFactory();
		}

		return instance;
	}
	
	public OptionalProduct addOptionalProductByCode(String code, AbstractProduct product)
			throws ProductNotFoundException {
		OptionalProduct op = null;
		switch (code) {
		case "TC":
			op = addSlidingRoof(product);
			break;
		case "AA":
			op = addAirConditioner(product);
			break;
		case "ABS":
			op = addBrakes(product);
			break;
		case "AB":
			op = addAirbag(product);
			break;
		case "LL":
			op = addAlloyWheels(product);
			break;
		default:
			throw new ProductNotFoundException("Invalid product code: " + code);
		}
		return op;
	}

	public OptionalProduct addSlidingRoof(AbstractProduct product) {
		return new OptionalProduct("Techo Corredizo", 12000d, "TC", product);
	}

	public OptionalProduct addAirConditioner(AbstractProduct product) {
		return new OptionalProduct("Aire Acondicionado", 20000d, "AA", product);
	}
	
	public OptionalProduct addBrakes(AbstractProduct product) {
		return new OptionalProduct("Sistema de frenos ABS", 14000d, "ABS", product);
	}
	
	public OptionalProduct addAirbag(AbstractProduct product) {
		return new OptionalProduct("Airbag", 7000d, "AB", product);
	}
	
	public OptionalProduct addAlloyWheels(AbstractProduct product) {
		return new OptionalProduct("Llantas de aleacion", 12000d, "LL", product);
	}
}
