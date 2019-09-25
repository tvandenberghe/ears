package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.cruise.Cruise;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "cruise", path = "cruise")
public interface CruiseRepository extends JpaRepository<Cruise, Long> {
  Cruise findByCruiseId(String paramString);
  
  List<Cruise> findByPlatformCode(String paramString);
  
  @Modifying
  @Transactional
  @Query("delete from Cruise c where c.cruiseId = ?1")
  void deleteCruiseByCruiseId(String paramString);
  
  @Modifying
  @Transactional
  @Query("delete from Cruise c where c.startDate >= ?1  and c.endDate <= ?2")
  void deleteCruiseByDate(Date paramDate1, Date paramDate2);
}
