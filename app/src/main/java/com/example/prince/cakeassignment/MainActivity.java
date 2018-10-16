package com.example.prince.cakeassignment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
     CakeViewModel cakeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.cake_recycle);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);

        cakeViewModel = ViewModelProviders.of(this).get(CakeViewModel.class);//new CakeViewModel(this.getApplication());
        if(cakeViewModel.getNewsResponseObservable().getValue() == null) System.out.println("well fuck");
        CakeListAdapter adapter = new CakeListAdapter(cakeViewModel.getNewsResponseObservable().getValue());
        rv.setAdapter(adapter);
        cakeViewModel.getNewsResponseObservable().observe(this, new Observer<List<Cake>>() {
            @Override
            public void onChanged(final List<Cake> cakes) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(cakes);
            }
        });
    }
}
