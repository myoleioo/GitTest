package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/saveuser")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return service.insertUser(user);
    }

    @GetMapping("/showusers")
    public List<UserEntity> showAllUsers(){
        return service.showAllUser();
    }

    @GetMapping("/showbyid/{id}")
    public Optional<UserEntity> showById(@PathVariable("id")String id){
        return service.showByUserId(Integer.parseInt(id));
    }

    @PutMapping("/updateuser")
    public UserEntity updateUser(@RequestBody UserEntity user){
        return service.updateUser(user);
    }

//    @PutMapping("/deleteuser/{id}")
//    public UserEntity deleteUser(@PathVariable("id")String id){
//       Optional<UserEntity> user = service.showByUserId(Integer.parseInt(id));
//       UserEntity obj =null;
//       if (user.isPresent()){
//           obj = user.get();
//           obj.setStatus(true);
//       }
//      return service.updateUser(obj);
//    }

    @PutMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable("id")String id){
        service.deleteUser(Integer.parseInt(id));
    }

    @GetMapping("/findbyemail/{email}")
    public UserEntity findByEmail(@PathVariable("email")String email){
        return service.findByEmail(email);
    }


}
