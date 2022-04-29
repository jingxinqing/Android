package com.ebookfrenzy.contactsproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//table name
@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0


    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    //number
    var contactPhone: String? = null

    constructor()

    constructor(name: String, phone: String) {
        this.contactName = name
        this.contactPhone = phone
    }

}