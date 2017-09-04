package bodor.com.viewpagedemo;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private String[] images;
    private Activity activity;
    private LayoutInflater inflater;

    public ViewPagerAdapter(String[] images, Activity activity) {
        this.images = images;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    inflater  = (LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View itemView = inflater.inflate(R.layout.viewpager_item,container,false);

        ImageView imageView;
        imageView = (ImageView)itemView.findViewById(R.id.imageView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width  = displayMetrics.widthPixels;

        imageView.setMinimumHeight(height);
        imageView.setMinimumWidth(width);
        try {
            Picasso.with(activity)
                    .load(images[position])
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
        }catch (Exception ex){
        }
        container.addView(itemView);
        return itemView;
    }
    
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
