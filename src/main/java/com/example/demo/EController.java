package com.example.demo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("user")
public class EController {

    private final UserService userService;
    private final LikesDislikesService likesDislikesService;

    @Autowired
    public EController(UserService userService, LikesDislikesService likesDislikesService) {
        this.userService = userService;
        this.likesDislikesService = likesDislikesService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/log")
    public String showFormVhod() {
        return "log";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/reg_done")
    public String showRegDonePage(Model model, @RequestParam Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "reg_done";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user, Model model) {
        userService.updateUser(user);
        return "redirect:/reg_done?id=" + user.getId();
    }

    @GetMapping("/profiles")
    public String showEditFormProfiles(@RequestParam Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "profiles";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateData(@RequestBody User updatedUser) {
        if (updatedUser != null) {
            userService.updateUser(updatedUser);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/updateprof")
    public String updateDataProf(@ModelAttribute User user, Model model) {
        userService.updateUser(user);
        return "redirect:/profile?id=" + user.getId();
    }

    @PostMapping("/submit_prof")
    public String updateData(@ModelAttribute User user, Model model) {
        userService.updateUser(user);
        return "redirect:/profiles?id=" + user.getId();
    }

    @GetMapping("/profile")
    public String showResult(@RequestParam Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.getUserByEmailAndPassword(email, password);

            model.addAttribute("user", user);
            return "redirect:/profile?id=" + user.getId();
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/profile_user2")
    public String showUserProfile(@RequestParam Long id, Model model) {
        User match = userService.getUserById(id);
        model.addAttribute("match", match);
        return "profile_user2";
    }

    @GetMapping("/matches")
    public String showMatches(Model model, @ModelAttribute("user") User currentUser) {
        List<User> matches = likesDislikesService.getMatches(currentUser.getId());
        model.addAttribute("matches", matches);
        return "match";
    }

}