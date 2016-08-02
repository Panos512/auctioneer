package com.mappers;

import com.dto.ItemAddRequestDto;
import com.dto.ItemDto;
import com.entity.Item;

/**
 * Created by panos on 8/1/16.
 */
public class ItemMapper {


    public static Item registerRequestToItem(ItemAddRequestDto itemAddRequestDto) {

        if (itemAddRequestDto == null)
            return null;

        Item  item = new Item();

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
        item.setSellerId(itemAddRequestDto.getSellerId());
        item.setStartDate(itemAddRequestDto.getStartDate());

        // TODO: WE NEED TO ADD CATEGORIES TO THE ITEM

        return item;
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
        itemDto.setSellerId(item.getSellerId());
        itemDto.setStartDate(item.getStartDate());

        return itemDto;
    }
}
