package com.dharmendra.popupmenu

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.PopupMenu
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find View By Id for button
        val btn = findViewById<Button>(R.id.button) as Button

        //Find View By Id for Relative Layout because We need to Change It's Color.
        val background = findViewById<RelativeLayout>(R.id.relativeLayout) as RelativeLayout

        //On Click for Button to open PopUp menu
        btn.setOnClickListener {

            /*Create Object Of PopupMenu
             we need to pas  Context and View (Our View is Button so we pass btn to it)
             */

            val popUp = PopupMenu(this@MainActivity, btn)

            //Inflate our menu Layout.
            popUp.menuInflater.inflate(R.menu.popup_menu, popUp.menu)


            //Set Click Listener on Popup Menu Item
            popUp.setOnMenuItemClickListener { myItem ->

                //Getting Id of selected Item
                val item = myItem!!.itemId

                when (item) {
                    R.id.red -> {
                        background.setBackgroundColor(Color.RED)
                    }

                    R.id.blue -> {
                        background.setBackgroundColor(Color.BLUE)
                    }

                    R.id.green -> {
                        background.setBackgroundColor(Color.GREEN)
                    }
                }

                true
            }
            popUp.show()


        }
    }
}


