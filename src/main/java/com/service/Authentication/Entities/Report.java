package com.service.Authentication.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reports")
public class Report {
    @Id
    @GeneratedValue
    int Id;
    int reporteeId;
    int reportedId;
    String message;

    public Report() {
    }

    public Report(int reporteeId, int reportedId, String message) {
        this.reporteeId = reporteeId;
        this.reportedId = reportedId;
        this.message = message;
    }

    public Report(int id, int reporteeId, int reportedId, String message) {
        Id = id;
        this.reporteeId = reporteeId;
        this.reportedId = reportedId;
        this.message = message;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getReporteeId() {
        return reporteeId;
    }

    public void setReporteeId(int reporteeId) {
        this.reporteeId = reporteeId;
    }

    public int getReportedId() {
        return reportedId;
    }

    public void setReportedId(int reportedId) {
        this.reportedId = reportedId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
