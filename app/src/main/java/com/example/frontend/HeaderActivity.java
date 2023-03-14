package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HeaderActivity extends AppCompatActivity {
    ImageView imgHeader;
    float mScaleFactor = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        imgHeader = findViewById(R.id.imgHover);
        imgHeader.setOnClickListener(V -> {
            if (mScaleFactor != 1.0f) {
                mScaleFactor = 1.0f;
                imgHeader.setScaleX(mScaleFactor);
                imgHeader.setScaleY(mScaleFactor);
            } else {
                showZoomedImage();
            }
        });
    }


    private void showZoomedImage() {
        Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.airforce);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scaleGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        dialog.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        dialog.show();
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imgHeader.setScaleX(mScaleFactor);
            imgHeader.setScaleY(mScaleFactor);
            return true;
        }
    }
}