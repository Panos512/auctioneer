package com.user;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dimitris on 7/29/16.
 */


@Component
public class UserAuthorizer {
    private Map<UUID,Integer> concurrentHashMapObject = new ConcurrentHashMap<UUID, Integer>();


    public void setUserSession(UUID token, Integer userId) {
        concurrentHashMapObject.put(token, userId);
    }


    public Integer getUserId(UUID token){
        return concurrentHashMapObject.get(token);
    }
    
    public void removeUserSession(UUID token){
    	concurrentHashMapObject.remove(token);
    	
    }
}
