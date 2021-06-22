package com.vendingmachine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vendingmachine.model.ItemQuantity;
import com.vendingmachine.model.Items;

@Service
public class RefilService {
	
	public List<Items> createItems(List<Items> items){
		List<Items> itemList = new ArrayList<Items>();
		
		for(Items item : items)
			itemList.add(item);
		
		return itemList;
		
	}
	
	public List<ItemQuantity> createPriceAndQuatntiy(List<ItemQuantity> pItems){
		List<ItemQuantity> itemPrice = new ArrayList<ItemQuantity>();
		
		for(ItemQuantity item : pItems)
			itemPrice.add(item);
		
		return itemPrice;
	}
	
	public List<Items>  listItems(){
		List<Items> itemList = new ArrayList<Items>();
		Items item1 = new Items();
		item1.setId(1);
		item1.setName("Choclates");
		item1.setDesc("Good Choclate");
		Items item2 = new Items();
		item2.setId(1);
		item2.setName("coffie");
		item2.setDesc("Good coffie");
		itemList.add(item1);
		itemList.add(item2);
		
		return itemList;
	}
	
	public List<ItemQuantity> listQuantityAndPrice(){
		List<ItemQuantity> qtyList = new ArrayList<ItemQuantity>();
		
		ItemQuantity qty1 =  new ItemQuantity();
		qty1.setId(1);
		qty1.setQuantity(10);
		qty1.setSize("S");
		qty1.setWeight(2);
		qty1.setPrice(5);
		
		ItemQuantity qty2 =  new ItemQuantity();
		qty2.setId(1);
		qty2.setQuantity(10);
		qty2.setSize("S");
		qty2.setWeight(2);
		qty2.setPrice(5);
		
		qtyList.add(qty1);
		qtyList.add(qty2);
		
		return qtyList;
	}

	public void removeItem(int id) {
		List<Items> itemList = listItems();
		Iterator itr = itemList.listIterator();
		Items item = null;
		while(itr.hasNext()) {
			item = (Items) itr.next();
			if(item.getId() == id)
				itemList.remove(item);
		}
	}
}
