/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.beans.oauth;

import com.panthera.exception.OAuth2AuthException;
import java.util.Map;

/**
 *
 * @author user
 */
public class OAuth2UserFactory {

    public static OAuth2UserDetail getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(OAuthProvider.google.toString())) {
            return new GoogleOAuth2User(attributes);
        } else if (registrationId.equalsIgnoreCase(OAuthProvider.facebook.toString())) {
            return new FacebookOAuth2User(attributes);
        } else if (registrationId.equalsIgnoreCase(OAuthProvider.linkedin.toString())) {
            return new LinkedInOAuthUser(attributes);
        } else {
            throw new OAuth2AuthException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
