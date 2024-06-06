# sea-saver

Descrição Geral
"Sea Saver" é um aplicativo voltado para a conservação dos oceanos e sustentabilidade ambiental, permitindo aos usuários reportar praias poluídas, interagir com ONGs e entidades responsáveis, além de gerenciar e analisar dados de poluição.

Estrutura do Projeto
Pacotes e Classes
#1. controller
ReportController: Controlador REST para gerenciar operações relacionadas a relatórios de poluição. Inclui endpoints para criação, atualização, exclusão e listagem de relatórios.

java
Copiar código
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

    @PutMapping("/{id}")
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
2. model
User: Entidade representando os usuários do aplicativo, com atributos como CPF, nome, e-mail, senha e localização.

java
Copiar código
package br.com.seasaver.aplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String localizacao;

    @OneToMany(mappedBy = "user")
    private List<Report> reports;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
}
Admin: Entidade representando administradores do sistema, com atributos específicos para gerenciamento.

ONG: Entidade representando organizações não governamentais que receberão relatórios de poluição e interagirão com o sistema.

Notification: Entidade representando notificações enviadas para ONGs e outros usuários.

Partnership: Entidade representando parcerias com ONGs para doações e patrocínios.

Report: Entidade representando relatórios de poluição enviados pelos usuários, incluindo título, descrição, localização e imagens.

3. repository
AdminRepository: Interface para operações de persistência relacionadas a administradores.

AdvertisementRepository: Interface para operações de persistência relacionadas a anúncios publicitários.

NotificationRepository: Interface para operações de persistência relacionadas a notificações.

OngRepository: Interface para operações de persistência relacionadas a ONGs.

PartnershipRepository: Interface para operações de persistência relacionadas a parcerias.

ReportRepository: Interface para operações de persistência relacionadas a relatórios de poluição.

UserRepository: Interface para operações de persistência relacionadas a usuários.

java
Copiar código
package br.com.seasaver.aplication.repository;

import br.com.seasaver.aplication.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
4. service
UserService: Serviço responsável pela lógica de negócios relacionada aos usuários.

java
Copiar código
package br.com.seasaver.aplication.service;

import br.com.seasaver.aplication.model.User;
import br.com.seasaver.aplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsurious() {
        return userRepository.findAll();
    }

    public Optional<User> getUsuriousById(Long id) {
        return userRepository.findById(id);
    }

    public User createUsuario(User user) {
        return userRepository.save(user);
    }

    public User updateUsuario(Long id, User usuarioDetails) {
        User usuario = userRepository.findById(id).orElseThrow();
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setNome(usuarioDetails.getNome());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setSenha(usuarioDetails.getSenha());
        usuario.setLocalizacao(usuarioDetails.getLocalizacao());
        return userRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
5. openapi
OpenAPIConfig: Configuração do Swagger para documentação da API.

java
Copiar código
package br.com.seasaver.aplication.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "sea saver"
                ),
                description = "Documentation para o aplicativo da sea-saver",
                title = "sea-saver",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenAPIConfig {
}
Funcionalidades
Monitoramento e Reporte de Poluição Marinha
Captura de Imagens e Localização
Envio de Relatórios
Interação com ONGs e Entidades Responsáveis
Sistema de Notificações
Dashboard para ONGs
Experiência do Usuário
Interface do Usuário Intuitiva
Gestão e Análise de Dados
Armazenamento de Dados
Análise de Dados
Monetização e Sustentabilidade do Aplicativo
Publicidade no Aplicativo
Parcerias com ONGs
Esse README fornece uma visão geral das classes e pacotes presentes no projeto "Sea Saver", além de descrever as principais funcionalidades que o aplicativo oferece.






