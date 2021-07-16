package com.itplus.controller;

import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.itplus.model.ChangePasswordDTO;
import com.itplus.Util.EmailUtil;
import com.itplus.Util.MD5Util;
import com.itplus.Util.PasswordUtil;
import com.itplus.entity.User;
import com.itplus.model.UserDTO;
import com.itplus.service.UserService;

@RestController
@RequestMapping(value = "/user",produces = "application/json")
public class RestUserController {
	@Autowired
	UserService userService;
	@Autowired
	ObjectMapper objectMapper;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request) {
		List<UserDTO> user = userService.getAllUser();
		Gson gson = new Gson();
		return gson.toJson(user);
	}
	
	@PostMapping(value = "/login/")
	@ResponseStatus(HttpStatus.OK)
	public String login(@RequestBody User user) throws JsonProcessingException {
		UserDTO userDTO = userService.getUserByEmail(user.getEmail());
		HashMap<String, Object> map = new HashMap<>();
		if (userDTO != null) {
			String password = MD5Util.toMD5(user.getPassword());
			if (!userDTO.getPassword().equals(password)){
				map.put("message", "Password not match");
				map.put("success", false);
			}else {
				map.put("user", userDTO);
				map.put("message", "Login success");
				map.put("success", true);
			}
		}else {
			map.put("message", "User not found");
			map.put("success", false);
		}
		return objectMapper.writeValueAsString(map);
	}

	@PostMapping(value = "/register/")
	@ResponseStatus(HttpStatus.OK)
	public String register(@RequestBody User user) throws JsonProcessingException {
		return objectMapper.writeValueAsString(userService.register(user));
	}
	@PostMapping(value = "/change-password/")
    @ResponseStatus(HttpStatus.OK)
    public String changePassword(@RequestBody ChangePasswordDTO dto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userService.changePassword(dto.getId(), dto.getOldPassword(), dto.getNewPassword()));
    }

    @GetMapping(value = "/forgot-password/")
    @ResponseStatus(HttpStatus.OK)
    public String forgotPassword(@RequestParam String email) throws JsonProcessingException, MessagingException {
        String newPassword = PasswordUtil.generatedRandomPassword();
        UserDTO userDTO = userService.getUserByEmail(email);
        HashMap<String, Object> map = new HashMap<>();
        if (userDTO != null) {
            HashMap<String, Object> updateResult = userService.updatePassword(userDTO.getId(), newPassword);
            if ((boolean) updateResult.get("success")) {
                EmailUtil.sendEmailForgotPassword(email, newPassword);
                map.put("message", "Email send");
                map.put("success", true);
            } else {
                map.put("success", true);
                map.put("message", updateResult.get("message"));
            }
        } else {
            map.put("message", "Don't exists email");
            map.put("success", false);
        }
        return objectMapper.writeValueAsString(map);
    }
}
