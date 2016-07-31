package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by dimitris on 7/31/16.
 */
@Entity
public class Bids {
    private int bidId;
    private Date bidDate;
    private BigDecimal offerPrice;

    @Id
    @Column(name = "BidId")
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
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
        if (bidDate != null ? !bidDate.equals(bids.bidDate) : bids.bidDate != null) return false;
        if (offerPrice != null ? !offerPrice.equals(bids.offerPrice) : bids.offerPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bidId;
        result = 31 * result + (bidDate != null ? bidDate.hashCode() : 0);
        result = 31 * result + (offerPrice != null ? offerPrice.hashCode() : 0);
        return result;
    }
}
