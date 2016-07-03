package thailand.mee.phawinee.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Explicit การประกาศตัวแปร
    private ListView trafficListView;
    private Button aboutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind widdet
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutButton = (Button) findViewById(R.id.button);

        //controller for button
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //sound effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.dog);
                mediaPlayer.start();
                //web view
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/kHSFpGBFGHY"));
                startActivity(intent);


            }   //onclick
        });
        //creat listview
        //1. seter array simple
        final int[] icInts = new int[20];
        icInts[0] = R.drawable.traffic_01;
        icInts[1] = R.drawable.traffic_02;
        icInts[2] = R.drawable.traffic_03;
        icInts[3] = R.drawable.traffic_04;
        icInts[4] = R.drawable.traffic_05;
        icInts[5] = R.drawable.traffic_06;
        icInts[6] = R.drawable.traffic_07;
        icInts[7] = R.drawable.traffic_08;
        icInts[8] = R.drawable.traffic_09;
        icInts[9] = R.drawable.traffic_10;
        icInts[10] = R.drawable.traffic_11;
        icInts[11] = R.drawable.traffic_12;
        icInts[12] = R.drawable.traffic_13;
        icInts[13] = R.drawable.traffic_14;
        icInts[14] = R.drawable.traffic_15;
        icInts[15] = R.drawable.traffic_16;
        icInts[16] = R.drawable.traffic_17;
        icInts[17] = R.drawable.traffic_18;
        icInts[18] = R.drawable.traffic_19;
        icInts[19] = R.drawable.traffic_20;

            //2call from xml
        final String[] nameStrings = getResources().getStringArray(R.array.name);

        //3 call from java
        MyData myData = new MyData();   //create opject or instance
        String[] detailStrings = myData.getDetStrings();

        //Inheriate to MyAdapter
        MyAdapter myAdapter = new MyAdapter(this,icInts,nameStrings,detailStrings);
        trafficListView.setAdapter(myAdapter);

        //Intent to Detail When Click
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DateilActivity.class);
                intent.putExtra("name", nameStrings[position]);
                intent.putExtra("Icon", icInts[position]);
                intent.putExtra("Index", position);
                startActivity(intent);



            }   //onItemClick
        });




    }   //main methood
}   //main Class นี่คือคลาสหลัก

