package com.dto;

/**
 * Created by Panos on 25/7/16.
 */
public class ItemAddResponseDto {

    public int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "ItemAddResponseDto{" +
                "itemId=" + itemId +
                '}';
    }
}

