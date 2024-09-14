package com.example.heroappex.models


import android.os.Parcel
import android.os.Parcelable

data class CharacterItem(val id: Int, val name: String, val imagen: String) : Parcelable {
    // Constructor que toma un Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterItem> {
        override fun createFromParcel(parcel: Parcel): CharacterItem {
            return CharacterItem(parcel)
        }

        override fun newArray(size: Int): Array<CharacterItem?> {
            return arrayOfNulls(size)
        }
        // Lista de personajes
        val characters = mutableListOf<CharacterItem>(
            CharacterItem(1, "Black Panther", "https://i.imgur.com/J31TOBs.jpeg"),
            CharacterItem(2, "Hulk", "https://i.imgur.com/oAbCSJF.jpeg"),
            CharacterItem(3, "Thor", "https://i.imgur.com/J0dBT2O.jpeg"),
            CharacterItem(4, "Doctor Strange", "https://i.imgur.com/U5aen3W.jpeg"),
            CharacterItem(5, "Spider-Man", "https://i.imgur.com/aWdfgHg.jpeg"),
            CharacterItem(6, "Wolverine", "https://i.imgur.com/MZKHOLp.jpeg"),
            CharacterItem(7, "Iron Man", "https://i.imgur.com/1qpfY7z.jpeg"),
            CharacterItem(8, "Captain America", "https://i.imgur.com/PlWZaQ2.jpeg"),
            CharacterItem(9, "Star Lord", "https://i.imgur.com/Gzvz1Zf.jpeg"),
            CharacterItem(10, "Groot", "https://i.imgur.com/uzUeHPW.jpeg"),
            CharacterItem(11, "The Flash", "https://i.imgur.com/10e31bK.jpeg"),
            CharacterItem(12, "Batman", "https://i.imgur.com/bwC1lnr.jpeg"),
            CharacterItem(13, "Green Lantern", "https://i.imgur.com/8lnVM5v.jpeg"),
            CharacterItem(14, "Superman", "https://i.imgur.com/SEoOkLX.jpeg"),
            CharacterItem(15, "Cyborg", "https://i.imgur.com/haO3I6m.jpeg"),
            CharacterItem(16, "Aquaman", "https://i.imgur.com/zbwB3IA.jpeg"),
            CharacterItem(17, "Shazam", "https://i.imgur.com/ZpHQqj6.jpeg"),
            CharacterItem(18, "Lex Luthor", "https://i.imgur.com/fHcaZVt.jpeg"),
            CharacterItem(19, "Darkseid", "https://i.imgur.com/OQM59px.jpeg"),
            CharacterItem(20, "Martian Manhunter", "https://i.imgur.com/mnSOKaI.jpeg")
        )
    }
}