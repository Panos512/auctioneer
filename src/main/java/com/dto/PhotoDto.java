package com.dto;

import com.entity.Item;

/**
 * Created by Panos on 6/8/16.
 */
public class PhotoDto {

//    private int photoId;
    private String photoPath;
//    private Item itemByItemid;


//    public int getPhotoId() {
//        return photoId;
//    }
//
//    public void setPhotoId(int photoId) {
//        this.photoId = photoId;
//    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

//    public Item getItemByItemid() {
//        return itemByItemid;
//    }
//
//    public void setItemByItemid(Item itemByItemid) {
//        this.itemByItemid = itemByItemid;
//    }


    @Override
    public String toString() {
        return "PhotoDto{" +
                "photoPath='" + photoPath + '\'' +
                '}';
    }
}
