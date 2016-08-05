package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Panos on 6/8/16.
 */
@Entity
public class Bids {
    private int bidId;
    private int userId;
    private int itemId;
    private Date bidDate;
    private BigDecimal offerPrice;
    private Users usersByUserId;
    private Item itemByItemId;

    @Id
    @Column(name = "BidId")
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    @Basic
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "Bid_Date")
    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    @Basic
    @Column(name = "OfferPrice")
    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bids bids = (Bids) o;

        if (bidId != bids.bidId) return false;
        if (userId != bids.userId) return false;
        if (itemId != bids.itemId) return false;
        if (bidDate != null ? !bidDate.equals(bids.bidDate) : bids.bidDate != null) return false;
        if (offerPrice != null ? !offerPrice.equals(bids.offerPrice) : bids.offerPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bidId;
        result = 31 * result + userId;
        result = 31 * result + itemId;
        result = 31 * result + (bidDate != null ? bidDate.hashCode() : 0);
        result = 31 * result + (offerPrice != null ? offerPrice.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "UserId", referencedColumnName = "UserID", nullable = false)
//    public Users getUsersByUserId() {
//        return usersByUserId;
//    }
//
//    public void setUsersByUserId(Users usersByUserId) {
//        this.usersByUserId = usersByUserId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "ItemId", referencedColumnName = "ItemId", nullable = false)
//    public Item getItemByItemId() {
//        return itemByItemId;
//    }
//
//    public void setItemByItemId(Item itemByItemId) {
//        this.itemByItemId = itemByItemId;
//    }
}
