package com.example.listandadapterweek5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactList: List<Contact>, private val onClick: (Contact) -> Unit) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(contactView: View) : RecyclerView.ViewHolder(contactView) {
         val contactName: TextView = contactView.findViewById(R.id.contactName)
         val contactPhoneNumber: TextView = contactView.findViewById(R.id.contactPhoneNumber)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.contact_item_layout, parent, false)

        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.contactName.text = contact.name
        holder.contactPhoneNumber.text = contact.phoneNumber

        holder.itemView.setOnClickListener{
            onClick(contact)
        }
    }

}