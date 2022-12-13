package com.example.chi_12_di.data.usecase.impl

import com.example.chi_12_di.domain.repository.IPhotosRepository
import com.example.chi_12_di.domain.usecase.api.IDeleteAllPhotosUseCase
import javax.inject.Inject

class DeleteAllPhotosUseCaseImpl @Inject constructor(private val repository: IPhotosRepository) :
    IDeleteAllPhotosUseCase {
    override fun execute() = repository.deleteAllPhotos()

}