package com.android.navigation_component_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.android.navigation_component_example.model.User
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: HomeFragmentArgs by navArgs()
        val value = safeArgs.myArg
        tvReceiveValue.text = "Value Receive: " + value.toString()

        btnOpenDetail.setOnClickListener {
            if (edtInputValue.text.toString().isNotEmpty()) {
                val user = User(edtInputValue.text.toString())
                val action = HomeFragmentDirections.actionHomeToDetail(user)
                it.findNavController().navigate(action)
            }
        }
    }
}
