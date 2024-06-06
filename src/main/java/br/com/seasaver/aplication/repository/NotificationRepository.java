package br.com.seasaver.aplication.repository;
import br.com.seasaver.aplication.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
