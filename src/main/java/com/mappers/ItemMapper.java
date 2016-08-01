package com.mappers;

import com.dto.ItemDto;
import com.entity.Item;

/**
 * Created by panos on 8/1/16.
 */
public class ItemMapper {

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
        itemDto.setSellerId(item.getSellerId());
        itemDto.setStartDate(item.getStartDate());

        return itemDto;
    }
}
