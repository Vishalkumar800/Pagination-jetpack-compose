package com.rach.paginationproject.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rach.paginationproject.model.Product

class ProductPager {

    fun getProduct():Pager<Int,Product>{
        return Pager(PagingConfig(pageSize = 10)){
            PagingSource()
        }
    }

}