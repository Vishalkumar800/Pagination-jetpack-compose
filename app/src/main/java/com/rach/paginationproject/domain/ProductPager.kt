package com.rach.paginationproject.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rach.paginationproject.data.model.Product
import com.rach.paginationproject.data.paging.PagingSource

class ProductPager {

    fun getProduct(): Pager<Int, Product> {
        return Pager(PagingConfig(pageSize = 10)) {
            PagingSource()
        }
    }

}