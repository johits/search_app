package com.torder.search_app.domain.keep.usecase

import com.torder.search_app.domain.keep.repository.KeepRepository
import javax.inject.Inject

class DeleteHeartUseCase @Inject constructor(
    private val keepRepository: KeepRepository
) {
    operator fun invoke(
        thumbnailUrl: String
    ) {
        keepRepository.deleteHeart(thumbnailUrl)
    }
}