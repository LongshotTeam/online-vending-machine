package com.vendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.model.ItemQuantity;
import com.vendingmachine.model.Items;
import com.vendingmachine.service.ItemService;

@RestController
@RequestMapping("/vendingmachine")
public class VendingMechineController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public List<Items> items() {
		return itemService.getItems();
	}

	@GetMapping("/items/{id}")
	public Items itemsDetails(@PathVariable int id) {
		Items item = itemService.getItemDetails(id);
			return item;
	}

	@DeleteMapping("/items/puchase/{id}")
	public String purchase(@PathVariable int id) {
		return itemService.removeItem(id);
	}
	@GetMapping("/items/price/{id}")
	public ItemQuantity price(int id) {
		return itemService.itemPrice(id);
	}
}