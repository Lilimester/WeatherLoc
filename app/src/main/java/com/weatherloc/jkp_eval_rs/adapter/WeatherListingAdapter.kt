package com.weatherloc.jkp_eval_rs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weatherloc.jkp_eval_rs.R
import com.weatherloc.jkp_eval_rs.Utils.Constants
import com.weatherloc.weatherloclib_jkp.open.models.model_for_future.IndividualDayData
import kotlinx.android.synthetic.main.weather_listing_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class WeatherListingAdapter : RecyclerView.Adapter<WeatherListingAdapter.ViewHolder>() {

    private val mList: MutableList<IndividualDayData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_listing_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            val weatherDetail = mList[position]
            val weather = weatherDetail.weather ?: mutableListOf()
            when {
                weather[0].main_weather?.contains(Constants.RAIN) ?: false ->
                    itemView.mImgWeather.setBackgroundResource(R.drawable.weather_rain)
                weather[0].main_weather?.contains(Constants.CLOUD) ?: false ->
                    itemView.mImgWeather.setBackgroundResource(R.drawable.weather_cloud)
                else -> itemView.mImgWeather.setBackgroundResource(R.drawable.weather_sun)
            }

            itemView.mTvWeatherTitle.text = weather[0].main_weather

            val formatter = SimpleDateFormat(Constants.DATE_FORMAT, Locale.ENGLISH)
            val date = formatter.format(Date((weatherDetail.dt ?: 0)*1000L))

            itemView.mTvWeatherLightInfo.text = itemView.context.getString(
                R.string.date,
                date,
            )
            itemView.mTvWeatherDescription.text = weather[0].description
            itemView.mTvCloudiness.text = "Cloudiness: ${weatherDetail.clouds?.all.toString()} %"

        }
    }

    fun setData(list: List<IndividualDayData>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }
}