package br.com.leonardo.appcore.presentation.utils.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * Extension function on [Long] representing timestamp in milliseconds to format into a Brazilian date string.
 *
 * @param pattern The date format pattern (default `"EEEE (dd/MM/yyyy)"`).
 * @return Formatted date string in Portuguese (Brazil).
 */
fun Long.toBrazilianDateFormat(pattern: String = "EEEE (dd/MM/yyyy)"): String {
    val date = Date(this)
    val formatter =
        SimpleDateFormat(
            pattern,
            Locale("pt", "BR"),
        ).apply {
            timeZone = TimeZone.getTimeZone("GMT")
        }
    return formatter.format(date)
}

/**
 * Extension function on [Long] representing timestamp in milliseconds to format into a date string.
 *
 * @param pattern The date format pattern (default `"dd/MM/yyyy"`).
 * @return Formatted date string in Portuguese (Brazil).
 */
fun Long.toDateFormat(pattern: String = "dd/MM/yyyy"): String {
    val date = Date(this)
    val formatter =
        SimpleDateFormat(
            pattern,
            Locale("pt", "BR"),
        ).apply {
            timeZone = TimeZone.getTimeZone("GMT")
        }
    return formatter.format(date)
}
