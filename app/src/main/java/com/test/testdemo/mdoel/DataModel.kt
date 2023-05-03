package com.test.testdemo.mdoel

/**
 * 数据类 用于存储金额、时间及相乘后的结果
 */
data class DataModel(val amount: Double, val time: Long) {

    var result: Double = amount * time
}