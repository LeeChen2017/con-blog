package com.licc.controller;


import com.licc.domain.User;
import com.licc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@Controller
@RequestMapping("/default")
public class DefaultController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        User user = new User();
        user.setUsername("张三");
        user.setLastname("zhang");
        user.setFirstname("san");
        userRepository.save(user);
        return "hello world ";
    }

    @GetMapping("/findAll")
    public void findAll(HttpServletRequest request , Pageable pageable){

        Sort sort = Sort.by("firstname").ascending().and(Sort.by("lastname").descending());

        Iterable<User> all = userRepository.findAll(sort);
        Iterator<User> iterator = all.iterator();
        while (iterator.hasNext()) {
            User tempUser = iterator.next();
            System.out.println(tempUser.getFirstname());
        }
    }

    @GetMapping("/findAllBySortOrder")
    public void findAllBySortOrder(){
        Sort.TypedSort<User> typedSort = Sort.sort(User.class);

        typedSort.by(User::getFirstname).ascending().and(typedSort.by(User::getLastname).descending());

        Iterable<User> all = userRepository.findAll(typedSort);

    }

    @GetMapping("/getByPage")
    @ResponseBody
    public Page<User> pageOf(){
        Sort.TypedSort<User> typedSort = Sort.sort(User.class);

        typedSort.by(User::getFirstname).ascending().and(typedSort.by(User::getLastname).descending());
        Pageable pageable = PageRequest.of(0,10 , typedSort );

        Page<User> all = userRepository.findAll(pageable);

        Iterator<User> iterator = all.getContent().iterator();

        while (iterator.hasNext()) {
            User tempUser = iterator.next();
            System.out.println(tempUser.getFirstname());
        }

    return all;
    }

    @GetMapping("/queryBySpec")
    @ResponseBody
    public Page<User> queryBySpec(){


        return null;
    }

}
