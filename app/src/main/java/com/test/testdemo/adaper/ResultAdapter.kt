package com.test.testdemo.adaper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.testdemo.mdoel.DataModel
import com.test.testdemo.databinding.ItemResultBinding
import com.test.testdemo.utils.AmountUtil

/**
 * 展示数据使用的adapter 用于展示结果
 */
class ResultAdapter(private var resultList: List<DataModel>) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.viewBinding.tvResult.text = AmountUtil.stringToAmount(resultList[position].result.toString())
    }

    class ResultViewHolder(binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {
        val viewBinding = binding
    }

    fun refresh(newList: List<DataModel>) {
        resultList = newList
        notifyDataSetChanged()
    }
}