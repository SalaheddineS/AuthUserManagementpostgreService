package com.service.Authentication.Services;

import com.service.Authentication.Entities.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserReportService {
    ResponseEntity<String> addReport(Report report);
    ResponseEntity<String> removeReport(int ReportId);
    List<Report> getAllReports();
    Report getSingleReport(int ReportId);
}
