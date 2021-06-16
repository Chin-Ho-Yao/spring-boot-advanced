package com.yao.service;

import com.yao.domain.Book;
import com.yao.domain.BookRepository;
import com.yao.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jack Yao on 2021/6/11 9:45 上午
 */
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    /*獲取書單信息*/
    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.findOne(id);
        if (book == null){
            throw new BookNotFoundException("書單信息不存在");
        }
        return bookRepository.findOne(id);
    }
}
