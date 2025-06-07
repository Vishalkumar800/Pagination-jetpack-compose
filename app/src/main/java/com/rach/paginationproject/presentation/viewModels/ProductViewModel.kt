package com.rach.paginationproject.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.rach.paginationproject.domain.ProductPager


class ProductViewModel(
    productPager: ProductPager = ProductPager()
) : ViewModel() {

    val productListFlow = productPager.getProduct().flow.cachedIn(viewModelScope)


}