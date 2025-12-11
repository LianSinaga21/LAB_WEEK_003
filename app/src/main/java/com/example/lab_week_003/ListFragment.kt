package com.example.lab_week_003

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private val coffeeNames = listOf(
        "Affogato",
        "Americano",
        "Latte",
        "Mocha",
        "Espresso"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val layout = view.findViewById<LinearLayout>(R.id.list_container)

        coffeeNames.forEachIndexed { index, name ->
            val btn = Button(requireContext())
            btn.text = name

            btn.setOnClickListener {
                val detailFragment = DetailFragment.newInstance(index)

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }

            layout.addView(btn)
        }

        return view
    }
}
