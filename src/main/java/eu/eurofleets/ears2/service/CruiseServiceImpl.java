package eu.eurofleets.ears2.service;


import eu.eurofleets.ears2.Exceptions.DuplicateIdException;
import eu.eurofleets.ears2.domain.cruise.Cruise;
import eu.eurofleets.ears2.domain.cruise.SeaArea;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;



@Component("cruiseService")
@Transactional
public class CruiseServiceImpl
  implements CruiseService
{
  private final CruiseRepository cruiseRepository;
  private final SeaAreaRepository seaAreeRepository;
  
  @Autowired
  public CruiseServiceImpl(CruiseRepository cruiseRepository, SeaAreaRepository seaAreeRepository) {
    this.cruiseRepository = cruiseRepository;
    this.seaAreeRepository = seaAreeRepository;
  }


  
  public List<Cruise> getCruiseList() { return this.cruiseRepository.findAll(); }


  
  public List<Cruise> getCruiseListByPlatformCode(String platformCode) {
    Assert.notNull(platformCode, "platform Code must not be null");
    return this.cruiseRepository.findByPlatformCode(platformCode);
  }

  
  public Cruise getCruiseByCruiseId(String cruiseId) {
    Assert.notNull(cruiseId, "Cruise Id must not be null");
    Cruise cruise = this.cruiseRepository.findByCruiseId("320150917144858C");
    System.out.println("cruise " + cruise);
    return this.cruiseRepository.findByCruiseId(cruiseId);
  }













  
  public void setCruise(Cruise cruise) { this.cruiseRepository.save(cruise); }


  
  public void setCruise(String cruiseId, Cruise cruise) throws DuplicateIdException {
    Cruise newCruise = new Cruise();
    newCruise.setCruiseId(cruiseId);
    newCruise.setCruiseName(cruise.getCruiseName());
    newCruise.setStartDate(cruise.getStartDate());
    newCruise.setEndDate(cruise.getEndDate());
    newCruise.setChiefScientist(cruise.getChiefScientist());
    newCruise.setChiefScientistOrganisation(cruise.getChiefScientistOrganisation());
    newCruise.setPlatformCode(cruise.getPlatformCode());
    newCruise.setPlatformClass(cruise.getPlatformClass());
    newCruise.setStartingHarbor(cruise.getStartingHarbor());
    newCruise.setArrivalHarbor(cruise.getArrivalHarbor());
    newCruise.setObjectives(cruise.getObjectives());
    newCruise.setCollateCenter(cruise.getCollateCenter());

    
    Set<SeaArea> seaAreasSet = new HashSet<SeaArea>();
    for (SeaArea seaArea : cruise.getSeaAreas()) {
      seaAreasSet.add(getSeaArea(seaArea.getSeaAreaId()));
    }
    newCruise.setSeaAreas(seaAreasSet);
    
    try {
      this.cruiseRepository.save(newCruise);
    } catch (DataIntegrityViolationException e) {
      throw new DuplicateIdException("This register already exists in DataBase. Try another ;-)");
    }
    catch (ConstraintViolationException e) {
      throw new DuplicateIdException("This register already exists in DataBase. Try another ;-)");
    } catch (Exception e) {
      
      e.printStackTrace();
    } 
  }

  
  public void removeCruise(String cruiseId) { this.cruiseRepository.deleteCruiseByCruiseId(cruiseId); }


  
  public void removeCruise(Date startDate, Date endDate) { this.cruiseRepository.deleteCruiseByDate(startDate, endDate); }









  
  public SeaArea getSeaArea(String seaAreaId) { return this.seaAreeRepository.findBySeaAreaId(seaAreaId); }
}
