/**
 * Created by panos on 8/1/16.
 */

package com.dao;

import com.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByCategoryId(int categoryId);
    List<Category> findAll();
}

