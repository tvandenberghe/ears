package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.cruise.SeaArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeaAreaRepository extends JpaRepository<SeaArea, Long> {
  //YS ?? SeaArea findById(Long paramLong);
  
  SeaArea findBySeaAreaId(String paramString);
}
