package com.nuronXbackend.nuronX.controller

import com.nuronXbackend.nuronX.service.UserService
import org.springframework.web.bind.annotation.GetMapping
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
}