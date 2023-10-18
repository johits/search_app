package com.torder.search_app.domain.keep.usecase

import com.torder.search_app.domain.keep.model.KeepModel
import com.torder.search_app.domain.keep.repository.KeepRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetKeepListUseCase @Inject constructor(
    private val keepRepository: KeepRepository
) {
    operator fun invoke(
    ): Flow<List<KeepModel>> {
        return keepRepository.getAllHeart()
    }
}