package com.test.testdemo.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.test.testdemo.R
import com.test.testdemo.databinding.FragmentFirstBinding
import com.test.testdemo.utils.AmountUtil
import com.test.testdemo.utils.TimeUtil
import com.test.testdemo.viewModel.ResultViewModel

/**
 * FirstFragment
 * 用于金额与时间的转换
 */
class FirstFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ResultViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    // 初始化界面
    private fun initView() {
        binding.buttonSubmit.setOnClickListener(this)

        // 对金额输入框进行监听
        binding.etAmount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val text = binding.etAmount.text.toString()
                val textAmount = if (text.isNotEmpty()) {
                    AmountUtil.stringToAmount(text)
                } else {
                    ""
                }
                binding.tvAmount.text = textAmount
            }
        })

        // 对时间输入框进行监听
        binding.etTime.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val text = binding.etTime.text.toString()
                val textTime = if (text.isNotEmpty()) {
                    TimeUtil.strToTime(text)
                } else {
                    ""
                }
                binding.tvTime.text = textTime
            }
        })
    }

    // 点击时间
    override fun onClick(view: View?) {
        when (view) {
            binding.buttonSubmit -> {
                //判断时间 金额是否未输入  为输入则不可提交
                if (binding.etAmount.text.toString().isNotEmpty() && binding.etTime.text.toString()
                        .isNotEmpty()
                ) {
                    viewModel.addData(
                        binding.etAmount.text.toString().toDouble(),
                        binding.etTime.text.toString().toLong()
                    )
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                }
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}