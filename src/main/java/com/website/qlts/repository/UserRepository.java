package com.website.qlts.repository;

import com.website.qlts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.print.resources.serviceui_zh_TW;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM USER WHERE user_name = :userName", nativeQuery = true)
    Optional<User> getByUserName(@Param("userName") String userName);

    @Modifying
    @Query(value = "UPDATE User r SET r.passWord = ?2 WHERE r.userName = ?1")
    void updatePasswordByUsername(String userName, String passWord);
}