package com.example.studyproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.studyproject.R
import com.example.studyproject.models.City
import com.google.android.material.snackbar.Snackbar

class CitiesRecyclerAdapter(context: Context, private val cities: List<City>)
    : RecyclerView.Adapter<CitiesRecyclerAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = inflater.inflate(R.layout.city_list_item, parent, false)
        return ViewHolder(view).listen { position, _ ->
            val item = cities[position]
            Toast.makeText(view.context, item.name, Toast.LENGTH_LONG).show()
            Snackbar.make(view, item.name, Snackbar.LENGTH_LONG).show()
        }
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityNameView.text = cities[position].name
    }

    class ViewHolder constructor(view: View): RecyclerView.ViewHolder(view) {
        val cityNameView: TextView = view.findViewById(R.id.item_city_name)

    }

}