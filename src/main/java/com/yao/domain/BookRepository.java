package com.yao.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jack Yao on 2021/6/11 9:40 上午
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
