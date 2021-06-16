package com.yao.form;

/**
 * Created by Jack Yao on 2021/6/10 3:14 下午
 */
/*S代表原對象，Ｔ代表目標對象*/
public interface FormConvert<S,T> {
    T convert(S s);
}
