package com.example.appbarpro

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbarpro.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentOneBinding
    lateinit var dataList: MutableList<DataList>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        dataList = mutableListOf()
        for(i in 1..30){
            if(i % 2 == 0){
                dataList.add(DataList("홍길동${i}", "${20+i}세", "rlaeo${i}@nate.com", R.drawable.man))
            }else{
                dataList.add(DataList("홍길동${i}", "${20+i}세", "rlaeo${i}@nate.com", R.drawable.man))
            }
        }

        val customRecycleAdapter = CustomRecycleAdapter(dataList)
        binding.recyclerview.adapter = customRecycleAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(mainActivity)
        return binding.root
    }

}