package com.mappers;

import com.dao.UserRepository;
import com.dto.ItemAddRequestDto;
import com.dto.ItemAddResponseDto;
import com.dto.ItemDto;
import com.dto.PhotoDto;
import com.entity.Category;
import com.entity.Item;
import com.entity.Photos;
import com.oxMappers.ItemJax;
import com.oxMappers.ItemsJax;
import com.oxMappers.LocationJax;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

import java.util.LinkedList;

/**
 * Created by panos on 8/1/16.
 */
public class ItemMapper {




    public static Item registerRequestToItem(ItemAddRequestDto itemAddRequestDto) {

        if (itemAddRequestDto == null)
            return null;

        Item  item = new Item();

        item.setItemId(itemAddRequestDto.getItemId());
        item.setBuyPrice(itemAddRequestDto.getBuyPrice());
        item.setCountry(itemAddRequestDto.getCountry());
        item.setCreatedDate(itemAddRequestDto.getCreatedDate());
        item.setCurrently(itemAddRequestDto.getFirstBid());
        item.setDescription(itemAddRequestDto.getDescription());
        item.setEndDate(itemAddRequestDto.getEndDate());
        item.setFirstBid(itemAddRequestDto.getFirstBid());
        item.setLatitude(itemAddRequestDto.getLatitude());
        item.setLongitude(itemAddRequestDto.getLongitude());
        item.setName(itemAddRequestDto.getName());
        item.setNumberOfBids(0);
        item.setUser(null);
        item.setStartDate(itemAddRequestDto.getStartDate());

        // TODO: WE NEED TO ADD CATEGORIES TO THE ITEM

        return item;
    }

    public static ItemAddResponseDto registerItemToItemResponseDto(Item item) {

        ItemAddResponseDto itemAddResponseDto = new ItemAddResponseDto();

        itemAddResponseDto.setItemId(item.getItemId());

        return itemAddResponseDto;
    }


    public static ItemDto registerItemToItem(Item item) {

        if (item == null)
            return null;

        ItemDto  itemDto = new ItemDto();

        itemDto.setItemId(item.getItemId());
        itemDto.setBuyPrice(item.getBuyPrice());
        itemDto.setCategories(null);
        itemDto.setCountry(item.getCountry());
        itemDto.setCreatedDate(item.getCreatedDate());
        itemDto.setCurrently(item.getCurrently());
        itemDto.setDescription(item.getDescription());
        itemDto.setEndDate(item.getEndDate());
        itemDto.setFirstBid(item.getFirstBid());
        itemDto.setLatitude(item.getLatitude());
        itemDto.setLongitude(item.getLongitude());
        itemDto.setName(item.getName());
        itemDto.setNumberOfBids(item.getNumberOfBids());
        itemDto.setSellerId(item.getUser().getUserId());
        itemDto.setStartDate(item.getStartDate());
        itemDto.setCategories(item.getCategories());

        itemDto.setImages(item.getPhotosesByItemId());

        return itemDto;
    }
    
    public static ItemJax item2ItemJax(Item item)
    {
    	ItemJax itemJax =new ItemJax();
        itemJax.setItemID(String.valueOf(item.getItemId()));
        itemJax.setName(item.getName());
        itemJax.getCategory().addAll(item.getCategories().stream().map(CategoryMapper::mapCategoryToCategoryJAX).collect(Collectors.toList()));
        itemJax.setCurrently(item.getCurrently().toString());
        itemJax.setBuyPrice(item.getBuyPrice().toString());
        itemJax.setFirstBid(item.getFirstBid().toString());
        itemJax.setNumberOfBids(item.getNumberOfBids().toString());
        LocationJax loc = new LocationJax();
        //TODO add location to database
        if (item.getLatitude() != null)
            loc.setLatitude(String.valueOf(item.getLatitude()));
        if (item.getLongitude() != null)
            loc.setLongitude(String.valueOf(item.getLongitude()));
        itemJax.setLocation(loc);
        itemJax.setCountry(item.getCountry());
        if (item.getStartDate()!=null)
         itemJax.setStarted(item.getStartDate().toString());
        itemJax.setEnds(item.getEndDate().toString());
        itemJax.setDescription(item.getDescription());
        
        itemJax.setSeller(UserMapper.mapUserToSellerJax(item.getUser()));


        
        
    	return itemJax;
    }
    
    
    
    
    
    
    
}
