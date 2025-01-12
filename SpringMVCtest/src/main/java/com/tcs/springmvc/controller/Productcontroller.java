package com.tcs.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tcs.springmvc.entity.Productentity;
import com.tcs.springmvc.model.Product;
import com.tcs.springmvc.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class Productcontroller {
	@Autowired
	ProductService productService;
	
	@GetMapping("/productform")
	public String getproduct() {
		return "add-product";
	}
	@PostMapping("/saveproduct")
	public String saveproduct(Product product) {
		
		productService.saveproductDetails(product);
		System.out.println(product);
		return "success";
	}
	
@GetMapping("/getallproducts")
public String getallproducts(Model model) {
	List<Productentity> products=productService.getallproducts();
	model.addAttribute("products", products);
    return "product-list";
}
@GetMapping("/search")
public String getsearchform() {
    return "searchform";
}

@PostMapping("/searchbyid")
public String searchbyid(@RequestParam long id,Model model) {
   Productentity productentity=productService.searchbyid(id);
   model.addAttribute("product",productentity);
   return "searchform";
}

@GetMapping("/delete/{id}")
public String deleteproductbyid(@PathVariable ("id")long id) {
	productService.deleteproductid(id);
    return "redirect:/getallproducts";
}

@GetMapping("/edit/{id}")
public String editById(@PathVariable Long id,Model model) {
	Product product=productService.editById(id);
	model.addAttribute("product",product);
	model.addAttribute("id",id);
    return "editproductform";
}

@PostMapping("/editproductsave/{id}")
public String UpdateData(@PathVariable Long id,Product product) {
    productService.updateData(id,product);
    return "redirect:/getallproducts";
}
	
	

}
