package com.victorwangzhen.coolapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class UserInfo {

    @Valid
    @JsonProperty("username")
    private String username;


    @Valid
    @JsonProperty("email")
    private String email;


    @Valid
    @JsonProperty("password")
    private String password;


}
