package com.torder.search_app.presentation.keep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.domain.keep.usecase.DeleteHeartUseCase
import com.torder.search_app.domain.keep.usecase.GetKeepListUseCase
import com.torder.search_app.domain.keep.usecase.InsertHeartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KeepFragmentViewModel @Inject constructor(
    private val getKeepListUseCase: GetKeepListUseCase,
    private val deleteHeartUseCase: DeleteHeartUseCase,
    private val insertHeartUseCase: InsertHeartUseCase
) : ViewModel() {

    private val _keepList = MutableSharedFlow<List<KeepModel>>(replay = 1)
    val keepList = _keepList.asSharedFlow()

    init {
        viewModelScope.launch {
            getKeepListUseCase().collect {
                _keepList.emit(it)
            }
        }
    }

    fun insertHeart(keepModel: KeepModel) {
        insertHeartUseCase(keepModel)
    }

    fun deleteHeart(thumbnailUrl: String) {
        deleteHeartUseCase(thumbnailUrl)
    }
}