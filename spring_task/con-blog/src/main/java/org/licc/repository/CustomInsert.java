package org.licc.repository;

/**
 * @author licc
 * @date 2021/06/22
 */
public interface CustomInsert<T> {

    /**
     * 保存对象
     * @param t t
     */
    void insert(T t);

}
