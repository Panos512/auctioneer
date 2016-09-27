/**
 * Created by Panos on 8/8/16.
 */

package com.mappers;

import com.entity.Category;
import com.dto.CategoryDto;
import com.oxMappers.CategoryJax;


public class CategoryMapper {

    public static CategoryDto registerCategoryToDto(Category category) {

        if (category == null)
            return null;


        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getCategoryId());

        return categoryDto;

    }

    public static Category registerDtoToCategory(CategoryDto categoryDto) {

        if (categoryDto == null)
            return null;


        Category category = new Category();

        category.setCategoryId(categoryDto.getId());

        return category;

    }


    public static CategoryJax mapCategoryToCategoryJAX(Category category) {
        CategoryJax categoryJax = new CategoryJax();
        categoryJax.setvalue(category.getCategoryName());
        return categoryJax;
    }


}
