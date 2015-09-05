package com.example.gradientdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.TextView;

public class MaskTextView extends TextView
{

    private Paint  mTextPaint;
    private Bitmap mBitmapToDraw;

    public MaskTextView(Context context) {
        super(context);

        setup();
    }

    public MaskTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setup();
    }

    public MaskTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setup();
    }

    private void setup()
    {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(getTextSize());
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (mBitmapToDraw == null)
        {
            mBitmapToDraw = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        }
        if (mBitmapToDraw != null)
        {
            Canvas c = new Canvas(mBitmapToDraw);
            
            c.drawColor(Color.argb(255, 50, 50, 50));
            c.drawText(getText().toString(), 50, 80, mTextPaint);
        }
        if (mBitmapToDraw != null)
        {
            canvas.drawBitmap(mBitmapToDraw, 0, 0, null);
        }
        else
        {
            super.onDraw(canvas);
        }
    }
}