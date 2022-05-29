package com.blog.blogSite.service.authservice;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * validate the request for authentication
 */
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * validate the request authentication details against the provided user name and password
     * @param appUserName
     * @param appPassword
     * @param basicAuthHeaderValue
     * @return
     */
    @Override
    public Boolean validateBasicAuthentication(String appUserName, String appPassword, String basicAuthHeaderValue) {

        if (StringUtils.hasText(basicAuthHeaderValue) && basicAuthHeaderValue.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = basicAuthHeaderValue.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            final String[] values = credentials.split(":", 2);

            if (values.length == 2) {
                String username = values[0];
                String password = values[1];
                if (appUserName.equals(username) && appPassword.equals(password)) {
                    return true;
                }
            }
        }
        return false;

    }

}
