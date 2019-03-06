/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.controller.rest;

import com.panthera.annotation.MethodExecutionTime;
import com.panthera.beans.PasswordChangeBean;
import com.panthera.beans.RegisterUserBean;
import com.panthera.beans.UserInfoBean;
import com.panthera.model.User;
import com.panthera.model.UserInfo;
import com.panthera.service.MailService;
import com.panthera.service.UserService;
import com.panthera.utils.PaginationUtil;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @GetMapping("/login")
    public String isAuthenticated(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterUserBean registerBean) throws Exception {
        if (!checkPasswordLength(registerBean.getPassword())) {
            throw new Exception("Invalid Password");
        }
        User user = userService.registerUser(registerBean, registerBean.getPassword());

        // Send Mail
        //mailService.sendActivationEmail(user);
    }

    @GetMapping("/activate")
    public void activateAccount(@RequestParam(value = "key") String key) throws Exception {
        Optional<User> user = userService.activateRegistration(key);
        if (!user.isPresent()) {
            throw new Exception("No user was found for this activation key");
        }
    }

    @PostMapping(path = "/account/change-password")
    public void changePassword(@RequestBody PasswordChangeBean passwordChangeDto) throws Exception {
        if (!checkPasswordLength(passwordChangeDto.getNewPassword())) {
            throw new Exception("Invalid Password");
        }
        userService.changePassword(passwordChangeDto.getCurrentPassword(), passwordChangeDto.getNewPassword());
    }

    @PostMapping(path = "/account/reset-password/init")
    public void requestPasswordReset(@RequestBody String mail) {
        //Send Reset Password  Mail 

        /*mailService.sendPasswordResetMail(
                userService.requestPasswordReset(mail)
                        .orElseThrow(EmailNotFoundException::new)
        );*/
    }

    @PostMapping(path = "/account/reset-password/finish")
    public void finishPasswordReset(@RequestBody PasswordChangeBean passwordChangeDto) throws Exception {
        if (!checkPasswordLength(passwordChangeDto.getNewPassword())) {
            throw new Exception("Invalid Password");
        }
        Optional<User> user
                = userService.completePasswordReset(passwordChangeDto.getNewPassword(), passwordChangeDto.getKey());

        if (!user.isPresent()) {
            throw new Exception("No user was found for this reset key");
        }
    }

    @MethodExecutionTime
    @GetMapping(path = "/api/getUserDetails", produces = "application/json")
    public ResponseEntity<UserInfo> getAllUserDetails() {
        //throw new RecordNotFoundException("No Record Avilable: ");
        UserInfoBean bean = new UserInfoBean();
        return new ResponseEntity<>(userService.saveUserInfo(new UserInfo()), HttpStatus.OK);
    }

    @PostMapping(path = "/api/addUserDetails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUserDetails(@RequestBody UserInfoBean userDetails) {
        return new ResponseEntity<>(userService.saveUserInfo(new UserInfo()), HttpStatus.OK);
    }

    @GetMapping("/api/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(Pageable pageable) {
        final Page<User> page = userService.getAllUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/getAllUsers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password)
                && password.length() >= 6
                && password.length() <= 100;
    }
}
