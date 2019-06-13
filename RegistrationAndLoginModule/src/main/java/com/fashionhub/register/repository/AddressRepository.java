package com.fashionhub.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionhub.register.entity.AddressEntity;


@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {

}
