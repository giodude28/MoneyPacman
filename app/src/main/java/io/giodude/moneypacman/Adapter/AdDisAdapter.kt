package io.giodude.moneypacman.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.giodude.moneypacman.Model.AdDisModel
import io.giodude.moneypacman.R
import kotlinx.android.synthetic.main.details.view.*

class AdDisAdapter(var context: Context,val itemList: ArrayList<AdDisModel>): RecyclerView.Adapter<AdDisAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.title)
        val itemType: TextView = itemView.findViewById(R.id.status)
        val itemDesc: TextView = itemView.findViewById(R.id.desc)
        val itemSee: TextView = itemView.findViewById(R.id.see)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdDisAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.addisitem, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdDisAdapter.ItemViewHolder, position: Int) {
        val data = itemList.get(position)
        holder.itemTitle.text = data.subtitle
        holder.itemType.text = data.status
        holder.itemDesc.text = data.descriptions

        holder.itemSee.setOnClickListener {

            val mDialogView = LayoutInflater.from(context).inflate(R.layout.details, null)

            val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)

            mDialogView.title.text = data.subtitle
            mDialogView.desc.text = data.descriptions

            val mAlertDialog = mBuilder.show()

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}