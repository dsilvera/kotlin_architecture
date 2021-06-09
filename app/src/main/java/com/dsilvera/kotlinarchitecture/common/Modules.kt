package com.dsilvera.kotlinarchitecture.common

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
}

val useCaseModule: Module = module {
}

val repositoryModule: Module = module {
}

val dataModule: Module = module {
}
