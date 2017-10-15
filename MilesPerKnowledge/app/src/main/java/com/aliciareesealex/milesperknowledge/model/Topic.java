package com.aliciareesealex.milesperknowledge.model;

/*
 * Author: Reese, Alex, Alicia
 * Date: 10/13/2017
 * Store and retrieve data
 */

import com.aliciareesealex.milesperknowledge.Contract;

public class Topic implements Contract.MPKModel.TopicModel {
    private String courseID;
    private String name;
    private int time;
    private String subject;

    public Topic() {
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

	@Override
	public void connectToDB() {

	}
}
