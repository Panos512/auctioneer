package com.dao;

import com.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * Created by dimitris on 7/24/16.
 */

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findUserByLastName(String lastName);
    List<Users> findAll();
    Users findUserByUserId(int userId);
    Users findUserByUsernameAndPassword(String username, String password);
}
