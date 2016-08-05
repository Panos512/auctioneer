package com.entity;

import javax.persistence.*;

/**
 * Created by Panos on 6/8/16.
 */
@Entity
public class Photos {
    private int photoId;
//    private int itemid;
    private String photoPath;
    private Item itemByItemid;

    @Id
    @GeneratedValue
    @Column(name = "PhotoId")
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

//    @Basic
//    @Column(name = "ItemId")
//    public int getItemid() {
//        return itemid;
//    }
//
//    public void setItemid(int itemid) {
//        this.itemid = itemid;
//    }

    @Basic
    @Column(name = "PhotoPath")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photos photos = (Photos) o;

        if (photoId != photos.photoId) return false;
//        if (itemid != photos.itemid) return false;
        if (photoPath != null ? !photoPath.equals(photos.photoPath) : photos.photoPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = photoId;
//        result = 31 * result + itemid;
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ItemId", referencedColumnName = "ItemId", nullable = false)
    public Item getItemByItemid() {
        return itemByItemid;
    }

    public void setItemByItemid(Item itemByItemid) {
        this.itemByItemid = itemByItemid;
    }


    @Override
    public String toString() {
        return "Photos{" +
                "photoId=" + photoId +
                ", photoPath='" + photoPath + '\'' +
//                ", itemByItemid=" + itemByItemid +
                '}';
    }
}
