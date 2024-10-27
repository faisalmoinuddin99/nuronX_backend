package com.nuronXbackend.nuronX.service

import com.nuronXbackend.nuronX.model.Users

interface UserService {

    fun getUserSuggestion(name: String): List<String>
    fun getAllUsers(): List<Users>
    fun getUserById(userId: Long): Users?
    fun createUser(users: Users) : Users
    fun deleteUserById(userId: Long)
}