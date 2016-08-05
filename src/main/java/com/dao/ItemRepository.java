/**
 * Created by panos on 8/1/16.
 */

package com.dao;

import com.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemByItemId(int itemId);
    List<Item> findAll();
    List<Item> findByStartDateIsNotNull();
}

