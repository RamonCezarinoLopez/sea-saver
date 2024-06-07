package br.com.seasaver.aplication.service;
import br.com.seasaver.aplication.model.CocoDataset;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CocoDatasetService {
    public List<CocoDataset> readDatasets(List<String> filePaths) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CocoDataset> datasets = new ArrayList<>();

        for (String path : filePaths) {
            CocoDataset dataset = objectMapper.readValue(new File(path), CocoDataset.class);
            datasets.add(dataset);
        }

        return datasets;
    }
}

