package com.israelferrer.effectiveandroid.ui.recycler;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.israelferrer.effectiveandroid.R;
import com.israelferrer.effectiveandroid.databinding.ArticleLayoutBinding;
import com.israelferrer.effectiveandroid.entities.Article;

import java.util.List;

/**
 * Created by icamacho on 8/9/15.
 */
public class ArticleRecyclerView extends RecyclerView.Adapter<ArticleRecyclerView.ArticleViewHolder> {
  private List<Article> items;

  public ArticleRecyclerView(List<Article> items) {
    if (items == null) {
      throw new NullPointerException(
          "items must not be null");
    }
    this.items = items;
  }

  @Override
  public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.
        from(parent.getContext()).
        inflate(R.layout.article_layout,
            parent,
            false);
    return new ArticleViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(ArticleViewHolder holder, int position) {
    final Article article = items.get(position);
    holder.bind(article);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public Article getItem(int position) {
    return items.get(position);
  }

  final static class ArticleViewHolder extends RecyclerView.ViewHolder {
    private final ArticleLayoutBinding binding;

    public ArticleViewHolder(View itemView) {
      super(itemView);
      binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Article article) {
      binding.setArticle(article);
    }
  }
}
