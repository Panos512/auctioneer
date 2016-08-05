package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Panos on 6/8/16.
 */
@Entity
public class Category {
    private int categoryId;
    private String categoryName;
    private Collection<ItemCategory> itemCategoriesByCategoryId;

    @Id
    @Column(name = "CategoryId")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = categoryId;
//        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
//        return result;
//    }
//
//    @OneToMany(mappedBy = "categoryByCategoryId")
//    public Collection<ItemCategory> getItemCategoriesByCategoryId() {
//        return itemCategoriesByCategoryId;
//    }
//
//    public void setItemCategoriesByCategoryId(Collection<ItemCategory> itemCategoriesByCategoryId) {
//        this.itemCategoriesByCategoryId = itemCategoriesByCategoryId;
//    }
}
