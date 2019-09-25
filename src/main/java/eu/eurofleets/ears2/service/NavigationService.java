package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.navigation.Navigation;
import java.util.Date;
import java.util.List;

public interface NavigationService {
  Navigation getPosition(Date paramDate, String paramString);
  
  List<Navigation> getPositions(Date paramDate1, Date paramDate2);
  
  void getBoundayBox(Date paramDate1, Date paramDate2);
}
