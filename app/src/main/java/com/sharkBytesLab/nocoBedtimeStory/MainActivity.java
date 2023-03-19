package com.sharkBytesLab.nocoBedtimeStory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class MainActivity extends AppCompatActivity {

    //CODE HERE
    RecyclerView recyclerView;
    Adapter adapter;

    //UPTO HERE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
            }
        } );

        //CODE HERE
        String[] titles = getResources().getStringArray(R.array.stories_title);
        String[] contents = getResources().getStringArray(R.array.story_content);
        recyclerView = findViewById(R.id.storiesListsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,titles,contents);
        recyclerView.setAdapter(adapter);



        //UPTO HERE

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case  R.id.menu_btn:
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
                return true;
        }
        return false;
    }


}