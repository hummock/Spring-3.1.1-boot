package web.spring311v1.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.spring311v1.model.User;
import web.spring311v1.service.UserService;

@Data
@Controller
public class UserControllerNew {
    private final UserService userService;

    @Autowired
    public UserControllerNew(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/new_user")
    public String newUser() {
        return "new_user";
    }

    @GetMapping("/user")
    public ModelAndView showUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_page");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
