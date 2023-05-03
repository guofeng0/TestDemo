package com.test.testdemo.utils

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat

/**
 * 用于将double类型数据转换为金额数据类型 保留两位小数
 */
object AmountUtil {

    @SuppressLint("NewApi")
    fun stringToAmount(str: String): String {
        val toDouble = str.toDouble()
        val decimalFormat = DecimalFormat("#,##0.00")
        return decimalFormat.format(toDouble)
    }

}