package com.theironyard.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AndroidContacts extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView list;
    EditText name;
    EditText phoneNumber;
    Button addButton;
    ArrayAdapter<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);  //boiler plate code
        name = (EditText) findViewById(R.id.editText2);
        phoneNumber = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String itemName = name.getText().toString() + ", " + phoneNumber.getText().toString();
        items.add(itemName);
        name.setText("");
        phoneNumber.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
