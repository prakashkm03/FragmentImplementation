package com.example.fragmentimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.View
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeFragment.Communicator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var fManager = supportFragmentManager

        var tx = fManager.beginTransaction()
        tx.add(R.id.frag, HomeFragment())
        tx.addToBackStack(null)
        tx.commit()

        homebtn.setOnClickListener {
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag, HomeFragment())
            tx.commit()
        }


        btn1.setOnClickListener {
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag, Fragment1())
            tx.commit()
        }

        btn2.setOnClickListener {
            var tx = fManager.beginTransaction()
            tx.replace(R.id.frag, Fragment_2())
            tx.commit()
        }


    }

    override fun passDataCom(editText_input: String, listexample1: ArrayList<Model>) {
//Passing editText Input from HomeFragment to Fragment 1
        val bundle = Bundle()
        bundle.putString("input_text", editText_input)
        //Adding into examplelist
        var examplelist = ArrayList<Model>()
        examplelist.add(Model("Prakash", "Kumar"))
        //Passing examplelist from MainActiivty to Fragment 1
        bundle.putParcelableArrayList("array List", examplelist)
        //Passing listexample1 from HomeFragment to Fragment 1
        bundle.putParcelableArrayList("arraylist homefragment", listexample1)

        val fManager = supportFragmentManager
        var tx = fManager.beginTransaction() //transaction object
        val frag1 = Fragment1()
        frag1.arguments = bundle

        tx.replace(R.id.frag, frag1)
        tx.addToBackStack(null)
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        tx.commit()
    }
}