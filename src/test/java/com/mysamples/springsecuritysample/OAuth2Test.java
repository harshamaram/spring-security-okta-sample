package com.mysamples.springsecuritysample;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2Test {

	@Test
	public void contextLoads() {
		
		Map<String, Object> attributes = new HashMap<>();
        attributes.put("sub", "my-id");
        attributes.put("email", "bwatkins@test.org");

        List<GrantedAuthority> authorities = Collections.singletonList(
                new OAuth2UserAuthority("ROLE_USER", attributes));
        OAuth2User user = new DefaultOAuth2User(authorities, attributes, "sub");
        
        
        HelloResource res = new HelloResource();
        String result = res.welcome3User(user);
        
        System.out.println(result);
        
		
	}

}
