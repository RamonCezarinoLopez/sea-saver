package br.com.seasaver.aplication.controller;
import br.com.seasaver.aplication.model.Report;
import br.com.seasaver.aplication.repository.ReportRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Optional<Report> report = reportRepository.findById(id);
        return report.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Report> createReport(@Valid @RequestBody Report report) {
        Report savedReport = reportRepository.save(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReport);
    }

    public ResponseEntity<Report> updateReport(@PathVariable Long id, @Valid @RequestBody Report reportDetails) {
        return reportRepository.findById(id).map(report -> {
            report.setDescription(reportDetails.getDescription());
            report.setImageUrl(reportDetails.getImageUrl());
            report.setLatitude(reportDetails.getLatitude());
            report.setLongitude(reportDetails.getLongitude());
            // Atualize outros campos conforme necessário
            Report updatedReport = reportRepository.save(report);
            return ResponseEntity.ok(updatedReport);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }



