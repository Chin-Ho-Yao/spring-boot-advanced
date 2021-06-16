package com.yao.service;

import com.yao.domain.Book;
import com.yao.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jack Yao on 2021/6/11 9:43 上午
 */

public interface BookService {
    Book getBookById(Long id);
}
