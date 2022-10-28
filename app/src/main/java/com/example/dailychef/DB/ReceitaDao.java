package com.example.dailychef.DB;

import androidx.room.Dao;
import androidx.room.Delete;
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

    @Query("SELECT * FROM receita ORDER BY random() LIMIT 10")
    List<Receita> getRandRecipes();

    @Query("SELECT * FROM receita WHERE recipeName LIKE '%' || :procurar || '%' OR recipeDescription LIKE '%' || :procurar || '%'")
    List<Receita> procurarReceita(String procurar);

    @Insert
    void insertRecipe(Receita... receitas);

    @Update
    void updateRecipe(Receita... receitas);

    @Delete
    void deleteRecipe(Receita... receitas);
}
