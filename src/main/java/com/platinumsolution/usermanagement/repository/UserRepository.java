package com.platinumsolution.usermanagement.repository;

import com.platinumsolution.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT gn_Number FROM user u WHERE u.active_Status = 0 AND u.gn_Number", nativeQuery =  true)
    String findUserByStatusNative(Integer activeStatus,Integer number);

    @Modifying
    @Query(value = "UPDATE user u SET u.active_Status = 1 WHERE u.gn_Number = gn_Number",  nativeQuery =  true)
    int updateUserSetStatusForName(Integer activeStatus,Integer number);
}
