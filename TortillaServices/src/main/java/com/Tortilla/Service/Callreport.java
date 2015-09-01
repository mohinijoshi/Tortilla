package com.tortilla.Service;

/**
 * Created with IntelliJ IDEA.
 * User: uttam
 * Date: 9/1/15
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CallReport {
    String id;
    String call_report_type;
    String call_reports;
    String city;
    String country;
    String date;
    String email;
    String first_name;
    String last_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCall_report_type() {
        return call_report_type;
    }

    public void setCall_report_type(String call_report_type) {
        this.call_report_type = call_report_type;
    }

    public String getCall_reports() {
        return call_reports;
    }

    public void setCall_reports(String call_reports) {
        this.call_reports = call_reports;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Callreport [id=" + id + ",call_report_type=" + call_report_type + ",call_reports=" + call_reports + ",city=" + city + ",country=" + country + ",date=" + date + ",email=" + email + ",first_name=" + first_name + ",last_name="+ last_name +"]";
    }
}
