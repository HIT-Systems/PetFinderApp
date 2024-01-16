package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class MainScreenFragment : Fragment() {

    private lateinit var viewModel: MainScreenViewModel
    private lateinit var recyclerView: RecyclerView
    private var page = 1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(MainScreenViewModel::class.java)
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        val loadingBar = view.findViewById<ProgressBar>(R.id.progressBar)
        viewModel.animalsList.value = listOf()
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                loadingBar.visibility = View.VISIBLE
                recyclerView.isLayoutFrozen = true
            } else {
                loadingBar.visibility = View.GONE
                recyclerView.isLayoutFrozen = false
            }
        }
        viewModel.getAnimals(page)
        viewModel.error.observe(viewLifecycleOwner) {
            val builder = AlertDialog.Builder(context)
                .setMessage(it).setPositiveButton("Dismiss") { dialog, _ ->
                    dialog.dismiss()
                }.create()
            builder.show()
        }
        val adapter = MainScreenRecyclerViewAdapter(emptyList())
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.layoutManager = layoutManager
        viewModel.animalsList.observe(viewLifecycleOwner) { animals ->
            adapter.animalsList = animals
            adapter.notifyDataSetChanged()
            adapter.onItemViewClicked = { animal ->
                val bundle = bundleOf("animal" to animal)
                findNavController().navigate(
                    R.id.action_mainScreenFragment_to_animalsDetailsFragment,
                    bundle
                )
            }
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager
                    val lastElement =
                        (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
                    if (lastElement == adapter.itemCount - 1) {
                        viewModel.getAnimals(++page)
                    }
                }
            })
        }
    }
}