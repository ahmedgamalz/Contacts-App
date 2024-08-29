package com.example.contactsapp.data

import com.example.contactsapp.R
import com.example.contactsapp.model.Contact

class DataSource {
    fun getContactsData(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(
            Contact(
                "Auntie",
                "+201234567894",
                R.drawable.auntie
            )
        )
        contacts.add(
            Contact(
                "Brother",
                "+201234567888",
                R.drawable.brother
            )
        )
        contacts.add(
            Contact(
                "Daughter",
                "+201234333894",
                R.drawable.daughter
            )
        )
        contacts.add(
            Contact(
                "Friend 1",
                "+201234567777",
                R.drawable.friend_1
            )
        )
        contacts.add(
            Contact(
                "Friend 2",
                "+201234567899",
                R.drawable.friend_2
            )
        )
        contacts.add(
            Contact(
                "Grandfather",
                "+201234566556",
                R.drawable.grandfather
            )
        )
        contacts.add(
            Contact(
                "Granny",
                "+201234567866",
                R.drawable.granny
            )
        )
        contacts.add(
            Contact(
                "Neighbour",
                "+201234588891",
                R.drawable.neigbour
            )
        )
        contacts.add(
            Contact(
                "Sister",
                "+201234567337",
                R.drawable.sister
            )
        )
        contacts.add(
            Contact(
                "Son",
                "+201234564769",
                R.drawable.son
            )
        )
        contacts.add(
            Contact(
                "Uncle",
                "+201234567660",
                R.drawable.uncle
            )
        )
        return contacts
    }

}
