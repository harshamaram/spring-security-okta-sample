package com.mysamples.springsecuritysample;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HelloResource {

	@GetMapping("/hello")
	public String hello() {
		return "resource says hello";
	}

	@GetMapping("/hello-sir")
	public String welcome2User(Principal principal) {
		return principal. getName() + " via security";
	}
	
	@GetMapping("/hello-sirji")
	public String welcome3User(@AuthenticationPrincipal OAuth2User oauth2User) {
		
		Map<String, Object> map = oauth2User.getAttributes();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		
        try {
        	json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		
		return  json + " via OAuth2User";
	}
	

}
