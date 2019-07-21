package com.kagiri.islam.additemstolistview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<String> countries;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = new ArrayList<>();
        populateList();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Inflate your custom view and get handle to EditText
        View view = LayoutInflater.from(this).inflate(R.layout.aleert_custom, null);
        final EditText editText = view.findViewById(R.id.editext);

        //Add view to the alertdialog
        builder.setView(view);
        builder.setTitle(("Enter info"));

        /**Set the positive button and define what happens when the btton is clicked
         * Here you u get the text entered in the editText and add it to the Countries ArrayList you created earler.
         * Make sure to update the list object object already to tied to the Adapter
         * call Adapter.notifyDatachanged to for the adapter to update the listview view with the new items added*/
        builder.setPositiveButton("Add Item", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Extract the entered text in the dialog's editText and add the text to arrayList
                String text = editText.getText().toString();
                countries.add(text);

                //Cal this for the listview to be updated with the changes in the data
                adapter.notifyDataSetChanged();

            }
        });

        builder.setNegativeButton("No",null);
        builder.create().show();
    }

    private void populateList(){
        countries = new ArrayList<>();
        countries.add("Uganda");
        countries.add("Kenya");
        countries.add("Tanzania");
        countries.add("Rwanda");
        countries.add("Congo");
        countries.add("Burindi");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add)
            showDialog();
        return super.onOptionsItemSelected(item);
    }
}