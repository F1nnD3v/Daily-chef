package com.example.dailychef;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyRecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyRecipesFragment extends Fragment {

    ImageButton btnAddRecipe;
    AppDatabase db;
    String username;

    RecyclerView myRecipesRecycler;

    TextView txtNoRecipes;

    myRecipesAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyRecipesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyRecipesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyRecipesFragment newInstance(String param1, String param2) {
        MyRecipesFragment fragment = new MyRecipesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_recipes, container, false);

        btnAddRecipe = view.findViewById(R.id.btnAddRecipe);
        txtNoRecipes = view.findViewById(R.id.txtNoRecipes);
        myRecipesRecycler = view.findViewById(R.id.rvMyRecipes);

        db = AppDatabase.getDbInstance(getContext());

        if(getArguments() != null) {
            username = getArguments().getString("username");
        }
        List<Receita> receitas = db.receitaDao().getReceitasByOwner(username);
        if(receitas.isEmpty()){
            txtNoRecipes.setText("You dont have recipes.");
        }else{
            txtNoRecipes.setText("");
            adapter = new myRecipesAdapter(getContext(), receitas);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
            myRecipesRecycler.setLayoutManager(gridLayoutManager);
            myRecipesRecycler.setAdapter(adapter);
        }

        btnAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewRecipeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        return view;
    }
}