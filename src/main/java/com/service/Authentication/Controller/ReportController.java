package com.service.Authentication.Controller;

import com.service.Authentication.Entities.Report;
import com.service.Authentication.Services.UserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
public class ReportController {
    @Autowired
    private UserReportService _userReportService;

    @GetMapping("/getAllReports")
    public List<Report> GetReport(){
        return _userReportService.getAllReports();
    }

    @PostMapping("/addReport")
    public ResponseEntity<String> AddReport(@RequestBody Report report){
         return _userReportService.addReport(report);
    }

    @GetMapping("/getReport/{id}")
    public Report GetReportById(@PathVariable int id){
        return _userReportService.getSingleReport(id);
    }

    @DeleteMapping("/deleteReport/{id}")
    public ResponseEntity<String> DeleteReport(@PathVariable int id){
        return _userReportService.removeReport(id);
    }
}
