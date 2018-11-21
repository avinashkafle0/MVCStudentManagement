/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.model;

/**
 *
 * @author Avinash Kafle
 */
public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherAddress;
    private Object teacherImage;

    /**
     * @return the teacherId
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId the teacherId to set
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the teacherAddress
     */
    public String getTeacherAddress() {
        return teacherAddress;
    }

    /**
     * @param teacherAddress the teacherAddress to set
     */
    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    /**
     * @return the teacherImage
     */
    public Object getTeacherImage() {
        return teacherImage;
    }

    /**
     * @param teacherImage the teacherImage to set
     */
    public void setTeacherImage(Object teacherImage) {
        this.teacherImage = teacherImage;
    }
    
}
