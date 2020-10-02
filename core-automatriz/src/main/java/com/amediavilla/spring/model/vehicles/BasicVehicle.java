package com.amediavilla.spring.model.vehicles;

import javax.persistence.Entity;

@Entity
public class BasicVehicle extends AbstractProduct {

	public BasicVehicle() {
	}
	
	public BasicVehicle(String name, Double price) {
		super(name, price);
	}

	@Override
	public double getFullPrice() {
		return this.getPrice();
	}
	
}
