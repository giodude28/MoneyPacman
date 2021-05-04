package io.giodude.moneypacman.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.giodude.moneypacman.Adapter.AdDisAdapter
import io.giodude.moneypacman.Model.AdDisModel
import io.giodude.moneypacman.R
import io.giodude.moneypacman.ViewModel.ViewModels

class AdDisView : Fragment() {

    lateinit var viewModel: ViewModels
    lateinit var rvAdDis: RecyclerView
    var adData = ArrayList<AdDisModel>()
    var rvData = ArrayList<AdDisModel>()
    private var arrayList: ArrayList<AdDisModel>? = null
    var adDisAdapter = context?.let { AdDisAdapter(it, arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.activity_ad_dis_view, container, false)

        rvAdDis = rootview.findViewById(R.id.addisRecyclerview)

        viewModel = ViewModelProvider(this).get(ViewModels::class.java)
        viewModel.adData()
        rvData.clear()
        rvAdDis.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        adDisViewModel()
        return rootview
    }

    fun adDisViewModel(){
        viewModel.adData.observe(this, Observer { addisdata ->
            rvData.clear()
            for (item in addisdata!!){
                rvData.add(item)
                Log.d("Data", rvData.size.toString())
            }

            arrayList = ArrayList()
            arrayList = rvData
            adDisAdapter = context?.let { AdDisAdapter(it, arrayList!!) }!!
            rvAdDis.adapter = adDisAdapter
        })
    }
}