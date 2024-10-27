package com.nuronXbackend.nuronX.controller

import com.nuronXbackend.nuronX.model.Users
import com.nuronXbackend.nuronX.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/suggestUsernames")
    fun suggestUsernames(name: String): List<String> {
        return userService.getUserSuggestion(name)
    }

    @GetMapping("/users")
    fun getAllUsers(): List<Users> {
        return userService.getAllUsers()
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Long): Users? {
        return userService.getUserById(id)
    }

    @PostMapping("/user")
    fun createUser(@RequestBody user: Users) : Users {
        return userService.createUser(user)
    }
}