package br.com.seasaver.aplication.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String message;

    @ManyToOne
    private User user;

    private Boolean acknowledged;

    private LocalDateTime timestamp;
}
