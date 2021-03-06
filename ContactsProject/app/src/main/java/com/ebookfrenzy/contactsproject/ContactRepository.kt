package com.ebookfrenzy.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()

    }


    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    //delete
    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()

        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

    //sort ASC
    fun sortContactsA() {
        coroutineScope.launch(Dispatchers.Main) {

            searchResults.value = asyncSortA().await()
        }
    }

    private suspend fun asyncSortA(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.sortContactsA()
        }



    //sort Desc
    fun sortContactsD() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncSortD().await()
        }
    }


    private suspend fun asyncSortD(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.sortContactsD()
        }

}


