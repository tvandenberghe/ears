package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.event.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Long> {
  Tool findByName(String paramString);
}
