package com.yao.web;

import com.yao.domain.Book;
import com.yao.domain.BookRepository;
import com.yao.exception.BookNotFoundException;
import com.yao.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Jack Yao on 2021/6/11 9:53 上午
 */
@Controller
@RequestMapping("/books")
public class BookController {

    /*定義日誌，選slf4j這包*/
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public String getbook(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }

    /*統一定義錯誤頁面，*/
    /*({BookNotFoundException.class, SQLException.class})括號可以處理指定的異常*/

//    @ExceptionHandler({Exception.class})/*這邊括號處理所有異常*/
//    public ModelAndView handelException(HttpServletRequest request,Exception e) throws Exception {
//        /*記錄日誌*/
//        logger.error("Request URL : {} , Exception : {}", request.getRequestURL(), e.getMessage());
//        /*如果遇到指定的就拋出錯誤，下面就不處理，就會拋給springboot框架，
//        * 這樣就會由BookNotFoundException處理404*/
//        if (AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class) != null){
//            throw e;
//        }
//
//        /*建利視圖，反饋內容*/
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("url", request.getRequestURL());/*請求路徑*/
//        mav.addObject("exception", e);/*異常*/
//        mav.setViewName("error/error");/*設置視圖返回頁面*/
//        /*跳轉到錯誤頁面*/
//        return mav;
//    }

}

