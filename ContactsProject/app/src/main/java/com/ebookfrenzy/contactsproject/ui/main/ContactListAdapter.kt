package com.ebookfrenzy.contactsproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsproject.Contact
import com.ebookfrenzy.contactsproject.R

class ContactListAdapter(private val contactItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    var listener: onItemClickListener?= null
    interface onItemClickListener {
        fun onClick(str: String)
    }

    fun settingListener(listener: onItemClickListener?){
        this.listener = listener
    }

    //list of contact objects
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.name
        val phone = holder.phone
        val contactID = holder.id
        var deleteButton = holder.deleteButton
        contactList.let {
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].contactPhone
            contactID.text = it!![listPosition].id.toString()
        }

        deleteButton.setOnClickListener(View.OnClickListener {
            var id = contactID.text.toString()
            listener?.onClick(id)
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    //set data
    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView = itemView.findViewById(R.id.contactName)
        var phone: TextView = itemView.findViewById(R.id.contactPhone)
        var deleteButton : ImageView = itemView.findViewById(R.id.AscButton)
        var id: TextView = itemView.findViewById(R.id.id)
    }
    }