package com.ebookfrenzy.contactsproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.contactsproject.Contact
import com.ebookfrenzy.contactsproject.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>


    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults

    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }


    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

    //sort
    fun getSortedContactsA() {
        repository.sortContactsA()

    }

    fun getSortedContactsD() {
        repository.sortContactsD()

    }

    fun getDeleteResult(id: Int) {
        repository.deleteContact(id)
    }


}