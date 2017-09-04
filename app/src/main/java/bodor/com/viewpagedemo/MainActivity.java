package bodor.com.viewpagedemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    private String[] images = {
        "http://i.imgur.com/DvpvklR.png",
        "http://i.imgur.com/DvpvklR.png",
        "http://i.imgur.com/DvpvklR.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        viewPager.setAdapter(new ViewPagerAdapter(images,this));
    }
}
