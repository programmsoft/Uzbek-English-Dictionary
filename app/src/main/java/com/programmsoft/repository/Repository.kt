package com.programmsoft.repository

import com.programmsoft.retrofit.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val apiService : ApiService) {

    suspend fun getContentList(page:Int) =apiService.getDataWithPage(page)

}