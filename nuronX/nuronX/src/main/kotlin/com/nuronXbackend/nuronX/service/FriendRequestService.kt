package com.nuronXbackend.nuronX.service

import com.nuronXbackend.nuronX.model.FriendRequest


interface FriendRequestService {

    fun sendFriendRequest(senderId: Long, receiverId: Long) : String
    fun respondToFriendRequest(requestId: Long, accepted: Boolean) : String
    fun getPendingRequestForUser(userId: Long): List<FriendRequest>
}