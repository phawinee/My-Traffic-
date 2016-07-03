package thailand.mee.phawinee.mytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DateilActivity extends AppCompatActivity {

    //Explicit
    TextView nameTextView, detailTextView;  //การประกาศตัวแปรอย่างย่อจะเป็น private อัตโนมัต
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateil);

            //Bind Widget
        nameTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);


            //Get value from Intent
        String strName = getIntent().getStringExtra("Name");
        int inIcon = getIntent().getIntExtra("Icon", R.drawable.traffic_01);
        int intIndex = getIntent().getIntExtra("Index", 0);

        //Check log
        Log.d("traffic", "strName ==>" + strName);
        Log.d("traffic", "Icon ==>" + inIcon);
        Log.d("traffic", "Index ==>" + intIndex);

        //Show View
        nameTextView.setText(strName);
        imageView.setImageResource(inIcon);

        String[] detailStrings = getResources().getStringArray(R.array.long_data);
        detailTextView.setText(detailStrings[intIndex]);



    }//Main Method

    public void clickBack(View view) {
        finish();
    }

}   //Main class
