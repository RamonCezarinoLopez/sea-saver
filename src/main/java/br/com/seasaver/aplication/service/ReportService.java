package br.com.seasaver.aplication.service;
import br.com.seasaver.aplication.model.Report;
import br.com.seasaver.aplication.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;




public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

}

