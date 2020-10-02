package com.amediavilla.spring.model.vehicles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class AbstractProduct {

	@Id
	@GeneratedValue
	protected Long id;
	protected String name;
	protected Double price;

	public AbstractProduct() {
	}

	public AbstractProduct(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public abstract double getFullPrice();
}
