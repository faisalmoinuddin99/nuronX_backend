package com.nuronXbackend.nuronX.repository

import com.nuronXbackend.nuronX.model.FriendRequest
import com.nuronXbackend.nuronX.model.RequestStatus
import org.springframework.data.jpa.repository.JpaRepository

interface FriendRequestRepository : JpaRepository<FriendRequest,Long> {

    fun findByReceiverIdAndStatus(receiverId: Long, status: RequestStatus) : List<FriendRequest>
    fun findBySenderIdAndReceiverId(senderId: Long, receiverId: Long) : FriendRequest?

}