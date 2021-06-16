package com.yao.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jack Yao on 2021/6/10 11:20 上午
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
