package com.nuronXbackend.nuronX.service

import com.nuronXbackend.nuronX.model.FriendRequest
import com.nuronXbackend.nuronX.model.RequestStatus
import com.nuronXbackend.nuronX.repository.FriendRequestRepository
import com.nuronXbackend.nuronX.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class FriendRequestServiceImpl(
    private val userRepository: UserRepository,
    private val friendRequestRepository: FriendRequestRepository
) : FriendRequestService {

    override fun sendFriendRequest(senderId: Long, receiverId: Long): String {
        if (senderId == receiverId) {
            return "Cannot send friend request to yourself!"
        }

        if (friendRequestRepository.findBySenderIdAndReceiverId(senderId, receiverId) != null) {
            return "Friend Request Already sent!"
        }
        val sender = userRepository.findById(senderId).orElseThrow {
            Exception("Sender Id not found")
        }

        val receiver = userRepository.findById(receiverId).orElseThrow {
            Exception("Receiver Id not found")
        }

        val friendRequest = FriendRequest(sender = sender, receiver = receiver)
        friendRequestRepository.save(friendRequest)

        return "Friend Request sent..."
    }

    @Transactional
    override fun respondToFriendRequest(requestId: Long, accepted: Boolean): String {
        // Step 1: Find the friend request by its ID
        val request = friendRequestRepository.findById(requestId).orElseThrow {
            Exception("Request Not Found: $requestId") // If not found, throw an exception
        }

        // Step 2: Set the request status based on 'accepted' parameter
        request.status = if (accepted) RequestStatus.ACCEPTED else RequestStatus.REJECTED

        // Step 3: Save the updated request back into the repository
        friendRequestRepository.save(request)

        // Step 4: Return a response message based on the result
        return if (accepted) "Friend request accepted!" else "Friend request rejected!"
    }

    override fun getPendingRequestForUser(userId: Long): List<FriendRequest> {
        return friendRequestRepository.findByReceiverIdAndStatus(userId, RequestStatus.PENDING)
    }
}