package architecture.tp_restcontroller.Controller;

import architecture.tp_restcontroller.Model.User;
import architecture.tp_restcontroller.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{p}")
    public User getUser(@PathVariable("p") Integer id) {
        User user = userService.getUser(id);
        if (user != null) {
            return user;
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping("/add")
    public String addUtilisateur(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update/{p}")
    public String UpdateUser(@PathVariable("p") int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/supp")
    public ResponseEntity<String> SupprimerUser(@RequestParam Integer id) {
        String message = userService.suppUser(id);
        if (message.contains("succès")) {
            return ResponseEntity.ok(message); // 200 OK if user is deleted
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message); // 404 Not Found if user doesn't exist
        }
    }

}

