package id.iruna.roomtester

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.iruna.roomtester.vo.Person

/**
 * Created by aditrioka on 21/02/18.
 */

class PersonAdapter_old(val persons: List<Person>): RecyclerView.Adapter<PersonAdapter_old.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder?, position: Int) {

    }

    class PersonViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}

