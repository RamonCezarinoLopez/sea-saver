package br.com.seasaver.aplication.model;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;


import java.time.LocalDateTime;

@Data
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @ManyToOne
    private User user;

    private LocalDateTime timestamp;
}
