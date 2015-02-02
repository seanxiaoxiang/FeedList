package com.example.wesleyxiao.feedlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MainActivity extends Activity
{
    private String[] names = new String[]{"name1","name2","name3","name4"};
    private String[] descs = new String[]{"desc1","desc2","desc3","desc4"};
    private int[] imageIds = new int[]{R.drawable.fengzheng,R.drawable.fire,R.drawable.lianhua,R.drawable.yunduo};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listitems = new ArrayList<Map<String, Object>>();
        for(int i=0;i<names.length;i++)
        {
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("header",imageIds[i]);
            item.put("name",names[i]);
            item.put("desc",descs[i]);
            listitems.add(item);
        }

        //创建一个simpleadapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitems,R.layout.simple_item,
                new String[]{"name","header","desc"},
                new int[]{R.id.name,R.id.header,R.id.desc});

        ListView listView = (ListView)findViewById(R.id.feedlistview);

        listView.setAdapter(simpleAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
