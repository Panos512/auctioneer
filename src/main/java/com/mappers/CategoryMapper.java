package com.mappers;

import com.dto.CategoryDto;
import com.entity.Category;

/**
 * Created by Panos on 8/8/16.
 */
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
    }
