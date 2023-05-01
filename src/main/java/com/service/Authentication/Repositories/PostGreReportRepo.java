package com.service.Authentication.Repositories;

import com.service.Authentication.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostGreReportRepo extends JpaRepository<Report, Integer> {
    Report findById(int id);
}
