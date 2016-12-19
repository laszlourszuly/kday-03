package com.echsylon.recipe;

import android.app.ProgressDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.coordinator_layout)
    protected CoordinatorLayout coordinatorLayout;

    @ViewById(R.id.list)
    protected RecyclerView recyclerView;

    private RecipeListAdapter adapter;
    private ProgressDialog progressDialog;

    @AfterViews
    protected void afterViews() {
        adapter = new RecipeListAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getRecipes();
    }

    private void getRecipes() {
        progressDialog = ProgressDialog.show(this, null, "Loading recipes", true, false);
        Recipe.getRecipes()
                .withFinishListener(() -> progressDialog.dismiss())
                .withSuccessListener(data -> adapter.setContent(data))
                .withErrorListener(cause -> Snackbar.make(coordinatorLayout, "Couldn't load recipes", Snackbar.LENGTH_INDEFINITE)
                        .setAction("RETRY", view -> getRecipes())
                        .show());
    }
}
