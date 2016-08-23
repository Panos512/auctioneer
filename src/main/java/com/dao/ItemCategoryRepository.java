package com.dao;

import com.entity.Item;
import com.entity.ItemCategory;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Panos on 7/8/16.
 */

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

    List<ItemCategory> findAll();

    List<ItemCategory> findByItemId(Item item);
//    ItemCategory findByItemIdAndCategoryId(int itemId, int categoryId);
}
