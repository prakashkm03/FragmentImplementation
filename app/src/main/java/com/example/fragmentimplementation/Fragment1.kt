package com.example.fragmentimplementation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_1.view.*


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_1, container, false)

        //fetching passed data from HomeFragment Via MainActivity
        var inputText = arguments?.getString("input_text")
        val cominglist = arguments?.getParcelableArrayList<Model>("array List")
        val comigListFromHomeFragment =
            arguments?.getParcelableArrayList<Model>("arraylist homefragment")

        if (inputText != null) {
            v.coming_text.text = inputText
        }

        if (cominglist != null) {
            v.coming_list.text = cominglist[0].text1 + "  " + cominglist[0].text2
        }

        if (comigListFromHomeFragment != null) {
            v.coming_list_fromHomeFragment.text =
                comigListFromHomeFragment[0].text1 + " and " + comigListFromHomeFragment[0].text2
        }



        return v
    }

}