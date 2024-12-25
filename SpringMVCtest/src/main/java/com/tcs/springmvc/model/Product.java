package com.tcs.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String name;
	private String brand;
	private String madein;
	private double price;
	private double quantity;
	private double discountrate;
	private double taxrate;
	private double taxprice;
}
