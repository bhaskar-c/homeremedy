package com.app.homecure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class Home extends Activity {


    private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
    ArrayList<String> titles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Listview Data
        try {
            titles = XmlParser.getTitlesFromXml(this);
            lv = (ListView) findViewById(R.id.list_view);
            adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.title, titles);
            lv.setAdapter(adapter);
        } catch (XmlPullParserException e) {
        } catch (IOException e) {
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String title = ((TextView) view.findViewById(R.id.title)).getText().toString();
                Intent intent = new Intent(view.getContext(), WebViewDisplay.class);
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });


        /**
         * Enabling Search Filter
         * */
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Home.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });
    }


}