package com.example.dailychef;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Receita {

    @PrimaryKey(autoGenerate = true)
    public int recipeId;

    @ColumnInfo(name = "recipeName")
    public String recipeName;

    @ColumnInfo(name = "recipeDescription")
    public String recipeDescription;

    @ColumnInfo(name = "recipeWayToDo")
    public String recipeWayToDo;

    @ColumnInfo(name = "shared")
    public boolean shared;

    @ColumnInfo(name = "recipeOwner")
    public String recipeOwner;

    public Receita(String recipeName, String recipeDescription, String recipeWayToDo, boolean shared, String recipeOwner) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeWayToDo = recipeWayToDo;
        this.shared = shared;
        this.recipeOwner = recipeOwner;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String getRecipeWayToDo() {
        return recipeWayToDo;
    }

    public void setRecipeWayToDo(String recipeWayToDo) {
        this.recipeWayToDo = recipeWayToDo;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
