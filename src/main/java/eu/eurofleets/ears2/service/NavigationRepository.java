package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.navigation.Navigation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NavigationRepository extends JpaRepository<Navigation, Long> {
  Navigation findByTime(Date paramDate);
  
  List<Navigation> findByTimeBetween(Date paramDate1, Date paramDate2);
}
