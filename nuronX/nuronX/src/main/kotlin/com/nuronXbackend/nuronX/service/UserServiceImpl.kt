package com.nuronXbackend.nuronX.service

import com.nuronXbackend.nuronX.model.Users
import com.nuronXbackend.nuronX.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getUserSuggestion(name: String): List<String> {
        return userRepository.findUserByPartialMatch(name)
    }

    override fun getAllUsers(): List<Users> {
        return userRepository.findAll()
    }

    override fun getUserById(userId: Long): Users? {
      return userRepository.findById(userId).orElseThrow{
           Exception("User not found!")
       }
    }

    override fun createUser(users: Users) : Users {
       return userRepository.save(users)
    }

    override fun deleteUserById(userId: Long) {
        userRepository.deleteById(userId)
    }
}