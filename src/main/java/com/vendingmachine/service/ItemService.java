package com.vendingmachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendingmachine.model.ItemQuantity;
import com.vendingmachine.model.Items;

@Service
public class ItemService {

	@Autowired
	private RefilService refilService;

	public List<Items> getItems() {
		// Business logic validation;
		return refilService.createItems(refilService.listItems());
	}

	public Items getItemDetails(int id) {
		for (Items item : refilService.listItems()) {
			if (item.getId() == id)
				return item;

		}
		Items ItmNotFound = new Items();
		ItmNotFound.setErrorMessage("Item Not found");
		return ItmNotFound;
	}

	public String removeItem(int id) {
		refilService.removeItem(id);
		return "Item purchased successfully";
	}

	public ItemQuantity itemPrice(int id) {
		List<ItemQuantity> list = refilService.listQuantityAndPrice();
		for (ItemQuantity price : list) {
			if (price.getId() == id)
				return price;
		}
		
		return null;
	}
}
