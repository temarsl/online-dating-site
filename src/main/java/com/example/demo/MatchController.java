package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MatchController {

    private final LikesDislikesService likesDislikesService;

    public MatchController(LikesDislikesService likesDislikesService) {
        this.likesDislikesService = likesDislikesService;
    }

}
