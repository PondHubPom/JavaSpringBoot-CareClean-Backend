package com.Homie.Home_NotPro.services;

//import com.Homie.Home_NotPro.enums.CategoryLockerId;
//import com.Homie.Home_NotPro.model.domain.PersonalDataDomain;
import com.Homie.Home_NotPro.model.domain.*;
//import com.Homie.Home_NotPro.model.entity.HistoryTransferEntity;
//import com.Homie.Home_NotPro.model.entity.ImeiEntity;
import com.Homie.Home_NotPro.model.entity.MemberEntity;
import com.Homie.Home_NotPro.model.wrapper.*;
//import com.Homie.Home_NotPro.repository.HistoryTransferRepository;
//import com.Homie.Home_NotPro.repository.ImeiRepository;
//import com.Homie.Home_NotPro.repository.MemberRepository;
//import com.Homie.Home_NotPro.repository.StatisticsMenuRepository;
import com.Homie.Home_NotPro.repository.MemberRepository;
import com.Homie.Home_NotPro.security.EmailValidator;
import com.Homie.Home_NotPro.security.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class MembersService {
    @Autowired
    private MemberRepository memberRepository;

    //    @Autowired
//    private MemberRepository memberRepo;
//    @Autowired
//    private StatisticsMenuRepository staticRepo;
//    @Autowired
//    private HistoryTransferRepository historyTransferRepo;
    @Autowired
    private Security security;

    @Autowired
    private UtilService utilService;

//    @Autowired
//    private ImeiRepository imeiRepository;

    //-------- Sign In --------------

    public MemberDomain login(MemberWrapper w) {

        MemberDomain memberDomain = new MemberDomain();

        if (!EmailValidator.isValidEmail(w.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Bad request");
        }

        MemberEntity entity = memberRepository.findByEmail(w.getEmail());
        utilService.checkActive(entity.isActive());

        if (security.comparePasswords(w.getPassword(), entity.getPassword())) {

            Map<String, Object> claims = new HashMap<>();
//            String idLocker = utilService.getIdLocker(entity.getId());
            claims.put("id", entity.getId());
//            claims.put("isStore","ez");
            String token = security.generateToken(claims);

            memberDomain.setAccessToken(token);
            memberDomain.setAccountId(entity.getId());
//            memberDomain.setAccountId(ec);
            memberDomain.setAdmin(entity.isAdmin());

            return memberDomain;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Invalid login credentials.");
        }
    }

    //-------- Sign Up --------------

    public MemberDomain register(MemberWrapper w) {

        String name = w.getName();
        String tel = w.getTel();
        String birthday = w.getBirthday();
        String email = w.getEmail();
        String sex = w.getSex();
        String password = w.getPassword();
//        String imei = w.getImei();

        if (name.isEmpty()
                || tel.isEmpty()
                || tel.length() < 10
                || birthday.isEmpty()
                || name.length() < 6
                || sex.isEmpty()
//                || imei.isEmpty()
                || password.length() < 8
                || !EmailValidator.isValidEmail(email)) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Please provide valid input");
        }

//        MemberEntity entity = new MemberEntity();
//        entity.setName(w.getName());
//        entity.setBirthday(LocalDate.parse(w.getBirthday()));
//        entity.setEmail(w.getEmail());
//        entity.setSex(w.getSex());
//        entity.setPassword(w.getPassword());
//
//        memberRepository.save(entity);
//        System.out.println(entity.getId());


        if (memberRepository.findByEmail(email) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This Email is already taken");
        }

        if (memberRepository.findByName(name) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This Name is already taken");
        }

        if (memberRepository.findByTel(tel) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This Telephone Number is already exist");
        }

//        ImeiEntity imeiEntity = imeiRepository.findByImei(imei);

        MemberEntity entity = w.clone().toEntity();
        entity.setPassword(security.hashPassword(password));

//        if (imeiEntity == null) {
//            entity.setPoint(1000);
//            imeiRepository.save(new ImeiEntity(imei));
//        } else {
//            entity.setPoint(0);
//        }

        entity.setActive(true);
        entity.setAdmin(false);
        memberRepository.save(entity);
//        utilService.saveLocker(CategoryLockerId.Account.getSubId(), entity.getId());
//         Login after register
        return this.login(w);
    }
}