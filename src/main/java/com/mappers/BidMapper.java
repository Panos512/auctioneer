package com.mappers;

import com.dto.BidDto;
import com.dto.PhotoDto;
import com.entity.Bids;
import com.entity.Photos;
import com.oxMappers.BidJax;


/**
 * Created by Panos on 26/8/16.
 */
public class BidMapper {

    public static Bids registerDtoToBid (BidDto bidDto) {

        Bids bid = new Bids();

        bid.setItemId(bidDto.getItemId());
        bid.setBidDate(bidDto.getBidDate());
        bid.setOfferPrice(bidDto.getOfferPrice());
        bid.setBidId(bidDto.getBidId());
        bid.setUserId(bidDto.getUserId());

        return bid;
    }
    
    public Bids bidJaxToBid(BidJax bidJax) {
    	Bids bid = new Bids();
    //	bid.setBidDate(bidJax.getTime());
        //bid.setItemId(itemId);
        //bid.setOfferPrice(bidJax.getAmount());
    	
    	return bid;
    	
    }
    
    
    

}
