/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fu.di.dao;

import com.fu.di.dto.Student;
import com.fu.di.util.Filter;

/**
 *
 * @author WBPC.VN
 */
public class FilterBySE implements Filter<Student> {

    @Override
    public boolean check(Student x) {
       if(x.getMajor().equalsIgnoreCase("SE")){
           return true;
       }
                return false;
    }
    
}
