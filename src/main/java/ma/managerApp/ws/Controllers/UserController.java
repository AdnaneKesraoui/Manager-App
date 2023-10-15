package ma.managerApp.ws.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.managerApp.ws.Requests.UserRequest;
import ma.managerApp.ws.Responses.UserResponse;
import ma.managerApp.ws.Shared.Dtos.UserDto;

@RestController
@RequestMapping
public class UserController {

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto createUser = userService.createUser(userDto);

        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(createUser, userResponse);
        
        return userResponse;
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
