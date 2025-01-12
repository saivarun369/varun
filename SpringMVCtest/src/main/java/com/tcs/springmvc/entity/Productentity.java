package com.tcs.springmvc.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="product")

@Entity
public class Productentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String madeIn;
	private double price;
	private String brand;
	private double quantity;
	private double discountrate;
	private double discountprice;
	private double offerprice;
	private double finalprice;
	private double stockValue;
	private double taxprice;
}
