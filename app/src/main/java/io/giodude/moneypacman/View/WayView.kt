package io.giodude.moneypacman.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.giodude.moneypacman.Adapter.WayAdapter
import io.giodude.moneypacman.Model.WayModel
import io.giodude.moneypacman.R
import io.giodude.moneypacman.ViewModel.ViewModels

class WayView : Fragment() {

    lateinit var viewModel: ViewModels
    lateinit var rvWay: RecyclerView
    var wData = ArrayList<WayModel>()
    var rvwData = ArrayList<WayModel>()
    private var arrayList: ArrayList<WayModel>? = null
    var wayAdapter = context?.let { WayAdapter(it, arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.activity_way_view, container, false)

        rvWay = rootview.findViewById(R.id.wayRecyclerview)

        viewModel = ViewModelProvider(this).get(ViewModels::class.java)
        viewModel.wayData()
        wData.clear()
        rvWay.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        wayViewModel()
        return rootview
    }

    fun wayViewModel(){
        viewModel.wayData.observe(this, Observer { waysData ->
            rvwData.clear()
            for (item in waysData!!){
                rvwData.add(item)

            }
            arrayList = ArrayList()
            arrayList = rvwData
            wayAdapter = context?.let { WayAdapter(it, arrayList!!) }!!
            rvWay.adapter = wayAdapter

        })
    }
}