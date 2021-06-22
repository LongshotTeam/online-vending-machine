package com.vendingmachine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.model.ItemQuantity;
import com.vendingmachine.model.Items;
import com.vendingmachine.service.RefilService;

@RestController
@RequestMapping("/vendingmachine/inventory")
public class RefilController {
	
	@Autowired
	private RefilService refilServie;

	@PostMapping("/items")
	public String createItems(@RequestBody List<Items> items) {
		int threshHold = 10;
		
		if(refilServie.listItems().size() == threshHold)
			return "Item Overflow";
		
		refilServie.createItems(items);
		return "Iteams added successfully";
	}
	@PostMapping("/items/refil")
	public List<ItemQuantity> createQyantityAndPrice(@RequestBody List<ItemQuantity> items) {
		return refilServie.createPriceAndQuatntiy(items);
	}
	
	@PutMapping("/items")
	public List<Items> items(@RequestBody List<Items> items) {
		return refilServie.createItems(items);
	}
	@PutMapping("/items/refil")
	public List<ItemQuantity> refilQyantityAndPrice(@RequestBody List<ItemQuantity> items) {
		return refilServie.createPriceAndQuatntiy(items);
	}
}
