package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dimitris on 7/31/16.
 */
@Entity
public class ItemCategory {
    private int itemCategoryId;

    @Id
    @Column(name = "ItemCategoryId")
    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCategory that = (ItemCategory) o;

        if (itemCategoryId != that.itemCategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return itemCategoryId;
    }
}
