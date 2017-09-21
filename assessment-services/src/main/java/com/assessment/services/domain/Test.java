package com.assessment.services.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Entity
public class Test{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String schoolCode;
    private String name;
    private String testDescription;
    private String courseId;
    private String classroomList;
    private int totalMarks;
    @JsonFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date scheduledStartDate;
    @JsonFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date scheduledEndDate;
	
    public long getId() {
    	
    	
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getClassroomList() {
		return classroomList;
	}
	public void setClassroomList(String classroomList) {
		this.classroomList = classroomList;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public Date getScheduledStartDate() {
		return scheduledStartDate;
	}
	public void setScheduledStartDate(Date scheduledStartDate) {
		this.scheduledStartDate = scheduledStartDate;
	}
	public Date getScheduledEndDate() {
		return scheduledEndDate;
	}
	public void setScheduledEndDate(Date scheduledEndDate) {
		this.scheduledEndDate = scheduledEndDate;
	}
	
	@Override
	public String toString() {
		return "Test [id=" + id + ", schoolCode=" + schoolCode + ", name=" + name + ", testDescription="
				+ testDescription + ", courseId=" + courseId + ", classroomList=" + classroomList + ", totalMarks="
				+ totalMarks + ", scheduledStartDate=" + scheduledStartDate + ", scheduledEndDate=" + scheduledEndDate
				+ "]";
	}
	
}
