package com.example.jwt.demo.controller;

import com.example.jwt.demo.dto.AppUserDTO;
import com.example.jwt.demo.exception.CustomException;
import com.example.jwt.demo.exception.CustomValidateException;
import com.example.jwt.demo.model.AuthToken;
import com.example.jwt.demo.service.AppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app_user")
@Api(tags = "API")
public class UserController {

    private final AppUserService appUserService;
    private final CustomValidateException customValidateException;
    private String validateError;


    public UserController(AppUserService appUserService, CustomValidateException customValidateException) {
        this.appUserService = appUserService;
        this.customValidateException = customValidateException;
    }

    @PostMapping("/save")
    @ApiOperation(value = "Add new user")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody AppUserDTO appUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            validateError = customValidateException.validationException(bindingResult);
            throw new CustomException(validateError);
        }
        return appUserService.registerUser(appUserDTO);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update user")
    public ResponseEntity<?> updateUser(@Valid @RequestBody AppUserDTO cmsUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            validateError = customValidateException.validationException(bindingResult);
            throw new CustomException(validateError);
        }
        return appUserService.updateUser(cmsUserDTO);
    }

    @DeleteMapping("/delete/{user_id:.+}")
    @ApiOperation(value = "Delete user")
    public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
        return appUserService.removeUser(user_id);
    }

    @GetMapping("/search/{user_id:.+}")
    @ApiOperation(value = "Get user by id")
    public ResponseEntity<?> searchUser(@PathVariable int user_id) {
        return appUserService.searchUser(user_id);
    }

    @PostMapping("/login")
    @ApiOperation(value = "login")
    public ResponseEntity<?> loginUser(@RequestBody AppUserDTO appUserDTO) {
        return appUserService.loginUser(appUserDTO);
    }

    @PostMapping("/getAccessToken")
    @ApiOperation(value = "Get Access Token")
    public ResponseEntity<?> getaccesstoken(@RequestBody AuthToken token) {
        return appUserService.getRefreshToken(token.getRefresh_token());
    }

}
