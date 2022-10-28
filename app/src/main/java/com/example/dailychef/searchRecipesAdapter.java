package com.example.dailychef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailychef.DB.Receita;

import java.util.List;

public class searchRecipesAdapter extends RecyclerView.Adapter<searchRecipesAdapter.ViewHolder> {

    List<Receita> receitaList;
    Context context;
    LayoutInflater layoutInflater;

    public searchRecipesAdapter(Context ctx, List<Receita> receitas){
        this.receitaList = receitas;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public searchRecipesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_search_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull searchRecipesAdapter.ViewHolder holder, int position) {
        holder.txtRecipeSearch.setText(receitaList.get(position).recipeName);
        holder.txtDescriptionRecipeSearch.setText(receitaList.get(position).recipeDescription);
    }

    @Override
    public int getItemCount() {
        return receitaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtRecipeSearch, txtDescriptionRecipeSearch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRecipeSearch = itemView.findViewById(R.id.txtRecipeNameSearch);
            txtDescriptionRecipeSearch = itemView.findViewById(R.id.txtRecipeDescriptionSearch);
        }
    }
}
