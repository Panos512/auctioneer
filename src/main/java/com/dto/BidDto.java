package com.dto;

import com.entity.Item;
import com.entity.Users;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Panos on 26/8/16.
 */
public class BidDto {

    private int bidId;
    private int userId;
    private int itemId;
    private Date bidDate;
    private BigDecimal offerPrice;

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }

    @Override
    public String toString() {
        return "BidDto{" +
                "bidId=" + bidId +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", bidDate=" + bidDate +
                ", offerPrice=" + offerPrice +
                '}';
    }
}
