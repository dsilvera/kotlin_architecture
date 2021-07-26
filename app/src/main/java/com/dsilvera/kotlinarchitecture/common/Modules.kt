package com.dsilvera.kotlinarchitecture.common

import com.dsilvera.kotlinarchitecture.data.api.LocalApi
import com.dsilvera.kotlinarchitecture.data.api.LocalApiImpl
import com.dsilvera.kotlinarchitecture.data.api.RemoteApi
import com.dsilvera.kotlinarchitecture.data.database.createDatabase
import com.dsilvera.kotlinarchitecture.data.database.createProductDao
import com.dsilvera.kotlinarchitecture.data.repository.ProductRepositoryImpl
import com.dsilvera.kotlinarchitecture.data.repository.UserRepositoryImpl
import com.dsilvera.kotlinarchitecture.domain.repository.ProductRepository
import com.dsilvera.kotlinarchitecture.domain.repository.UserRepository
import com.dsilvera.kotlinarchitecture.domain.usecase.ProductUseCase
import com.dsilvera.kotlinarchitecture.domain.usecase.UserUseCase
import com.dsilvera.kotlinarchitecture.presentation.history.viewmodel.HistoryViewModel
import com.dsilvera.kotlinarchitecture.presentation.home.viewmodel.HomeViewModel
import com.dsilvera.kotlinarchitecture.presentation.product.viewmodel.ScanViewModel
import createApiClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModules by lazy {
    listOf(
        viewModelModule,
        useCaseModule,
        repositoryModule,
        dataModule
    )
}

val viewModelModule: Module = module {
    viewModel { ScanViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
}

val useCaseModule: Module = module {
    single { ProductUseCase(productRepository = get(), userRepository = get()) }
    single { UserUseCase(userRepository = get()) }
}

val repositoryModule: Module = module {
    single { ProductRepositoryImpl(remoteApi=get(), productDao=get()) as ProductRepository }
    single { UserRepositoryImpl(localApi= get()) as UserRepository }
}

val dataModule: Module = module {
    single { createApiClient().create(RemoteApi::class.java)}
    single<LocalApi> { LocalApiImpl(appContext = get()) }
    single { createProductDao(database = get()) }
}
