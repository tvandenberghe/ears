package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.cruise.Cruise;
import eu.eurofleets.ears2.domain.cruise.SeaArea;
import java.util.Date;
import java.util.List;

public interface CruiseService {
  List<Cruise> getCruiseList();
  
  List<Cruise> getCruiseListByPlatformCode(String paramString);
  
  Cruise getCruiseByCruiseId(String paramString);
  
  void setCruise(Cruise paramCruise);
  
  void setCruise(String paramString, Cruise paramCruise);
  
  void removeCruise(String paramString);
  
  void removeCruise(Date paramDate1, Date paramDate2);
  
  SeaArea getSeaArea(String paramString);
}
