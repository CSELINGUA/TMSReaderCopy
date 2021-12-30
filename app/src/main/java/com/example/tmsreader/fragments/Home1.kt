package com.example.tmsreader.fragments

import android.content.ContentResolver
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmsreader.models.Model1
import com.example.tmsreader.R
import com.example.tmsreader.activities.MainActivity
import com.example.tmsreader.adapters.Adapter
import com.example.tmsreader.adapters.onPDFItemClickListener
import kotlinx.android.synthetic.main.home1_fragment.*
import com.example.tmsreader.utils.GetPDFS as GetPDFS1


class Home1 : Fragment(), onPDFItemClickListener {


    private var recyclerView: RecyclerView? = null

    //private var linearLayoutManager:LinearLayoutManager? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var arrayList: ArrayList<Model1>? = null
    //private var adapters:Adapter ? = null
    private lateinit  var adapters : Adapter
    private lateinit var getPDFS: GetPDFS1




    private lateinit var viewModel: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.home1_fragment, container, false)

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var contentRes: ContentResolver = activity!!.contentResolver

        getPDFS = com.example.tmsreader.utils.GetPDFS(contentRes)

        my_recycler_view_home.apply{
            layoutManager = LinearLayoutManager(activity)
            adapters = Adapter()
            adapter = adapters
        }
        addDataSet()
        }

    private fun addDataSet(){

        val intent = Intent(activity,GetPDFS1::class.java)
        activity?.startService(intent)

        val data = getPDFS?.loadData()
        adapters.submitList(data)
//            layoutManager= LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
//
//            my_recycler_view_home?.layoutManager = linearLayoutManager
//            //my_recycler_view_home?.setHasFixedSize(true)
//
//
//            //adapters = Adapter()
//            my_recycler_view_home?.adapter = Adapter()
        }









override fun onItemClick(items: Model1, position: Int) {

}


}

