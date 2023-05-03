package com.test.testdemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.testdemo.mdoel.DataModel

/**
 * 存储数据的ViewModel 实现fragment数据共享
 */
class ResultViewModel : ViewModel() {

    private val dataViewModel = MutableLiveData<ArrayList<DataModel>>()

    // 添加一条数据
    fun addData(amount: Double, time: Long) {
        var value = dataViewModel.value
        if (value == null) {
            value = ArrayList()
        }
        value.add(DataModel(amount, time))
        dataViewModel.postValue(value)
    }

    // 获取ViewModel中的数据
    fun getData(): ArrayList<DataModel>? {
        return dataViewModel.value
    }

}