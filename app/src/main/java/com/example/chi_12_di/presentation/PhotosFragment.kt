package com.example.chi_12_di.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chi_12_di.app.PhotosApplication.Companion.applicationScope
import com.example.chi_12_di.data.db.model.PhotoEntity
import com.example.chi_12_di.databinding.FragmentPhotosBinding
import com.example.chi_12_di.di.AppComponent
import com.example.chi_12_di.di.DaggerAppComponent
import com.example.chi_12_di.domain.entities.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private lateinit var component: AppComponent

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: PhotosViewModel by viewModels { viewModelFactory }

    companion object {
        fun newInstance() = PhotosFragment()
    }

    override fun onAttach(context: Context) {
        component = DaggerAppComponent.builder().build()
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(binding) {
            buttonGetPhoto.setOnClickListener {
                applicationScope.launch(Dispatchers.IO) {
                    viewModel.getNewPhoto().collectLatest { list ->
                        withContext(Dispatchers.Main) {
                            val adapter = PhotosAdapter()
                            adapter.setList(list)
                            photosList.adapter = adapter
                            photosList.run {
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
                }
            }
            buttonClearAll.setOnClickListener {
                applicationScope.launch(Dispatchers.IO) {
                    viewModel.deleteAllPhotos()
                }
            }
        }


    }
}