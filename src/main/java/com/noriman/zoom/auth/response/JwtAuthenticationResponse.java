package com.noriman.zoom.auth.response;

/**
 * @program: Jwt-SpringSecurity
 * @description: 响应令牌类
 * @author: Outcaster
 * @create: 2018-07-30 16:47
 **/
public class JwtAuthenticationResponse {

    private static final long serialVersionUID = 1250162333152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

}
