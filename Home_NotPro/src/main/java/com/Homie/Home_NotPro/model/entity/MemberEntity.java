package com.Homie.Home_NotPro.model.entity;

//import com.Homie.Home_NotPro.model.wrapper.EditPersonalWrapper;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "member")
@Getter
@Setter
public class MemberEntity {
    @Id
    @ReadOnlyProperty

    @Field(type = FieldType.Text, name = "id")
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Text, name = "tel")
    private String tel;

    @Field(type = FieldType.Text, name = "email")
    private String email;

    @Field(type = FieldType.Text, name = "password")
    private String password;

    @Field(type = FieldType.Date,
            format = DateFormat.date_optional_time,
            name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate birthday;

    @Field(type = FieldType.Boolean, name = "admin")
    private boolean admin;

    @Field(type = FieldType.Text, name = "sex")
    private String sex;

    @Field(type = FieldType.Boolean,name = "isActive")
    private boolean isActive;


}
