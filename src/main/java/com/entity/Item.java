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
public class Item {
    private int itemId;
    private String name;
    private BigDecimal currently;
    private BigDecimal buyPrice;
    private BigDecimal firstBid;
    private Integer numberOfBids;
    private double latitude;
    private double longitude;
    private String country;
    private Date createdDate;
    private Date startDate;
    private Date endDate;
    private String description;

    @Id
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Currently")
    public BigDecimal getCurrently() {
        return currently;
    }

    public void setCurrently(BigDecimal currently) {
        this.currently = currently;
    }

    @Basic
    @Column(name = "Buy_Price")
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Basic
    @Column(name = "First_Bid")
    public BigDecimal getFirstBid() {
        return firstBid;
    }

    public void setFirstBid(BigDecimal firstBid) {
        this.firstBid = firstBid;
    }

    @Basic
    @Column(name = "Number_Of_Bids")
    public Integer getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(Integer numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    @Basic
    @Column(name = "Latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "CreatedDate")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "StartDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "EndDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemId != item.itemId) return false;
        if (Double.compare(item.latitude, latitude) != 0) return false;
        if (Double.compare(item.longitude, longitude) != 0) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (currently != null ? !currently.equals(item.currently) : item.currently != null) return false;
        if (buyPrice != null ? !buyPrice.equals(item.buyPrice) : item.buyPrice != null) return false;
        if (firstBid != null ? !firstBid.equals(item.firstBid) : item.firstBid != null) return false;
        if (numberOfBids != null ? !numberOfBids.equals(item.numberOfBids) : item.numberOfBids != null) return false;
        if (country != null ? !country.equals(item.country) : item.country != null) return false;
        if (createdDate != null ? !createdDate.equals(item.createdDate) : item.createdDate != null) return false;
        if (startDate != null ? !startDate.equals(item.startDate) : item.startDate != null) return false;
        if (endDate != null ? !endDate.equals(item.endDate) : item.endDate != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (currently != null ? currently.hashCode() : 0);
        result = 31 * result + (buyPrice != null ? buyPrice.hashCode() : 0);
        result = 31 * result + (firstBid != null ? firstBid.hashCode() : 0);
        result = 31 * result + (numberOfBids != null ? numberOfBids.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
