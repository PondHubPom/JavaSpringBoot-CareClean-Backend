package com.Homie.Home_NotPro.repository;

import com.Homie.Home_NotPro.model.entity.MemberEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends ElasticsearchRepository<MemberEntity, Integer> {
    MemberEntity findByEmail(String email);
    MemberEntity findByName(String name);
    MemberEntity findByTel(String tel);
    MemberEntity findById(String id);
    List<MemberEntity> findByAdmin(boolean admin);
//
//    Optional<MemberEntity> findByUsernameAndBirthday(String username, LocalDate birthday);
}
