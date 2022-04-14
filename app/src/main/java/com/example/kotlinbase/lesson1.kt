package com.example.kotlinbase

fun main() {
    val user = User(name = "Asya")
    val user2 = user.copy(name = "Petya")
    val user3 = user.copy(name = "Vasya")

    val users = listOf(user,user2,user3)

    for (user in users) {
        println(user)
    }

    for (i in 0..20 step 5 ) {
        println(users[0])
    }

}
