package com.torder.search_app.domain.keep.usecase

import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.domain.keep.repository.KeepRepository
import javax.inject.Inject

class InsertHeartUseCase @Inject constructor(
    private val keepRepository: KeepRepository
) {
    operator fun invoke(
        keepModel: KeepModel
    ) {
        keepRepository.insertHeart(keepModel)
    }
}