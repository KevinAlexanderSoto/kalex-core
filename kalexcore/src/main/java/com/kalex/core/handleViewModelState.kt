package com.kalex.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * This function is to handle the viewModel state when we are not into a compose scope
 * **/
fun <T> handleViewModelState(
    collectAsState: StateFlow<ViewModelState<T>>,
    scope: CoroutineScope,
    onLoading: () -> Unit,
    onSuccess: (T) -> Unit,
    onEmpty: () -> Unit,
    onError: () -> Unit,
) {
    scope.launch {
        collectAsState.collectLatest {
            when (it) {
                is ViewModelState.Error -> onError()
                is ViewModelState.Loading -> onLoading()
                is ViewModelState.Success -> {
                    onSuccess(it.data)
                }

                is ViewModelState.Empty -> onEmpty()
                else -> {
                    onError()
                }
            }
        }
    }
}
