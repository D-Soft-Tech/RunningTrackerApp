package com.example.runningtrackerapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.FragmentRunBinding
import com.example.runningtrackerapp.ui.viewModel.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentRunBinding? = null
    private val binding get() = _binding!!
    private lateinit var spinner: Spinner
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRunBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // View Initialization
        spinner = binding.spinner
        fab = binding.floatingActionButton

        // Set adapter to the spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.runs_sort,
            android.R.layout.simple_spinner_item
        ).also {
            spinner.adapter = it
        }

        // Set onclick listener on the floating action button
        fab.setOnClickListener {
            val action = RunFragmentDirections.actionRunFragmentToTrackingFragment2()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
