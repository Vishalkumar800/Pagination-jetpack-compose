package com.rach.paginationproject.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rach.paginationproject.data.model.Product
import com.rach.paginationproject.data.network.fetchAllProducts

class PagingSource:PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
      return try {
          val currentPage = params.key?:0
          val response = fetchAllProducts()

          LoadResult.Page(
              data = response,
              prevKey = if (currentPage == 0) null else currentPage - 10,
              nextKey = if (response.isEmpty()) null else currentPage + 10
          )

      }catch (e:Exception){
          LoadResult.Error(e)
      }
    }
}