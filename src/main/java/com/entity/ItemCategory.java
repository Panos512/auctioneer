package com.entity;

import javax.persistence.*;

/**
 * Created by dimitris on 8/5/16.
 */
@Entity
public class ItemCategory {
    private int itemCategoryId;
    private int itemId;
    private int categoryId;
    private Item itemByItemId;
    private Category categoryByCategoryId;

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
        return itemCategoryId;
    }

//    @ManyToOne
//    @JoinColumn(name = "ItemId", referencedColumnName = "ItemId", nullable = false)
//    public Item getItemByItemId() {
//        return itemByItemId;
//    }
//
//    public void setItemByItemId(Item itemByItemId) {
//        this.itemByItemId = itemByItemId;
//    }

//    @ManyToOne
//    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId", nullable = false)
//    public Category getCategoryByCategoryId() {
//        return categoryByCategoryId;
//    }
//
//    public void setCategoryByCategoryId(Category categoryByCategoryId) {
//        this.categoryByCategoryId = categoryByCategoryId;
//    }







}
