package com.nuronXbackend.nuronX.model

import jakarta.persistence.*

@Entity
@Table(name = "tbl_users")
data class Users(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false, length = 20)
    val name: String,

    @Column(nullable = false)
    val email: String,

)



