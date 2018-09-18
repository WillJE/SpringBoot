package com.example.controller;

import com.example.Emuns.ResultEmun;
import com.example.Exception.MyException;
import com.example.entiy.User;
import com.example.services.UserRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> queryAll(){
       return  userRepository.findAll();
    }

    /**
     * 新增一个用户，并返回新增用户
     * @return
     */
    @PostMapping(value = "/users")
    public User addUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return userRepository.save(user);
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @GetMapping(value = "/users/{id}")
    public User findUserByID(@PathVariable("id") Long id){
        return userRepository.findById(id).get();
    }

    /**
     * 根据id更新用户
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/users/{id}")
    public User updateUserByID(@PathVariable("id") Long id,
                               @RequestParam("name") String name,
                               @RequestParam("age") Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }

    @RequestMapping("/hello")
    public String exception() throws Exception{
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException(ResultEmun.FALI);
    }
}
