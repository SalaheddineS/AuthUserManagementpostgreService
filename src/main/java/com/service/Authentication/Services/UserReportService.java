package com.service.Authentication.Services;

import com.service.Authentication.Entities.Report;
import com.service.Authentication.Repositories.PostGreRepo;
import com.service.Authentication.Repositories.PostGreReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserReportService implements IUserReportService {
    @Autowired
    private PostGreReportRepo _postGreReportRepo;

    @Override
    public ResponseEntity<String> addReport(Report report) {
        try{
            System.out.println(report.getReportedId());
            System.out.println(report.getReporteeId());
            System.out.println(report.getMessage());
            _postGreReportRepo.save(report);
            return ResponseEntity.ok("Reported successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error adding report");
        }
    }
    @Transactional
    @Override
    public ResponseEntity<String> removeReport(int ReportId) {
        try{
            _postGreReportRepo.deleteById(ReportId);
            return ResponseEntity.ok("Report deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error deleting report");
        }
    }

    @Override
    public List<Report> getAllReports() {
        return _postGreReportRepo.findAll();
    }

    @Override
    public Report getSingleReport(int ReportId) {
        try{
        return _postGreReportRepo.findById(ReportId);}
        catch (Exception e){
            throw new RuntimeException("Error getting report");
        }
    }
}
