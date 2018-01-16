package com.emily.listview_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List cityList=new ArrayList();
    private ListView listView;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=this.findViewById(R.id.listView1);
        button1=this.findViewById(R.id.button1);
        button2=this.findViewById(R.id.button2);
        button3=this.findViewById(R.id.button3);
        final boolean isCheckedArray[] =new boolean[8];
        isCheckedArray [0]=false;
        isCheckedArray [1]=true;
        isCheckedArray [2]=false;
        isCheckedArray [3]=true;
        isCheckedArray [4]=false;
        isCheckedArray [5]=true;
        isCheckedArray [6]=false;
        isCheckedArray [7]=true;
       for(int i=0;i<8;i++){
           cityList.add("数据"+i);
       }

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,cityList);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.v("----------------",""+((TextView)v).getText());

            }
        });

        //赋初值
        for(int i=0;i<isCheckedArray.length;i++){
            listView.setItemChecked(i,isCheckedArray[i]);
        }

            //全选
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("单机了全选","\"单机了全选\"");
                for(int i=0;i<isCheckedArray.length;i++){
                    listView.setItemChecked(i,true);
                }
            }
        });
        //反选
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("单击了反选","单击了反选");
                SparseBooleanArray sparseBooleanArrayRef=listView.getCheckedItemPositions();
                for(int i=0;i<sparseBooleanArrayRef.size();i++){
                    if (sparseBooleanArrayRef.get(i)==true){
                        listView.setItemChecked(i,false);
                    }else {
                        listView.setItemChecked(i,true);
                    }
                }

            }
        });
        //取值
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("单击了取值","单击了取值");
                SparseBooleanArray sparseBooleanArrayRef=listView.getCheckedItemPositions();
                for(int i=0;i<sparseBooleanArrayRef.size();i++){
                    if (sparseBooleanArrayRef.get(i)==true){
                        Log.v("值为：", "" + listView.getAdapter().getItemId(i));
                        listView.getAdapter().getItemId(i);
                    }
                }
            }
        });
    }
}
