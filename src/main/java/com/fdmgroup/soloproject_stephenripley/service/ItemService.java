package com.fdmgroup.soloproject_stephenripley.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.soloproject_stephenripley.model.Item;
import com.fdmgroup.soloproject_stephenripley.repository.ItemDao;
import com.fdmgroup.soloproject_stephenripley.repository.ItemServiceRepository;

@Service
public class ItemService implements ItemServiceRepository<Item> {

	@Autowired
	ItemDao itemDao;
	
	@Override
	public void save(Item item) {
		itemDao.save(item);
		
	}

	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public Item findById(long itemid) {
		return itemDao.findById(itemid);
	}


}
