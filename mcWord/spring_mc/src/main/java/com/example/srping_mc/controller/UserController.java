package com.example.srping_mc.controller;

import com.example.srping_mc.entity.User;
import com.example.srping_mc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page , @PathVariable("size") Integer size ){
//       分页
        Pageable pageable = PageRequest.of(page-1,size);
        return userRepository.findAll(pageable);
    }
    @PostMapping("/save")
    //RequestBody 将前端json转成java对象
    public String save(@RequestBody User user){
        User user1 =  userRepository.save(user);

        boolean result =  StringUtils.isEmpty(user1);
        if (!result ){
            return "success";
        }
        else
            return "error";
    }
    @GetMapping("/findById/{id}")
    public User findBuId(@PathVariable("id") Long id ){
        return userRepository.findById(id).get();
    }

    @PutMapping("update")
    public String update(@RequestBody User user){
        User user1 =  userRepository.save(user);
        boolean result =  StringUtils.isEmpty(user1);
        if (!result ){
            return "success";
        }
        else
            return "error";
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
    }


    @PostMapping("loginDetection")
    public boolean loginDetection(@RequestBody User user){

        String userName = user.getUserName();
        User queryUser = userRepository.findByUserName(userName);

        if (!StringUtils.isEmpty(queryUser)){
            if (user.getPassword().equals(queryUser.getPassword())) {
                return true;
            }

        }
        return false;

    }
    

    
    
}