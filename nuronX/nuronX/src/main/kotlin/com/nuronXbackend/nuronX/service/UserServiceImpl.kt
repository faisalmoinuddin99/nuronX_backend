package com.nuronXbackend.nuronX.service

import com.nuronXbackend.nuronX.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getUserSuggestion(name: String): List<String> {
        return userRepository.findUserByPartialMatch(name)
    }
}