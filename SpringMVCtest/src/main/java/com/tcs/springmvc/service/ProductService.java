package com.tcs.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springmvc.entity.Productentity;
import com.tcs.springmvc.model.Product;
import com.tcs.springmvc.repository.Productrepository;



@Service
public class ProductService {
 @Autowired
 Productrepository productrepository;
 public void saveproductDetails(Product productmodel) {
	 double stockvalue=productmodel.getPrice()*productmodel.getQuantity();
	 double discountprice=productmodel.getPrice()*productmodel.getDiscountrate()/100;
	 double taxprice=productmodel.getPrice()*0.18;
	 double offerprice=productmodel.getPrice()-discountprice;
	 double finalprice=offerprice+taxprice;
	 
	 Productentity productentity=new Productentity();
	 
	 productentity.setName(productmodel.getName());
	 productentity.setPrice(productmodel.getPrice());
	 productentity.setQuantity(productmodel.getQuantity());
	 productentity.setStockValue(stockvalue);
	 productentity.setDiscountprice(discountprice);
	 productentity.setTaxprice(taxprice);
	 productentity.setOfferprice(offerprice);
	 productentity.setFinalprice(finalprice);
	 productentity.setBrand(productmodel.getBrand());
	 productentity.setMadeIn(productmodel.getMadein());
	 productentity.setDiscountrate(productmodel.getDiscountrate());
	 
	  productrepository.save(productentity);
	 }
    public List<Productentity>getallproducts(){
    	List<Productentity> products=productrepository.findAll();
    	return products;
    }
    public Productentity searchbyid(long id) {
    	Optional<Productentity>optionaldata=productrepository.findById(id);
    	if(optionaldata.isPresent())
    	{
    		Productentity product= optionaldata.get();
    		return product;
    	}
    	else {
    		return null;
    	}
    }
    public void deleteproductid(long id) {
    	productrepository.deleteById(id);
    }
   
    
    public Product editById(long id) {
    	Optional<Productentity> optionaldata=productrepository.findById(id);
    	Product product=new Product();
    	if(optionaldata.isPresent())
    	{
    		
    		Productentity eProduct=optionaldata.get();
    		product.setName(eProduct.getName());
    		product.setBrand(eProduct.getBrand());
    		product.setMadein(eProduct.getMadeIn());
    		product.setQuantity(eProduct.getQuantity());
    		product.setPrice(eProduct.getPrice());
    		product.setDiscountrate(eProduct.getDiscountrate());
    		product.setTaxrate(eProduct.getTaxprice());
    		return product;
    	}
    	else
    	{
    		return null;
    	}
    }
    public void updateData(long id,Product model)
    {
    	Optional<Productentity> optionaldata=productrepository.findById(id);
    	if(optionaldata.isPresent())
    	{
    		Productentity entity=optionaldata.get();
    		entity.setName(model.getName());
    		entity.setBrand(model.getBrand());
    		entity.setMadeIn(model.getMadein());
    		entity.setPrice(model.getPrice());
    		entity.setQuantity(model.getQuantity());
    		entity.setDiscountrate(model.getDiscountrate());
    		entity.setTaxprice(model.getTaxprice());
    		
    		 double stockvalue=model.getPrice()*model.getQuantity();
    		 double discountprice=model.getPrice()*model.getDiscountrate()/100;
    		 double taxprice=model.getPrice()*0.18;
    		 double offerprice=model.getPrice()-discountprice;
    		 double finalprice=offerprice+taxprice;
    		 
			finalprice=model.getTaxprice()+offerprice;
            finalprice=model.getQuantity()*offerprice+model.getTaxprice()/100;
            entity.setDiscountprice(discountprice);
            entity.setOfferprice(offerprice);
            entity.setFinalprice(finalprice);
            entity.setStockValue(stockvalue);
            productrepository.save(entity);
    }
    
  }
}
