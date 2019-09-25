package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.program.Program;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "program", path = "program")
public interface ProgramRepository extends JpaRepository<Program, Long> {
  Program findByProgramId(String paramString);
  
  List<Program> findByCruiseId(String paramString);
  
  List<Program> getProgramListByCruiseId(String paramString);
  
  @Modifying
  @Transactional
  @Query("delete from Program p where p.programId = ?1")
  void deleteProgramByProgramId(String paramString);
}
