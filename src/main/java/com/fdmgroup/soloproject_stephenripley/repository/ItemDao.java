package com.fdmgroup.soloproject_stephenripley.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.soloproject_stephenripley.model.Item;

public interface ItemDao extends JpaRepository<Item, Long>{

	Item findById(@Param("itemid") long itemid);
}
