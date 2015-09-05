package com.example.gradientdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
    ListView         listView;
    private String[] mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_gradient);
        mDatas = initData(100);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    private String[] initData(int i)
    {
        String[] arr = new String[i];
        for (int j = 0; j < i; j++)
        {
            arr[j] = "AAAAAAAAAAA" + j;
        }
        return arr;
    }

    class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return mDatas.length;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder;
            if (convertView == null)
            {
                convertView = View.inflate(getApplicationContext(), R.layout.item, null);
                holder = new ViewHolder();
                holder.textView = (MaskTextView) convertView.findViewById(R.id.tv);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(mDatas[position]);
            return convertView;
        }
    }

    class ViewHolder
    {
        MaskTextView textView;
    }
}
