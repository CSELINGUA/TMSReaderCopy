package com.example.tmsreader.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tmsreader.models.Model1
import com.example.tmsreader.R
import com.example.tmsreader.activities.ViewerActivity
import kotlinx.android.synthetic.main.pdf_file_holder.view.*
import kotlin.collections.ArrayList

class Adapter: RecyclerView.Adapter<PDFViewHolder>(){

    private lateinit var items: ArrayList<Model1>

    fun submitList(pdfList: ArrayList<Model1>){
        items = pdfList
    }
    override fun onBindViewHolder(holder: PDFViewHolder, position: Int) {
        when(holder){
            is PDFViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PDFViewHolder {
        return PDFViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.pdf_file_holder,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class PDFViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    var pdfName = itemView.pdfname!!
    var pdfDescription = itemView.pdfdescription!!

    fun bind(item: Model1){
        pdfName.text = item.name
        pdfDescription.text = item.size.toString()

        itemView.setOnClickListener{

            val intent = Intent(itemView.context, ViewerActivity::class.java)
            intent.putExtra("uri", item.uri.toString())
            startActivity(itemView.context,intent,null)

        }
    }


}

interface onPDFItemClickListener {
    fun onItemClick(items: Model1, position: Int)
}
