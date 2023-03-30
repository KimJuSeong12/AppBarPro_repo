package com.example.appbarpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appbarpro.databinding.ActivityMainBinding
import com.example.appbarpro.databinding.UsertabButtonBinding
import com.example.viewpagertablayoutpro.ThreeFragment
import com.example.viewpagertablayoutpro.TwoFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var customViewpagerAdapter: CustomViewpagerAdapter
    lateinit var tabTitleList: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 리사이클러뷰 (어댑터설정) begin
        customViewpagerAdapter = CustomViewpagerAdapter(this)
        customViewpagerAdapter.addListFragment(OneFragment())
        customViewpagerAdapter.addListFragment(TwoFragment())
        customViewpagerAdapter.addListFragment(ThreeFragment())
        tabTitleList = mutableListOf("car", "home", "air")
        binding.viewpager2.adapter = customViewpagerAdapter

        // tablayout 과 viewpager2 연동
        TabLayoutMediator(binding.tablayout, binding.viewpager2) { tab, position ->
            tab.setCustomView(tabCustomView(position))
        }.attach()
        binding.eftb.setOnClickListener {  }
        Toast.makeText(applicationContext,"확장탭",Toast.LENGTH_SHORT).show()
    }
    fun tabCustomView(position: Int): View {
        val binding = UsertabButtonBinding.inflate(layoutInflater)
        when (position) {
            0 -> binding.ivIcon.setImageResource(R.drawable.car)
            1 -> binding.ivIcon.setImageResource(R.drawable.house)
            2 -> binding.ivIcon.setImageResource(R.drawable.black)
        }
        binding.tvTabName.text = tabTitleList.get(position)
        return binding.root
    }
}