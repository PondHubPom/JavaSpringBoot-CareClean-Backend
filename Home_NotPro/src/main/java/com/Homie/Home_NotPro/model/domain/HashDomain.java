package com.Homie.Home_NotPro.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashDomain {
    private String hash;

    public HashDomain(String id) {
        this.hash = id;
    }
}