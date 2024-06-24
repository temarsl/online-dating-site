package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesDislikesService {

    private final LikesDislikesRepository likesDislikesRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public LikesDislikesService(LikesDislikesRepository likesDislikesRepository) {
        this.likesDislikesRepository = likesDislikesRepository;
    }

    public void likeProfile(Long likerId, Long likedId) {
        LikesDislikes like = new LikesDislikes(likerId, likedId, true);
        likesDislikesRepository.save(like);
    }

    public void dislikeProfile(Long likerId, Long dislikedId) {
        LikesDislikes dislike = new LikesDislikes(likerId, dislikedId, false);
        likesDislikesRepository.save(dislike);
    }

    public boolean isMatch(Long likerId, Long likedId) {
        return likesDislikesRepository.existsByLikerIdAndLikedIdAndLiked(likedId, likerId, true);
    }

    public List<User> getMatches(Long userId) {
        List<Long> matchedUserIds = likesDislikesRepository.findMatchesByUserId(userId);
        return userRepository.findAllById(matchedUserIds);
    }
}
