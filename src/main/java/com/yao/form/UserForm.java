package com.yao.form;


import com.yao.domain.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Pattern;

/**
 * Created by Jack Yao on 2021/6/10 10:53 上午
 */

public class UserForm {

    /*這規則是大陸電話*/
    public static final String PHONE_REG = "^09[0-9]{8}$";

    @NotBlank(message = "不能為空")
    private String username;
    @Length(min = 6, message = "密碼至少需要6位")/*最少需要六位*/
    private String password;
    @Pattern(regexp = PHONE_REG, message = "請輸入正確手機號碼")/*正則表達式*/
    private String phone;
    @Email(message = "不符合信箱規則")/*要符合email規則*/
    private String email;
    @NotBlank
    private String confirmPassword;


    public UserForm() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean confirmPassword(){
        if(this.password.equals(this.confirmPassword)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    public User convertToUser(){
        User user = new UserFormConvert().convert(this);
        return user;
    }
    private class UserFormConvert implements FormConvert<UserForm, User>{

        @Override
        public User convert(UserForm userForm) {
            User user = new User();
            BeanUtils.copyProperties(userForm,user);
            return user;
        }
    }
}
