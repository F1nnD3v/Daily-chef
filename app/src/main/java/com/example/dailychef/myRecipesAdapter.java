package com.example.dailychef;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecipesAdapter extends RecyclerView.Adapter<myRecipesAdapter.ViewHolder> {

    List<Receita> receitas;
    Context context;
    LayoutInflater layoutInflater;

    public myRecipesAdapter(Context ctx, List<Receita> receitas){
        this.receitas = receitas;
        this.layoutInflater = LayoutInflater.from(ctx);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.grid_layout_my_recipes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recipeName.setText(receitas.get(position).recipeName);
        String recipeId = String.valueOf(receitas.get(position).recipeId);
        holder.imageMyRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditRecipeActivity.class);
                intent.putExtra("recipeId", recipeId);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return receitas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView recipeName;
        ImageView imageMyRecipe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.txtRecipeNameEditRecipe);
            imageMyRecipe = itemView.findViewById(R.id.imageMyRecipes);
        }
    }
}
