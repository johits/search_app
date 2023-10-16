package com.torder.search_app.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter

fun String.toDateFormat(): String {
    return formatDateTime(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun String.toSeconds(): Long {
    return convertDateTimeToSeconds(this)
}

fun formatDateTime(dateTimeString: String): String {
    Timber.w("ttt 날짜: $dateTimeString ")
    val inputFormatter = SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    )
    val outputFormatter = SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss")
    val date = inputFormatter.parse(dateTimeString)
    return outputFormatter.format(date)
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertDateTimeToSeconds(dateTimeString: String): Long {
    val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val instant = Instant.from(inputFormat.parse(dateTimeString))
    return instant.epochSecond
}