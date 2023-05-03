package com.test.testdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.testdemo.adaper.ResultAdapter
import com.test.testdemo.databinding.FragmentSecondBinding
import com.test.testdemo.viewModel.ResultViewModel

/**
 * SecondFragment
 * 用于展示金额与时间相乘的结果
 */
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<ResultViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.rvResult.adapter = viewModel.getData()?.let { ResultAdapter(it) }
        binding.rvResult.layoutManager = LinearLayoutManager(context)
    }

}