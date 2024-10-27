package com.nuronXbackend.nuronX.service

interface UserService {

    fun getUserSuggestion(name: String) : List<String>
}