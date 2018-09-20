package com.appseries.zainaftab.crazy3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.appseries.zainaftab.crazy3.Adapters.CustomAdapter;
import com.appseries.zainaftab.crazy3.Models.DataModel;

import java.util.Calendar;

/**
 * Created by zkingleo2009 on 9/19/2018.
 *
 * @package com.appseries.zainaftab.crazy3
 * @project Crazy3
 */

public class HighScoreActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);

        Intent i = getIntent();
        DataModel dm = new DataModel(i.getStringExtra("name"),
                Calendar.getInstance().getTime().getDate() + "",
                i.getStringExtra("score"));
        Globals.list.add(dm);

        CustomAdapter customAdapter = new CustomAdapter(Globals.list, this);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(customAdapter);
    }
}
