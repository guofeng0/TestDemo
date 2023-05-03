package com.test.testdemo.utils

/**
 * 将秒转换为1h1m1s类型
 */
object TimeUtil {

    fun strToTime(string: String): String {
        val toInt = string.toLong()
        val hours = toInt / 60 / 60
        val min = toInt / 60 % 60
        val seconds = toInt % 60

        return when (true) {
            hours > 0 -> "${hours}h${min}m${seconds}s"
            min > 0 -> "${min}m${seconds}s"
            seconds > 0 -> "${seconds}s"
            else -> ""
        }
    }
}