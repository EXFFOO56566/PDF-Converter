package com.tochy.pdf.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.eftimoff.viewpagertransformers.DepthPageTransformer;

import java.util.ArrayList;

import com.tochy.pdf.R;
import butterknife.ButterKnife;
import com.tochy.pdf.adapter.AdapterPreview;
import com.tochy.pdf.util.ThemeUtils;

import static com.tochy.pdf.Constants.PREVIEW_IMAGES;

public class ActivityImagesPreview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.getInstance().setThemeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_images);

        ButterKnife.bind(this);
        // Extract mImagesArrayList uri array from the intent
        Intent intent = getIntent();
        ArrayList<String> mImagesArrayList = intent.getStringArrayListExtra(PREVIEW_IMAGES);

        ViewPager mViewPager = findViewById(R.id.viewpager);
        AdapterPreview mAdapterPreview = new AdapterPreview(this, mImagesArrayList);
        mViewPager.setAdapter(mAdapterPreview);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    /**
     * get start intent for this activities
     * @param context - context to start activities from
     * @param uris - extra images uri
     * @return - start intent
     */
    public static Intent getStartIntent(Context context, ArrayList<String>  uris) {
        Intent intent = new Intent(context, ActivityImagesPreview.class);
        intent.putExtra(PREVIEW_IMAGES, uris);
        return intent;
    }
}