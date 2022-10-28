package com.example.dailychef.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Time;

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

    @ColumnInfo(name = "CreatedAt")
    public String createdAt;

    @Ignore
    public Receita(int recipeId, String recipeName, String recipeDescription, String recipeWayToDo, boolean shared, String recipeOwner, String createdAt) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeWayToDo = recipeWayToDo;
        this.shared = shared;
        this.recipeOwner = recipeOwner;
        this.createdAt = createdAt;
    }

    public Receita(String recipeName, String recipeDescription, String recipeWayToDo, boolean shared, String recipeOwner, String createdAt) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeWayToDo = recipeWayToDo;
        this.shared = shared;
        this.recipeOwner = recipeOwner;
        this.createdAt = createdAt;
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

    public String getRecipeOwner() {
        return recipeOwner;
    }

    public void setRecipeOwner(String recipeOwner) {
        this.recipeOwner = recipeOwner;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
