package com.programmsoft.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.programmsoft.models.ContentDataItem
import com.programmsoft.repository.Repository
import com.programmsoft.utils.Functions
import retrofit2.HttpException

class ContentPagingSource(private val repository: Repository) :
    PagingSource<Int, ContentDataItem>() {
    override fun getRefreshKey(state: PagingState<Int, ContentDataItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ContentDataItem> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getContentList(currentPage)
            val data = response.body()
            val responseData = mutableListOf<ContentDataItem>()
            data!!.data.forEach { d ->
                d.isNew = 1
                responseData.add(d)
                Functions.insertData(d)
            }

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}