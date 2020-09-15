package com.fdmgroup.soloproject_stephenripley.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.soloproject_stephenripley.model.Item;
import com.fdmgroup.soloproject_stephenripley.model.User;
import com.fdmgroup.soloproject_stephenripley.repository.UserDao;
import com.fdmgroup.soloproject_stephenripley.repository.UserServiceRepository;

@Service
public class UserService implements UserServiceRepository<User> {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ItemService itemService;

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(long userid) {
		return userDao.findById(userid);
	}

	public void buyBasket(User user) {
		boolean purchase = true;
		for (Item item: user.getBasket()) {
			if (item.getStock() <= 0) {
				purchase = false;
			}
		}
		if (purchase) {
			for(Item item: user.getBasket()) {
				item.setStock(item.getStock()-1);
				itemService.save(item);
			}
			user.getBasket().clear();
			user.setTotalPrice(new BigDecimal("0.00"));
		}
		userDao.save(user);
	}

	public void calculateTotal(User user) {
		BigDecimal total = new BigDecimal("0.00");
		for (Item item: user.getBasket()) {
			total=total.add(item.getPrice());
			}
		user.setTotalPrice(total);
		userDao.save(user);
	}

}
