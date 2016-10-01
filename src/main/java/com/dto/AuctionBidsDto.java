package com.dto;

import com.entity.Bids;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by Panos on 26/8/16.
 */
public class AuctionBidsDto {

    private int itemId;
    private String itemName;
    private Date startDate;
    private Date endDate;
    private List<Bids> bids;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Bids> getBids() {
        return bids;
    }

    public void setBids(List<Bids> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "AuctionBidsDto{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bids=" + bids +
                '}';
    }
}
