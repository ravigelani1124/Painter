package com.gelu.painter.model;

import android.graphics.drawable.Drawable;

public class PainterImages {

    private int id;
    private int likeCount;
    private Drawable images;
    private Boolean isLike;

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Boolean getLike() {
        return isLike;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImages() {
        return images;
    }

    public void setImages(Drawable images) {
        this.images = images;
    }
}
