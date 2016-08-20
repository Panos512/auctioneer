/**
 * Created by panos on 8/1/16.
 */

package com.dao;

import com.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemByItemId(int itemId);
    List<Item> findAll();
    List<Item> findByStartDateIsNotNull();
        
    @Query("SELECT i FROM Item i WHERE i.startDate < now()")
    public List<Item> findActiveItems();

    
    @Query("SELECT i FROM Item i where i.itemId in (select itemId from ItemCategory where categoryId=:categoryId) AND i.startDate < now() and now() < i.endDate")
    public List<Item> findActiveItemsByCategoryId(@Param("categoryId") int categoryId);
}

