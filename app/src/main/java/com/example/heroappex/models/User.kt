package com.example.heroappex.models

data class User(val email:String, val password: String){
    companion object{
        val users = listOf(
            User("tronol@gmail.com", "12345"),
            User("android@gmail.com", "12345"),
            User("heroes@gmail.com", "12345")
        )
    }
}