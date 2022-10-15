package com.example.dailychef;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ReceitaDao {

    @Query("SELECT * FROM receita")
    List<Receita> getReceitas();

    @Query("SELECT * FROM receita WHERE recipeOwner LIKE :recipeOwner")
    List<Receita> getReceitasByOwner(String recipeOwner);

    @Query("SELECT * FROM receita WHERE recipeId LIKE :recipeId")
    Receita getReceitaById(int recipeId);

    @Insert
    void insertRecipe(Receita... receitas);

    @Update
    void updateRecipe(Receita... receitas);
}
