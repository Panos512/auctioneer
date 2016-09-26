
package com.mappers;

import com.entity.Category;
import com.oxMappers.CategoryJax;

public class CategoryMapper {
	
    public static CategoryJax mapCategoryToCategoryJAX(Category category) {
        CategoryJax categoryJax = new CategoryJax();
        categoryJax.setvalue(category.getCategoryName());
        return categoryJax;
    }

    
    
    
    

}
