package com.example.chi_12_di.domain.usecase.impl

import com.example.chi_12_di.domain.repository.IPhotosRepository
import com.example.chi_12_di.domain.usecase.api.IDeleteAllPhotosUseCase

class DeleteAllPhotosUseCaseImpl(private val repository: IPhotosRepository) :
    IDeleteAllPhotosUseCase {
    override fun execute() = repository.deleteAllPhotos()

}