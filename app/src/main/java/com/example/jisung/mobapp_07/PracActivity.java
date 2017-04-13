package com.example.jisung.mobapp_07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PracActivity extends AppCompatActivity {
    ListView list1;
    ArrayList<String> data =  new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac);

        list1 = (ListView)findViewById(R.id.listView);
        data.add("사과");
        data.add("토마토");
        data.add("오랜지");
        data.add("사과");
        data.add("토마토");
        data.add("오랜지");
        data.add("사과");
        data.add("토마토");
        data.add("오랜지");
        data.add("사과");
        data.add("토마토");
        data.add("오랜지");
        data.add("사과");
        data.add("토마토");
        data.add("오랜지");

        e1 = (EditText)findViewById(R.id.e1);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,data);
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        adapter.insert("키위",data.size());//어뎁터로 직접추가
        list1.setAdapter(adapter);



        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                if(search.length() >0)
                    list1.setFilterText(search);//리스트 뷰 내에서 검색 - 데이터 상이 아니다.
                else
                    list1.clearTextFilter();

            }
        });//글씨가 변경이되면 호출이 되는것
    }
    public void onClick(View v){

        if(v.getId() == R.id.bSort){
            Comparator<String> nameAsc = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);//여기서 기준을 정해준다. compareI 어쩌구는 대소문자비교 asx
                }
            };
            Log.d("bsort","come");
            Collections.sort(data,nameAsc);
            adapter.notifyDataSetChanged();
        }
        else{
            data.add(e1.getText().toString());
            adapter.notifyDataSetChanged();
        }
    }

}
