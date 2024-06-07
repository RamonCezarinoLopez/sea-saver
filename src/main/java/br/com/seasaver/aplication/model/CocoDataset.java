package br.com.seasaver.aplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CocoDataset {
    @JsonProperty("images")
    private List<Image> images;

    @JsonProperty("annotations")
    private List<Annotation> annotations;

    @JsonProperty("categories")
    private List<Category> categories;

    @Data
    public static class Image {
        private int id;
        private String file_name;
        private int width;
        private int height;
    }

    @Data
    public static class Annotation {
        private int id;
        private int image_id;
        private int category_id;
        private List<Integer> bbox;
        private double area;
        private List<List<Integer>> segmentation;
    }

    @Data
    public static class Category {
        private int id;
        private String name;
    }
}
