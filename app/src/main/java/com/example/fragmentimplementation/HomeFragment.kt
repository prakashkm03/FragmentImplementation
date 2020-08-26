package com.example.fragmentimplementation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.home_fragment.view.*


class HomeFragment : Fragment()
{

    interface Communicator{
        fun passDataCom(editText_input : String, listexample : ArrayList<Model>)
    }


    lateinit var comm : Communicator
    var listex = ArrayList<Model>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.home_fragment, container, false)

        comm = activity as Communicator

        listex.add(Model("Welcome","Home"))

        v.enter_btn.setOnClickListener {
            comm.passDataCom(v.input_edittext.text.toString(), listex)
        }

        return v
    }


}