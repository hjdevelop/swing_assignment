package com.example.swing_assignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.swing_assignment.data.model.ImageDataModel
import com.example.swing_assignment.data.model.RetrofitDataModel
import com.example.swing_assignment.data.repository.ImageRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ImageViewModel(private val imageRepository : ImageRepositoryImpl) : ViewModel() {
    private val _imageList = MutableStateFlow<PagingData<RetrofitDataModel.Result>>(PagingData.empty())
    val imageList = _imageList.asStateFlow()

    fun getImageList(query : String) {
        viewModelScope.launch {
            imageRepository.getSearchImageData(query)
                .cachedIn(viewModelScope)
                .collectLatest { image ->
                    _imageList.emit(image)
                }
        }
    }
}