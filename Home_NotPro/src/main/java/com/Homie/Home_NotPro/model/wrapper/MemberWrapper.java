package com.Homie.Home_NotPro.model.wrapper;

import com.Homie.Home_NotPro.model.entity.MemberEntity;
import com.Homie.Home_NotPro.services.UtilService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberWrapper implements Cloneable {
    private String name;
    private String tel;
    private String email;
    private String password;
    private String birthday;
    private String sex;
//    private String imei;
    public MemberWrapper() {
    }

    public MemberWrapper(MemberEntity e) {
        this.name = e.getName();
        this.tel = e.getTel();
        this.email = e.getEmail();
        this.password = e.getPassword();
        this.birthday = e.getBirthday().toString();
        this.sex = e.getSex();
    }

    public MemberEntity toEntity() {
        MemberEntity e = new MemberEntity();
        e.setName(this.name);
        e.setTel(this.tel);
        e.setEmail(this.email);
        e.setPassword(this.password);
        e.setBirthday(new UtilService().coverStrToLocaltime(this.birthday));
        e.setSex(this.sex);
        return e;
    }

    @Override
    public MemberWrapper clone() {
        try {
            return (MemberWrapper) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}