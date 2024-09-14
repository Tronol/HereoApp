package com.example.heroappex.models


data class Publisher(val id: Int, val name: String, val image: String){
    companion object{
        val publishers = mutableListOf<Publisher>(
            Publisher(1,"Dc", "https://i.imgur.com/DWRdw7e.jpeg"),
            Publisher(2,"Marvel","https://i.imgur.com/w4jF3St.jpeg")
        )
    }
}
