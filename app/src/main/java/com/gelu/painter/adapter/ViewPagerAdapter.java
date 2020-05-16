package com.gelu.painter.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gelu.painter.R;
import com.gelu.painter.model.PainterImages;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<PainterImages> imageList;
    private LayoutInflater inflater;
    private OnLikeClick onLikeClick;

    public ViewPagerAdapter(Context context, ArrayList<PainterImages> imageList, OnLikeClick onLikeClick) {
        this.context = context;
        this.imageList = imageList;
        this.onLikeClick = onLikeClick;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {

        View imageLayout = inflater.inflate(R.layout.list_image_details, view, false);

        final PainterImages painterImages = imageList.get(position);
        final AppCompatImageView ivPaint = imageLayout.findViewById(R.id.ivPaint);
        final TextView tvLikeCount = imageLayout.findViewById(R.id.tvLikeCount);
        final AppCompatImageView ivLike = imageLayout.findViewById(R.id.ivLike);

        ivPaint.setImageDrawable(painterImages.getImages());
        tvLikeCount.setText(String.valueOf(painterImages.getLikeCount()));

        if (painterImages.getLike() != null) {
            if (painterImages.getLike()) {
                ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.like));
            } else {
                ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dislike));
            }
        }

        ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLikeClick.onLikeClick(painterImages, position, ivLike,tvLikeCount);
                if (painterImages.getLike() != null) {
                    if (painterImages.getLike()) {
                        ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.like));
                    } else {
                        ivLike.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dislike));
                    }
                }
            }
        });


        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public interface OnLikeClick {
        void onLikeClick(PainterImages painterImages, int position, AppCompatImageView ivLike,TextView tvLikeCount);
    }

}
