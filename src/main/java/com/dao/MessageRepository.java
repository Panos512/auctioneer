/**
 * Created by dimitris on 8/1/16.
 */

package com.dao;

import com.entity.Item;
import com.entity.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    Message findMessageByMsgId(int msgId);
    List<Message> findAll();
    
    @Query("SELECT m FROM Message m WHERE userIdReceiver=:userIdReceiver")
    public List<Message> getInboxMessages(@Param("userIdReceiver") int msgId);
  
    @Query("SELECT m FROM Message m WHERE userIdSender=:userIdSender")
    public List<Message> getOutboxMessages(@Param("userIdSender") int msgId);
  
        
   
}
