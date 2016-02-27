package com.Tortilla.Service;

/**
 * Created by Mohini on 2/1/2016.
 */
public class JobClass implements java.io.Serializable {

    String company_name;
    String date_posted;
    String skills;
    String job_title;
    long skills_count;

    public long getSkills_Count() {
        return skills_count;
    }

    public void setSkills_Count(long skills_count) {
        this.skills_count = skills_count;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(String date_posted) {
        this.date_posted = date_posted;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }



}
