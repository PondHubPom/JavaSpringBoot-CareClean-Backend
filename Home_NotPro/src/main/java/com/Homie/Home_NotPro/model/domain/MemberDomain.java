package com.Homie.Home_NotPro.model.domain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;

@EntityScan
@Getter
@Setter
public class MemberDomain {
    private String message;
    private boolean isAdmin;
    private String accessToken = "";
    private String accountId;

}