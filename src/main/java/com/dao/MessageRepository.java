/**
 * Created by dimitris on 8/1/16.
 */

package com.dao;

import com.entity.Message;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    Message findMessageByMsgId(int msgId);
    List<Message> findAll();
  
        
   
}
