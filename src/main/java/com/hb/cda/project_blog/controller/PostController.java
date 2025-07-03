package com.hb.cda.project_blog.controller;

import com.hb.cda.project_blog.dto.AddPostDTO;
import com.hb.cda.project_blog.entity.Post;
import com.hb.cda.project_blog.entity.User;
import com.hb.cda.project_blog.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/post")
@PreAuthorize("isAuthenticated()")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String addPost(@AuthenticationPrincipal User user ,@Valid AddPostDTO addPostDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("addPostDTO", addPostDTO);
        } else {
            if (addPostDTO.getTitle() != null && !addPostDTO.getTitle().isEmpty()) {
                Post post = new Post();
                post.setUser(user);
                post.setTitle(addPostDTO.getTitle());
                post.setContent(addPostDTO.getContent());
                postRepository.save(post);
                model.addAttribute("addPostDTO", new AddPostDTO());
            } else {
                model.addAttribute("addPostDTO", new AddPostDTO());
            }
        }

        // Charger tous les posts
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "post";
    }
}
