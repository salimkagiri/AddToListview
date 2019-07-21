package com.kagiri.islam.addToListviewFromDialogKatolin

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu

import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import java.util.*

class AddListItemActivity : AppCompatActivity() {
    /**I swear i will assingn a value to this variable, thsi is what latein
     * this is what the identifier preceding the property coutries mean
     * You have later before using the property assign avalue to it, or else the app will crush**/
      lateinit var  countries: ArrayList<String>
    /**Equavalent to ajva of overrind a method: protected void onCreate(Bundle saveedInstanceState)
     * **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Same as Listview listview = (Listview)findViewById(R.id.list)
        * In Katolin you use "var" for mutable variable or "val" for final variables, varibles which dont change
        * after assigning a value to it*/
        val listview  = findViewById<ListView>(R.id.list)
        countries = ArrayList()
        populateList()

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries)
        listview?.adapter = adapter
        val cb = CheckBox(this)


    }



    fun showDialog() : Dialog {
        val builder = AlertDialog.Builder( this)
        val view = LayoutInflater.from(this).inflate(R.layout.aleert_custom, null)
        val editText = view?.findViewById<EditText>(R.id.editext)
        builder.setTitle("Add Item")

        builder.setPositiveButton("Add Item", DialogInterface.OnClickListener{
            dialog, id -> editText?.let {
            val text = it.text.toString()
            countries.add(text)
        }
        })
        builder.setNegativeButton("Cancel", null)


        builder.setView(view)

        return builder.create()
    }
    val  populateList: ()->Unit = {

        countries.add("Uganda")
        countries.add("Tanzania")
        countries.add("Kenya")
        countries.add("Rwanda")
        countries.add("Malawi")
    }

    override fun onCreateOptionsMenu (menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_add ->{
                showDialog().show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
