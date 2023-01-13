package com.example.alqurankuv2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.alqurankuv2.R
import com.example.alqurankuv2.activities.DetailActivity
import com.example.alqurankuv2.model.main.ModelSurah
import kotlinx.android.synthetic.main.list_item_surah.view.*
import java.util.*

class MainAdapter(private val mContext: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val modelSurahList = ArrayList<ModelSurah>()

    fun setAdapter(items: ArrayList<ModelSurah>) {
        modelSurahList.clear()
        modelSurahList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_surah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelSurahList[position]

        holder.tvNumber.text = data.nomor
        holder.tvName.text = data.asma
        holder.tvAyat.text = data.nama
        holder.tvInfo.text = data.type + " - " + data.ayat + " Ayat "

        holder.cvSurah.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DETAIL_SURAH, modelSurahList[position])
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelSurahList.size
    }

    //Class Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvSurah: CardView
        var tvNumber: TextView
        var tvAyat: TextView
        var tvInfo: TextView
        var tvName: TextView

        init {
            cvSurah = itemView.cvSurah
            tvNumber = itemView.tvNumber
            tvAyat = itemView.tvAyat
            tvInfo = itemView.tvInfo
            tvName = itemView.tvName
        }
    }
}