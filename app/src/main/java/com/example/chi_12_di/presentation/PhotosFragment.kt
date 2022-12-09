package com.example.chi_12_di.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chi_12_di.app.PhotosApplication.Companion.applicationScope
import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.databinding.FragmentPhotosBinding
import com.example.chi_12_di.di.Injection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: PhotosViewModel by activityViewModels {
        Injection.provideModelFactory()
    }

    companion object {
        fun newInstance() = PhotosFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.buttonGetPhoto.setOnClickListener {
            applicationScope.launch(Dispatchers.IO) {
                viewModel.getNewPhoto().collectLatest { list ->
                    withContext(Dispatchers.Main) {
                        setupRecyclerview(list)
                    }
                }
            }
        }
    }

    private fun setupRecyclerview(list: List<PhotoEntity>) {
        val adapter = PhotosAdapter()
        adapter.setList(list)
        binding.photosList.adapter = adapter
        binding.photosList.run {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager(context).orientation
                )
            )
        }
    }

}