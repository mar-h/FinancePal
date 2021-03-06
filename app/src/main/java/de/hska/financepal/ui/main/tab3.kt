package de.hska.financepal.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.transition.TransitionManager

import de.hska.financepal.R
import kotlinx.android.synthetic.main.fragment_tab3.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tab3.newInstance] factory method to
 * create an instance of this fragment.
 */
class tab3 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Button Aktien
        imageButtonAktien.setOnClickListener {
            changeVisibility(imageButtonAktien,textViewAktienText);
        }

        //Button Anleihen
        imageButtonAnleihe.setOnClickListener {
            changeVisibility(imageButtonAnleihe,textViewAnleihenText);
        }

        //Button Option
        imageButtonOption.setOnClickListener {
            changeVisibility(imageButtonOption,textViewOptionsscheineText);
        }

        //Button Rohstoffe
        imageButtonRohsstoffe.setOnClickListener {
            changeVisibility(imageButtonRohsstoffe,textViewRohstoffeText);
        }

        //Button Krypto
        imageButtonKrypto.setOnClickListener {
            changeVisibility(imageButtonKrypto,textViewKryptoText);
        }
    }

    private fun changeVisibility(imageButton: ImageButton, textView: TextView){
        TransitionManager.beginDelayedTransition(view?.parent as ViewGroup)

        if(textView.visibility == View.VISIBLE){
            textView.visibility = View.GONE
            imageButton.setImageResource(R.drawable.ic_arrow_down)
        }
        else{
            textView.visibility = View.VISIBLE
            imageButton.setImageResource(R.drawable.ic_arrow_up)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tab3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tab3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
