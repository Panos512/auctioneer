package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by Panos on 6/8/16.
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
    private List<Category> categories;
    private int sellerId;
//    private Collection<Bids> bidsesByItemId;
//    private Users usersBySellerId;
//    private Collection<ItemCategory> itemCategoriesByItemId;
    private List<Photos> photosesByItemId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    @Basic
    @Column(name = "SellerId")
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }




    @OneToMany(mappedBy = "itemByItemid")
    public List<Photos> getPhotosesByItemId() {
        return photosesByItemId;
    }

    public void setPhotosesByItemId(List<Photos> photosesByItemId) {
        this.photosesByItemId = photosesByItemId;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemId != item.itemId) return false;
        if (Double.compare(item.latitude, latitude) != 0) return false;
        if (Double.compare(item.longitude, longitude) != 0) return false;
        if (sellerId != item.sellerId) return false;
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
        result = 31 * result + sellerId;
        return result;
    }

    @ManyToMany
    @JoinTable(name = "ItemCategory", catalog = "", schema = "auctioneer", joinColumns = @JoinColumn(name = "ItemId", referencedColumnName = "ItemId", nullable = false), inverseJoinColumns = @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId", nullable = false))
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

//    @OneToMany(mappedBy = "itemByItemId")
//    public Collection<Bids> getBidsesByItemId() {
//        return bidsesByItemId;
//    }
//
//    public void setBidsesByItemId(Collection<Bids> bidsesByItemId) {
//        this.bidsesByItemId = bidsesByItemId;
//    }

//    @ManyToOne
//    @JoinColumn(name = "SellerId", referencedColumnName = "UserID", nullable = false)
//    public Users getUsersBySellerId() {
//        return usersBySellerId;
//    }
//
//    public void setUsersBySellerId(Users usersBySellerId) {
//        this.usersBySellerId = usersBySellerId;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", currently=" + currently +
                ", buyPrice=" + buyPrice +
                ", firstBid=" + firstBid +
                ", numberOfBids=" + numberOfBids +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", country='" + country + '\'' +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", sellerId=" + sellerId +
                ", photosesByItemId=" + photosesByItemId +
                '}';
    }


    //    @OneToMany(mappedBy = "itemByItemId")
//    public Collection<ItemCategory> getItemCategoriesByItemId() {
//        return itemCategoriesByItemId;
//    }
//
//    public void setItemCategoriesByItemId(Collection<ItemCategory> itemCategoriesByItemId) {
//        this.itemCategoriesByItemId = itemCategoriesByItemId;
//    }
//

}
