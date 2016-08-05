package com.dao;

import com.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Panos on 5/8/16.
 */
@Repository
public interface PhotosRepository extends JpaRepository<Photos, Long> {

    List<Photos> findAll();


}
