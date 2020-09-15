package com.fdmgroup.soloproject_stephenripley;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.soloproject_stephenripley.model.Item;
import com.fdmgroup.soloproject_stephenripley.model.User;
import com.fdmgroup.soloproject_stephenripley.service.ItemService;
import com.fdmgroup.soloproject_stephenripley.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ItemService itemService;
	
	@Test
	public void test_ThatAUserCanBeCreated() {
		User user = new User("John", "Smith");
		int userBeforeAdding = userService.findAll().size();
		userService.save(user);
		int userAfterAdding = userService.findAll().size();
		assertNotEquals(userBeforeAdding, userAfterAdding);
	}
	
	@Test
	public void test_ThatAUserCanBeFoundById() {
		User user = userService.findById(1);
		assertNotNull(user);
	}
	
	@Test
	public void test_ThatABasketCanBeBoughtIfEnoughStock() {
		User user = new User("John", "Smith");
		userService.save(user);
		Item item = new Item("Black Panther", "DVD", new BigDecimal("9.99"), 2);
		itemService.save(item);
		user.getBasket().add(item);
		userService.buyBasket(user);
		assertTrue(user.getBasket().size()==0);
	}
	
	@Test
	public void test_ThatABasketCannotBeBoughtIfNotEnoughStock() {
		User user = new User("John", "Smith");
		Item item = new Item("The Incredible Hulk", "DVD", new BigDecimal("10.50"), 0);
		itemService.save(item);
		user.getBasket().add(item);
		userService.save(user);
		userService.buyBasket(user);
		assertTrue(user.getBasket().size()>0);
	}

	@Test
	public void test_ThatATotalPriceCanBeCalulcated() {
		User user = new User("John", "Smith");
		Item item = new Item("Iron Man", "DVD", new BigDecimal("7.99"), 0);
		itemService.save(item);
		Item item2 = new Item("Captain America", "DVD", new BigDecimal("15.99"), 0);
		itemService.save(item2);
		user.getBasket().add(item);
		user.getBasket().add(item2);
		userService.save(user);
		userService.calculateTotal(user);
		assertEquals(new BigDecimal("23.98"),user.getTotalPrice());
		
	}
}
