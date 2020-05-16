package com.example.appcorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CoronaListAdapter(val context: Context) : androidx.recyclerview.widget.ListAdapter<UiModel, CoronaListAdapter.CoronaViewHolder>(CoronaCountryDiff) {

    inner class CoronaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var img : ImageView
        private lateinit var name: TextView
        private lateinit var cases: TextView
        private lateinit var deaths: TextView
        private lateinit var recoveries: TextView

        init {
            img = itemView.findViewById(R.id.hinhanh)
            name = itemView.findViewById(R.id.name)
            cases = itemView.findViewById(R.id.cases)
            deaths = itemView.findViewById(R.id.death)
            recoveries = itemView.findViewById(R.id.recovered)
        }

        fun bind(coronaCountryUiModel: UiModel) {
            itemView.post {

                Glide.with(context)
                    .load(coronaCountryUiModel.thumbnailUrl)
                    .into(img)

                name.text = coronaCountryUiModel.name
                cases.text = coronaCountryUiModel.cases.toString()
                deaths.text = coronaCountryUiModel.deaths.toString()
                recoveries.text = coronaCountryUiModel.recoveries.toString()
                itemView.setOnClickListener {
                    coronaCountryUiModel.onClick()
                }
            }
        }
    }


    object CoronaCountryDiff : DiffUtil.ItemCallback<UiModel>() {

        override fun areItemsTheSame(
            oldItem: UiModel,
            newItem: UiModel
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: UiModel,
            newItem: UiModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: CoronaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaViewHolder {
        return CoronaViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

}