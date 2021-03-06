package com.echsylon.recipe;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.echsylon.recipe.common.BlurTransformation;
import com.echsylon.recipe.common.ColorFilterTransformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onItemClicked(Recipe.Summary data);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView excerpt;

        private ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            excerpt = (TextView) itemView.findViewById(R.id.excerpt);
        }

        private void bind(Recipe.Summary data) {
            title.setText(data.name);
            excerpt.setText(data.excerpt);

            Context context = title.getContext();
            Picasso.with(context)
                    .load(String.format("%s/images/%s", BuildConfig.BASE_URL, data.image))
                    .transform(new ColorFilterTransformation(Color.argb(128, 0, 0, 0)))
                    .transform(new BlurTransformation(context, 4f))
                    .into(new SummaryBackgroundTarget(itemView));
        }
    }

    private ArrayList<Recipe.Summary> content = new ArrayList<>();
    private ItemClickListener itemClickListener;

    @Override
    public RecipeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_summary, parent, false));
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.ViewHolder holder, final int position) {
        holder.bind(content.get(position));
        holder.itemView.setOnClickListener(view -> {
            if (itemClickListener != null)
                itemClickListener.onItemClicked(content.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public void setItemClickListener(final ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setContent(Recipe.Summary[] data) {
        content.clear();
        content.addAll(Arrays.asList(data));
        notifyDataSetChanged();
    }
}
