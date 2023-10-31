//package com.Homie.Home_NotPro.services;
//
//import com.Homie.Home_NotPro.enums.ExceptionTitleEnum;
//import com.Homie.Home_NotPro.model.domain.UtilDomain;
//import com.Homie.Home_NotPro.model.entity.MemberEntity;
////import com.Homie.Home_NotPro.repository.LockerIdRepository;
//import com.Homie.Home_NotPro.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Optional;
//
//@Service
//public class DeleteService {
////    @Autowired
////    private LockerIdRepository lockerIdRepo;
//
//    @Autowired
//    private MemberRepository memberRepo;
//
////    @Autowired
////    private StoreRepository storeRepo;
//
////    @Autowired
////    private PromotionRepository promotionRepo;
//
//    @Autowired
//    private UtilService utilService;
//
//    public UtilDomain remove(String id) {
//
//        switch (id.substring(0, 1)) {
//            case "1":
//                return removeAccount(utilService.getId(id));
//            case "2":
//                return utilService.getId(id);
////            case "3":
////                return removePromotion(utilService.getIdRecord(idLocker));
//            default:
//                throw new ResponseStatusException(
//                        HttpStatus.BAD_REQUEST,
//                        "unknown user");
//        }
//    }
//
////    private UtilDomain removePromotion(String idRecord) {
////
////        Optional<PromotionEntity> optional = promotionRepo.findById(idRecord);
////        if (optional.isPresent()) {
////            PromotionEntity entity = optional.get();
////            entity.setIsActive(false);
////            promotionRepo.save(entity);
////
////            return new UtilDomain(HttpStatus.OK.value(),"Success");
////        } else {
////            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Promotion Not Found");
////        }
////    }
//
//
//    private UtilDomain removeAccount(String id) {
//
//        Optional<MemberEntity> optional = memberRepo.findById(id);
//        if (optional.isPresent()) {
//            MemberEntity entity = optional.get();
//            entity.setActive(false);
//            memberRepo.save(entity);
//
//            return new UtilDomain(HttpStatus.OK.value(), "Success");
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ExceptionTitleEnum.MEMBER_ERROR.getTitle());
//        }
//    }
//
////    private UtilDomain removeMenu(String idRecord) {
////
////        Optional<StoreMenuEntity> optional = storeRepo.findById(idRecord);
////        if (optional.isPresent()) {
////            StoreMenuEntity entity = optional.get();
////            entity.setActive(false);
////            storeRepo.save(entity);
////
////            return new UtilDomain(HttpStatus.OK.value(), "Success");
////
////        } else {
////            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ExceptionTitleEnum.MEMBER_ERROR.getTitle());
////        }
//    }
//}
