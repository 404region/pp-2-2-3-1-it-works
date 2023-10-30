package pp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp.spring.Service.UserService;
import pp.spring.model.User;

import java.util.List;

@Controller
public class userController {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/users";
    }


    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user-delete")
    public String deleteUser(@RequestParam(value="id", required = false, defaultValue = "0") Long idVar) {
        System.out.println("id" + idVar);
        userService.deleteById(idVar);
        return "redirect:/";
    }

    @RequestMapping(value = "/user-update", method = RequestMethod.GET)
    public String updateUserForm(@RequestParam(value="id", required = false, defaultValue = "0") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
