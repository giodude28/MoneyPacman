package io.giodude.moneypacman.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.giodude.moneypacman.Model.WayModel
import io.giodude.moneypacman.R
import kotlinx.android.synthetic.main.details.view.*

class WayAdapter(var  context: Context,val  itemList: ArrayList<WayModel>): RecyclerView.Adapter<WayAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.title)
        val itemType: TextView = itemView.findViewById(R.id.type)
        val itemSee: TextView = itemView.findViewById(R.id.see)
//        val itemEffort: TextView = itemView.findViewById(R.id.effort)
//        val itemLeverage: TextView = itemView.findViewById(R.id.leverage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WayAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: WayAdapter.ItemViewHolder, position: Int) {
        val data = itemList.get(position)
        holder.itemTitle.text = data.subtitle
        holder.itemType.text = data.business_type
//        holder.itemEffort.text = data.effort
//        holder.itemLeverage.text = data.leverage
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