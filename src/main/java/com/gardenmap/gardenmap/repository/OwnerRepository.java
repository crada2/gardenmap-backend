package com.gardenmap.gardenmap.repository;

import com.gardenmap.gardenmap.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository <Owner,Integer> {


}
