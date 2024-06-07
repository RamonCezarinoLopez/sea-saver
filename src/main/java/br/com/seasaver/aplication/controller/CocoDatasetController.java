package br.com.seasaver.aplication.controller;
import br.com.seasaver.aplication.model.CocoDataset;
import br.com.seasaver.aplication.service.CocoDatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/datasets")
public class CocoDatasetController {
    @Autowired
    private CocoDatasetService cocoDatasetService;

    @GetMapping
    public List<CocoDataset> getAllDatasets() throws IOException {
        List<String> filePaths = Arrays.asList(
                "src/main/resources/data/_annotations.coco.json",
                "src/main/resources/data/_annotations.coco2.json",
                "src/main/resources/data/_annotations.coco3.json"
        );
        return cocoDatasetService.readDatasets(filePaths);
    }
}