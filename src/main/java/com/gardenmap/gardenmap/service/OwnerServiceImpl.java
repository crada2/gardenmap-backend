//package com.gardenmap.gardenmap.service;
//
//
//import com.gardenmap.gardenmap.model.Owner;
//import com.gardenmap.gardenmap.repository.OwnerRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service("OwnerService")
//
//public class OwnerServiceImpl implements OwnerService{
//
//    @Autowired
//    private OwnerRepository ownerRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void register (OwnerData garden) throws OwnerAlreadyExistException{
//        if (checkifOwnerExist(garden.getEmail())){
//            throw new OwnerAlreadyExistException("Owner already exists for this email");
//        }
//        Owner owner = new Owner();
//        BeanUtils.copyProperties(garden, owner);
//        encodePassword(owner, garden);
//        ownerRepository.save(owner);
//
//
//    }
//    @Override
//    public boolean checkifOwnerExist(String email){
//        return  ownerRepository.findByEmail(email) !=null ? true : false;
//    }
//    private void encodePassword(Owner owner, OwnerData garden){
//        owner.setPassword(passwordEncoder.encode(garden.getPassword()));
//    }
//}
