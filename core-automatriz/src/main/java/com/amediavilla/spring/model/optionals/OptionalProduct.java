package com.amediavilla.spring.model.optionals;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.amediavilla.spring.model.vehicles.AbstractProduct;

@Entity
public class OptionalProduct extends AbstractProduct {

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "decorated_id")
	private AbstractProduct product;
	private String code;

	public OptionalProduct() {
	}

	public OptionalProduct(String name, Double price, String code, AbstractProduct product) {
		super(name, price);
		this.product = product;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AbstractProduct getProduct() {
		return product;
	}

	public void setProduct(AbstractProduct product) {
		this.product = product;
	}

	@Override
	public double getFullPrice() {
		return this.getProduct().getFullPrice() + this.getPrice();
	}

}
