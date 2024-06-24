package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesDislikesRepository extends JpaRepository<LikesDislikes, Long> {
    boolean existsByLikerIdAndLikedIdAndLiked(Long likerId, Long likedId, boolean liked);
    @Query("SELECT ld.likedId FROM LikesDislikes ld WHERE ld.likerId = :userId AND ld.liked = true " +
            "AND ld.likedId IN (SELECT ld2.likerId FROM LikesDislikes ld2 WHERE ld2.likedId = :userId AND ld2.liked = true)")
    List<Long> findMatchesByUserId(Long userId);
}

