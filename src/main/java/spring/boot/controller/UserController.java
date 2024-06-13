package spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.boot.model.User;
import spring.boot.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getUsers(ModelMap model) {
        model.addAttribute("list", userService.getUsers());

        return "usersList";
    }

    @GetMapping(value = "/add")
    public String addNewUser() {
        return "add";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);

        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String addNewUsers(@RequestParam(value = "id") Long id) {
        userService.deleteUserById(id);

        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String addEditUsers(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        modelMap.addAttribute(userService.findUserById(id));

        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/";
    }
}
