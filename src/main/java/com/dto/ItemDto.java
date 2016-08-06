package com.dto;

import com.entity.Category;
import com.dto.CategoryDto;
import com.entity.Photos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mappers.PhotoMapper;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;


/**
 * Created by panos on 8/1/16.
 */
public class ItemDto {

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
    private int sellerId;
    private List<Category> categories;

    @OneToMany(mappedBy="Item")
    private List<PhotoDto> images;

    public List<PhotoDto> getImages() {
        return images;
    }

    private PhotoDto convertToPhotoDTO(Photos photo) {
        return PhotoMapper.registerPhotosToPhotoDto(photo);
    }

    private List<PhotoDto> convertToPhotoDTOs(List<Photos> photos) {
        return photos.stream()
                .map(this::convertToPhotoDTO)
                .collect(toList());
    }


    public void setImages(List<Photos> images) {

        this.images = convertToPhotoDTOs(images);
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCurrently() {
        return currently;
    }

    public void setCurrently(BigDecimal currently) {
        this.currently = currently;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getFirstBid() {
        return firstBid;
    }

    public void setFirstBid(BigDecimal firstBid) {
        this.firstBid = firstBid;
    }

    public Integer getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(Integer numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
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
                ", categories=" + categories +
                ", images=" + images +
                '}';
    }
}
