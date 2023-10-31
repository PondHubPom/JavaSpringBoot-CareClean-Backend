package com.Homie.Home_NotPro.services;

//import com.Homie.Home_NotPro.enums.CategoryLockerId;
//import com.Homie.Home_NotPro.model.entity.HistoryTransferEntity;
//import com.Homie.Home_NotPro.model.entity.LockerIdEntity;
import com.Homie.Home_NotPro.model.entity.MemberEntity;
import com.Homie.Home_NotPro.repository.*;
import com.Homie.Home_NotPro.security.Security;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class UtilService {

//    @Autowired
//    private Security security;
//
//    @Autowired
//    private HistoryTransferRepository historyTransferRepo;
    @Autowired
    private MemberRepository memberRepo;
//    @Autowired
//    private StoreRepository storeRepository;
//    @Autowired
//    private StatisticsMenuRepository statisticsMenuRepository;
//
//    @Autowired
//    private LockerIdRepository idLockerRepo;

    public void checkActive(boolean active) {
        if (!active) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"This Username is already taken");
    }

    public  LocalDate coverStrToLocaltime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(time, formatter);
    }

//    public void transferSaveHistory(List<HistoryTransferEntity> history) {
//        historyTransferRepo.saveAll(history);
//    }

    public int calculateAge(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

//    public void saveLocker(String category,String idRecord) {
//        LockerIdEntity entity = new LockerIdEntity(idRecord);
//        entity.setIdLocker(security.buildIdLocker(category));
//        idLockerRepo.save(entity);
//    }

//    public String getId(String id) {
//        MemberEntity entity = memberRepo.findById(id);
//        if (entity != null) {
//            return entity.getId();
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Found");
//        }
//    }
//
//    public String getId(String id) {
//        MemberEntity entity = memberRepo.findById(id);
//        if (entity != null) {
//            return entity.getId();
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Not Found");
//        }
//    }
}