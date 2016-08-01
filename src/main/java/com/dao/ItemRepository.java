/**
 * Created by panos on 8/1/16.
 */

package com.dao;

import com.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findItemByItemId(int itemId);
    List<Item> findAll();
    List<Item> findByStartDate(Date date);
}

