package com.ebookfrenzy.contactsproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ebookfrenzy.contactsproject.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactsproject.Contact
import androidx.fragment.app.viewModels
import com.ebookfrenzy.contactsproject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.name.text.toString()
            val phone = binding.phone.text.toString()

            if (name != "" && phone != "") {
                val contact = Contact(name, phone)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                val text = "Please enter a name and phone number"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(context, text, duration).show()
            }
        }

        binding.findButton.setOnClickListener {
            val name = binding.name.text.toString()


            if (name != "") {
                viewModel.findContact(binding.name.text.toString())
                clearFields()
            } else {
                val text = "Please enter a search criteria in the name field"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(context, text, duration).show()
            }
        }

        binding.AscButton.setOnClickListener{ viewModel.getSortedContactsA()}

        binding.DescButton.setOnClickListener{ viewModel.getSortedContactsD()}



    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(this, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    val text = "There are no contact match your search"
                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(context, text, duration).show()
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object:ContactListAdapter.onItemClickListener{
            override fun onClick(id: String){
                val contactId:Int = parseInt(id)
                viewModel.getDeleteResult(contactId)
            }

        })
    }

    private fun clearFields() {
        binding.contactID.text = ""
        binding.name.setText("")
        binding.phone.setText("")
    }
}