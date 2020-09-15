package com.fdmgroup.soloproject_stephenripley.repository;

public interface ItemServiceRepository<Item> {
	
	void save(Item item);
	
	Item findById(long itemid);

}
