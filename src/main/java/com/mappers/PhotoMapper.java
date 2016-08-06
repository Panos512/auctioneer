package com.mappers;

import com.dto.PhotoDto;
import com.entity.Photos;


/**
 * Created by Panos on 6/8/16.
 */
public class PhotoMapper {

    public static PhotoDto registerPhotosToPhotoDto (Photos photo) {

        PhotoDto photoDto = new PhotoDto();

        photoDto.setPhotoPath(photo.getPhotoPath());

        return photoDto;
    }

    }
