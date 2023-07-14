/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fu.di.util;

/**
 *
 * @author WBPC.VN
 */
//biến datatype thành tham số, truyền tham số dưới dạng theo kiểu lấy datatype mà truyền
//ko phải là truyền 1 value nào đó, kĩ thuật này gọi là GENERIC
//Ví dụ: List<Student> list = new ArrayList();
//list........
@FunctionalInterface // dính dáng đến LAMBDA expression
//LAMBDA interface chỉ chơi với một hàm abstract nhưng ko cấm chơi với
//các hàm có code khác 
public interface Filter<T> {
    
    public boolean check(T x);
    
}
