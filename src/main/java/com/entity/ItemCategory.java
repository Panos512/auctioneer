package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by panos on 8/1/16.
 */
@Entity
public class ItemCategory {
    private int itemCategoryId;
    private int itemId;
    private int categoryId;

    @Id
    @Column(name = "ItemCategoryId")
    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    @Basic
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "CategoryId")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCategory that = (ItemCategory) o;

        if (itemCategoryId != that.itemCategoryId) return false;
        if (itemId != that.itemId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemCategoryId;
        result = 31 * result + itemId;
        result = 31 * result + categoryId;
        return result;
    }
}
