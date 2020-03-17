package com.mrfreitas.weather_app.data.remote

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServiceFactory {

    companion object {
        fun getRetrofit(context: Context, baseUrl: String?): Retrofit {
            val retrofit = Retrofit
                .Builder()
                .client(getHttpClient(context))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
            retrofit.baseUrl(baseUrl ?: HOST)
            return retrofit.build()
        }

        fun getHttpClient(context: Context): OkHttpClient {
            val cacheSize = 1024 * 1024 // 1MB
            return OkHttpClient.Builder()
                .cache(Cache(context.cacheDir, cacheSize.toLong()))
                .addInterceptor(getInterceptor())
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
        }

        fun getInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }
    }
}