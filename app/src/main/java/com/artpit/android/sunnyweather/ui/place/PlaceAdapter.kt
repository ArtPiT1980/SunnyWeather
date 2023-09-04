package com.artpit.android.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.artpit.android.sunnyweather.R
import com.artpit.android.sunnyweather.logic.model.Place

class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val placeName: TextView = view.findViewById(R.id.placeName)
        val placeId: TextView = view.findViewById(R.id.placeId)
        val admArea1: TextView = view.findViewById(R.id.admArea1)
        val admArea2: TextView = view.findViewById(R.id.admArea2)
        val country: TextView = view.findViewById(R.id.country)
        val lat: TextView = view.findViewById(R.id.lat)
        val lon: TextView = view.findViewById(R.id.lon)
        val timezone: TextView = view.findViewById(R.id.timezone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.place_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeId.text = place.id.toString()
        holder.admArea1.text = place.adminArea
        holder.admArea2.text = place.adminArea2
        holder.country.text = place.country
        holder.lat.text = place.lat.toString()
        holder.lon.text = place.lon.toString()
        holder.timezone.text = place.timezone
    }

    override fun getItemCount() = placeList.size
}