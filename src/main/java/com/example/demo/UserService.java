package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LikesDislikesRepository likesDislikesRepository;

    @Autowired
    public UserService(UserRepository userRepository, LikesDislikesRepository likesDislikesRepository) {
        this.userRepository = userRepository;
        this.likesDislikesRepository = likesDislikesRepository;
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public List<User> findPotentialMatches(User currentUser) {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .filter(user -> !user.getId().equals(currentUser.getId()))
                .filter(user -> !likesDislikesRepository.existsByLikerIdAndLikedIdAndLiked(currentUser.getId(), user.getId(), true))
                .filter(user -> !likesDislikesRepository.existsByLikerIdAndLikedIdAndLiked(currentUser.getId(), user.getId(), false))
                .filter(user -> {
                    switch (currentUser.getPreference()) {
                        case "female":
                            return user.getGender().equals("female");
                        case "male":
                            return user.getGender().equals("male");
                        default:
                            return true;
                    }
                })
                .filter(user -> Math.abs(user.getAge() - currentUser.getAge()) <= 10)
                .collect(Collectors.toList());
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
