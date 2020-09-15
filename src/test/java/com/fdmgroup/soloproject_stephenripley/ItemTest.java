package com.fdmgroup.soloproject_stephenripley;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.soloproject_stephenripley.model.Item;
import com.fdmgroup.soloproject_stephenripley.service.ItemService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ItemTest {
	
	@Autowired
	ItemService itemService;
	
	@Test
	public void test_ThatAnItemCanBeCreated() {
	Item item = new Item("Spider-Man", "DVD", new BigDecimal("9.99"), 10);
	int itemBeforeAdding = itemService.findAll().size();
	itemService.save(item);
	int itemAfterAdding = itemService.findAll().size();
	assertNotEquals(itemBeforeAdding, itemAfterAdding);	
	}
	
	@Test
	public void test_ThatAnItemCanBeFoundById() {
		Item item = itemService.findById(1);
		assertNotNull(item);
	}
}
