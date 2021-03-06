package com.hunter.cookies.utils;

import android.text.TextUtils;

import com.hunter.cookies.entity.ImagesEntity;

public class ImageUrlUtils {

    public static String getImageUrl(ImagesEntity entity) {
        if (!TextUtils.isEmpty(entity.getHidpi())) return entity.getHidpi();

        if (!TextUtils.isEmpty(entity.getNormal())) return entity.getNormal();

        if (!TextUtils.isEmpty(entity.getTeaser())) return entity.getTeaser();

        return "";
    }
}
