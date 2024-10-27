package com.nuronXbackend.nuronX.model

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table
data class FriendRequest(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    val sender: Users,

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    val receiver: Users,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    var status: RequestStatus = RequestStatus.PENDING

)

enum class RequestStatus {
    PENDING, ACCEPTED, REJECTED
}