package com.example.kotlinbase.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbase.databinding.FragmentWeatherListRecyclerItemBinding
import com.example.kotlinbase.repository.Weather

class WeatherListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<Weather> = listOf()
) :
    RecyclerView.Adapter<WeatherListAdapter.CityHolder>() {
// setter для data, чтобы список городов можно было устанавливать при каждом нажатии кнопки
// пробую добавить diffUtil, чтобы адаптер понимал, что конкретно перерисовывать
        fun setData(dataNew: List<Weather>) {
        val callback = WeatherDiffCallback(data, dataNew)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)
        this.data = dataNew
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val binding = FragmentWeatherListRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
            //т.к. viewHolder ранее уже было надуто из layout в onCreateViewHolder, то можно получить
            //экз-р binding-а с помощью метода bind(view), передав в аргумент вышеупомянутый view
            FragmentWeatherListRecyclerItemBinding.bind(itemView).apply {
                tvCityName.text = weather.city.name
                root.setOnClickListener {
                    onItemListClickListener.onItemClick(weather)
                }
            }
        }
    }
}