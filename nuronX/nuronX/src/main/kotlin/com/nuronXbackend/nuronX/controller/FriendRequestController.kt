package com.nuronXbackend.nuronX.controller

import com.nuronXbackend.nuronX.model.FriendRequest
import com.nuronXbackend.nuronX.service.FriendRequestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/friend-request")
class FriendRequestController(
    private val friendRequestService: FriendRequestService
) {

    @PostMapping("/send")
    fun sendFriendRequest(
        @RequestParam senderId: Long,
        @RequestParam receiverId: Long
    ): String {
        return friendRequestService.sendFriendRequest(senderId, receiverId)
    }

    @PostMapping("/respond/{id}")
    fun respondToFriendRequest(
        @PathVariable id: Long,
        @RequestParam accepted: Boolean
    ): String {
        return friendRequestService.respondToFriendRequest(id, accepted)
    }

    @GetMapping("/{receiverId}")
    fun getFriendRequests(@PathVariable receiverId: Long) : List<FriendRequest> {
        return friendRequestService.getPendingRequestForUser(receiverId)
    }
}