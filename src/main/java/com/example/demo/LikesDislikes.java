package com.example.demo;

import jakarta.persistence.*;

@Entity
public class LikesDislikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long likerId;
    private Long likedId;
    private boolean liked;

    public LikesDislikes() {}

    public LikesDislikes(Long likerId, Long likedId, boolean liked) {
        this.likerId = likerId;
        this.likedId = likedId;
        this.liked = liked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLikerId() {
        return likerId;
    }

    public void setLikerId(Long likerId) {
        this.likerId = likerId;
    }

    public Long getLikedId() {
        return likedId;
    }

    public void setLikedId(Long likedId) {
        this.likedId = likedId;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
