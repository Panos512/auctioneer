package com.mappers;

import com.dto.*;
import com.entity.Item;
import com.entity.Photos;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public static Item registerUpdateRequestToItem(ItemUpdateRequestDto itemUpdateRequestDto) {

        if (itemUpdateRequestDto == null)
            return null;

        Item  item = new Item();

        item.setItemId(itemUpdateRequestDto.getItemId());

        // TODO: THESE NED TO BE CHECKED BEFORE UPDATE (e.g. a new firstBid comes and it's bigger than the current price etc)
        item.setBuyPrice(itemUpdateRequestDto.getBuyPrice());
        item.setFirstBid(itemUpdateRequestDto.getFirstBid());

        // TODO: check that dates are sensible
        item.setStartDate(itemUpdateRequestDto.getStartDate());
        item.setEndDate(itemUpdateRequestDto.getEndDate());

        item.setCountry(itemUpdateRequestDto.getCountry());


        item.setDescription(itemUpdateRequestDto.getDescription());
        item.setLatitude(itemUpdateRequestDto.getLatitude());
        item.setLongitude(itemUpdateRequestDto.getLongitude());
        item.setName(itemUpdateRequestDto.getName());

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
        itemDto.setSellerId(item.getSellerId());
        itemDto.setStartDate(item.getStartDate());
        itemDto.setCategories(item.getCategories());

        itemDto.setImages(item.getPhotosesByItemId());

        return itemDto;
    }
}
