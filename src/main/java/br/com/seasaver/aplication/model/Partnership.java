package br.com.seasaver.aplication.model;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
@Entity
public class Partnership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ONG ong;

    @NotBlank
    private String details;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
