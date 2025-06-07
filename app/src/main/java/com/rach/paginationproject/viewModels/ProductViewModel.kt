package com.rach.paginationproject.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.rach.paginationproject.pagination.ProductPager


class ProductViewModel(
    productPager: ProductPager = ProductPager()
) : ViewModel() {

    val productListFlow = productPager.getProduct().flow.cachedIn(viewModelScope)


}