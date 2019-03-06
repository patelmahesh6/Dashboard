/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.security;

import com.panthera.beans.oauth.OAuth2UserDetail;
import com.panthera.beans.oauth.OAuth2UserFactory;
import com.panthera.beans.oauth.OUserPrincipal;
import com.panthera.exception.OAuth2AuthException;
import com.panthera.model.User;
import com.panthera.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author user
 */
@Component("oAuth2UserService")
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return checkOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {

            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User checkOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserDetail oAuth2UserDetail = OAuth2UserFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        if (StringUtils.isEmpty(oAuth2UserDetail.getEmail())) {
            throw new OAuth2AuthException("Email not found from OAuth2 provider");
        }

        Optional<User> userOptional = userRepository.findOneWithAuthoritiesByEmail(oAuth2UserDetail.getEmail());
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user = updateExistingUser(user, oAuth2UserDetail);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserDetail);
        }

        return OUserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserDetail oAuth2UserDetail) {
        User user = new User();
        user.setFirstName(oAuth2UserDetail.getName());
        user.setEmail(oAuth2UserDetail.getEmail());
        user.setImageUrl(oAuth2UserDetail.getImageUrl());
        user.setActivated(true);
        return userRepository.save(user);
    }

    private User updateExistingUser(User existingUser, OAuth2UserDetail oAuth2UserDetail) {
        existingUser.setFirstName(oAuth2UserDetail.getName());
        existingUser.setImageUrl(oAuth2UserDetail.getImageUrl());
        return userRepository.save(existingUser);
    }
}
