package com.example.lab_week_003

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    companion object {
        private const val ARG_COFFEE_ID = "coffee_id"

        fun newInstance(coffeeId: Int): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putInt(ARG_COFFEE_ID, coffeeId)
            fragment.arguments = args
            return fragment
        }
    }

    private val coffeeNames = listOf(
        "Affogato",
        "Americano",
        "Latte",
        "Mocha",
        "Espresso"
    )

    private val coffeeDescs = listOf(
        "Kopi dengan es krim vanilla.",
        "Espresso dicampur air panas.",
        "Kopi susu dengan foam lembut.",
        "Kopi dengan campuran coklat dan susu.",
        "Kopi hitam pekat dengan rasa kuat."
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val title = view.findViewById<TextView>(R.id.detail_title)
        val desc = view.findViewById<TextView>(R.id.detail_desc)
        val backButton = view.findViewById<Button>(R.id.back_button)

        val id = arguments?.getInt(ARG_COFFEE_ID) ?: 0

        title.text = coffeeNames[id]
        desc.text = coffeeDescs[id]

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}
