package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.navigation.Navigation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component("navigationService")
@Transactional
public class NavigationServiceImpl
  implements NavigationService
{
  private final NavigationRepository navigationRepository;
  
  @Autowired
  public NavigationServiceImpl(NavigationRepository navigationRepository) { this.navigationRepository = navigationRepository; }



  
  public Navigation getPosition(Date date, String cruiseId) { return this.navigationRepository.findByTime(date); }



  
  public List<Navigation> getPositions(Date startDate, Date endDate) { return this.navigationRepository.findByTimeBetween(startDate, endDate); }
  
  public void getBoundayBox(Date startDate, Date endDate) {}
}
