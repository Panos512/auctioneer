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
    List<Users> findUserByLastName(String lastName);

    //    @Query("select * from User u where u.username = ?1 and u.password = ?2")
    List<Users> findUserByUsernameAndPassword(String username, String password);
}
