package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@SessionAttributes("user")
public class ProfileController {

    private final UserService userService;
    private final LikesDislikesService likesDislikesService;

    @Autowired
    public ProfileController(UserService userService, LikesDislikesService likesDislikesService) {
        this.userService = userService;
        this.likesDislikesService = likesDislikesService;
    }

    @GetMapping("/search")
    public String showSearchPage(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/log";
        }

        List<User> potentialMatches = userService.findPotentialMatches(currentUser);
        if (!potentialMatches.isEmpty()) {
            model.addAttribute("profile", potentialMatches.get(0));  // Only the first profile
        } else {
            model.addAttribute("profile", null);
        }
        return "search";
    }

    @PostMapping("/like")
    public String likeProfile(HttpSession session, @RequestParam Long likedId) {
        User currentUser = (User) session.getAttribute("user");
        likesDislikesService.likeProfile(currentUser.getId(), likedId);

        if (likesDislikesService.isMatch(currentUser.getId(), likedId)) {
            session.setAttribute("match", true);
        }

        return "redirect:/search";
    }

    @PostMapping("/dislike")
    public String dislikeProfile(HttpSession session, @RequestParam Long dislikedId) {
        User currentUser = (User) session.getAttribute("user");
        likesDislikesService.dislikeProfile(currentUser.getId(), dislikedId);

        return "redirect:/search";
    }

}
