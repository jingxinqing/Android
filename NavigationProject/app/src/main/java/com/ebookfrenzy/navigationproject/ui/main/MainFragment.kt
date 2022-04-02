package com.ebookfrenzy.navigationproject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ebookfrenzy.navigationproject.R
import com.ebookfrenzy.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        binding.imageView1.tag = "Image 1"
        binding.imageView2.tag = "Image 2"
        binding.imageView3.tag = "Image 3"

        //val resID = resources.getIdentifier("image1", "drawable", requireContext().packageName)


        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  =
                MainFragmentDirections.mainToSecond()

            action.message = binding.imageView1.tag.toString()
            //action.image = resources.getIdentifier("image1", "drawable", requireContext().packageName)

            action.image = R.drawable.image1
            Navigation.findNavController(it).navigate(action)


        }

        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  =
                MainFragmentDirections.mainToSecond()

            action.message = binding.imageView2.tag.toString()
            //action.image = resources.getIdentifier("image1", "drawable", requireContext().packageName)

            action.image = R.drawable.image2
            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  =
                MainFragmentDirections.mainToSecond()

            action.message = binding.imageView3.tag.toString()
            //action.image = resources.getIdentifier("image1", "drawable", requireContext().packageName)

            action.image = R.drawable.image3
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}