# MaskTextView
Use a user-defined TextView--->MaskTextView to achieve a ListView with gradient effect.<br> 用一个自定义的TextView--->MaskTextView去实现一个带渐变效果的ListView

## Introduce ##
**Actually,this *GradientListView* is made by a user-defined *TextView* with MaskEffect,Through the text set to transparent and set the gradient background resource,then you get it. The text color is the background's color**

实际上，这个渐变效果的ListView是用一个有蒙板效果的自定义TextView做的,通过把文字设置成透明,再设置一个渐变效果的背景资源，就完成了。文字的颜色就被是背景资源的颜色。

![](http://i.imgur.com/vD2D6ZP.gif)
![](http://i.imgur.com/U2fqzf0.gif)

## Attentions ##
<br>
**1、The Class ‘MyTextView’ (A user-defined TextView).**

    lineNumber 56:c.drawColor(Color.argb(255, 50, 50, 50)); 
You can change the color you need，ensure the Alpha value is 255 so the text's surrounding is not transparent.

(译：类MyTextView是自定义的TextView;
56行:c.drawColor(Color.argb(255, 50, 50, 50));
您可以根据自己的需要进行调节颜色，但是Alpha值应该为255保证其不透明)

<br>
**2、The Class ‘MyTextView’**

    lineNumber 57:c.drawText(getText().toString(), 50, 80, mTextPaint);
You can change the text's position by need.

(译：类MyTextView 57行c.drawText(getText().toString(),50,80, mTextPaint); 调节文字的位置，根据需要自行调节)

   <br>
**3、In the item's xml_layout,Replace the TextView to MyTextView；**

(译：在ListView的条目布局中，把TextView替换为MyTextView）
<br>

**4、Set the background resources for the gradient background you want，You can display background with a FrameLayout.**

(译：设置背景资源为你想要的渐变背景，可以用一个帧布局来显示背景）

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@drawable/bg4" >
        </FrameLayout>

        <ListView
            android:id="@+id/lv_gradient"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:divider="@null" />
