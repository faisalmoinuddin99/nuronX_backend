package com.nuronXbackend.nuronX.repository

import com.nuronXbackend.nuronX.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Users, Long> {

    @Query("SELECT u.name FROM Users u WHERE u.name LIKE %:name%")
    fun findUserByPartialMatch(@Param("name") name: String): List<String>
}