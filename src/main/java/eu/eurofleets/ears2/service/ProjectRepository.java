package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.program.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
//YS ???  Project findById(Long paramLong);
  
  Project findByProjectId(String paramString);
}
