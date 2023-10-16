package com.torder.search_app.data.core.retrofit.interceptor

import com.torder.search_app.data.core.retrofit.constant.RetrofitConstant.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val requestBuilder = original.newBuilder()
            .addHeader("Authorization", API_KEY)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}