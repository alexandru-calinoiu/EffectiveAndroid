package com.israelferrer.effectiveandroid.ui;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public final class DataBinder {
  private DataBinder() {

  }

  @BindingAdapter("imageUrl")
  public static void setImageUrl(ImageView view, String url) {
    if (url.isEmpty()) {
      return;
    }

    Context context = view.getContext();
    Picasso.with(context).load(url).into(view);
  }
}
