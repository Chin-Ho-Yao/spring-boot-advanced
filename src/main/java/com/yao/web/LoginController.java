package com.yao.web;

import com.yao.domain.User;
import com.yao.domain.UserRepository;
import com.yao.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jack Yao on 2021/6/10 11:23 上午
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    /*跳轉頁面*/
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("userForm",new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    /*檢查如果不為空就放入*/
    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session){
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null){
            session.setAttribute("user",user);
            return "index";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }


    /*提交註冊*/
    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {
        /*已經有@Valid所以就不用特地用model把資訊丟到前端*/
        /*驗證有錯就返回*/
        if (!userForm.confirmPassword()){
            result.rejectValue("confirmPassword","confirmError", "密碼不一致");
        }
        if (result.hasErrors()){/**/
            return "register";
        }

        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException("測試異常處理(from LoginController)");
    }



}
