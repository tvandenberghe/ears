package eu.eurofleets.ears2.controller;


import eu.eurofleets.ears2.Exceptions.DuplicateIdException;
import eu.eurofleets.ears2.domain.cruise.Cruise;
import eu.eurofleets.ears2.domain.cruise.CruiseList;
import eu.eurofleets.ears2.domain.cruise.SeaArea;
import eu.eurofleets.ears2.domain.message.Message;
import eu.eurofleets.ears2.service.CruiseService;
import eu.eurofleets.ears2.utilities.DateUtilities;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;







@RestController
public class CruiseController
{
	
	
	
  public static final String DEFAULT_VALUE = "_";
  @Autowired
  private CruiseService cruiseService;
  
  @RequestMapping(method = {RequestMethod.GET}, value = {"getCruise"}, produces = {"application/xml"})
  public CruiseList getCruiseList(@RequestParam(required = false, defaultValue = "_") String platformCode) {
    List<Cruise> res;
    if ("_".equals(platformCode)) {
    	
      
      res = this.cruiseService.getCruiseList();
    } else {
    
      res = this.cruiseService.getCruiseListByPlatformCode(platformCode);
    } 
    return new CruiseList(res);
  }






















  
  @RequestMapping(method = {RequestMethod.GET}, value = {"getCruise"}, params = {"id"}, produces = {"application/xml"})
  public Cruise getCruiseById(@RequestParam(required = true, value = "id") String cruiseId) { return this.cruiseService.getCruiseByCruiseId(cruiseId); }






















  
  @RequestMapping(method = {RequestMethod.GET}, value = {"insertCruise"}, params = {"id", "cruiseName"}, produces = {"application/xml"})
  public Message insertCruise(@RequestParam(required = true) String id, @RequestParam(required = true) String cruiseName, @RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, @RequestParam(required = false) String chiefScientist, @RequestParam(required = false) String csorg, @RequestParam(required = false) String platformCode, @RequestParam(required = false) String platformClass, @RequestParam(required = false) String objectives, @RequestParam(required = false) String collateCenter, @RequestParam(required = false) String startingHarbor, @RequestParam(required = false) String arrivalHarbor, @RequestParam(required = false) String seaAreas) throws ParseException {
    Cruise cruise = new Cruise();
    cruise.setCruiseId(id);
    cruise.setCruiseName(cruiseName);
    if (startDate != null)
      cruise.setStartDate(DateUtilities.parseDate(startDate)); 
    if (endDate != null)
      cruise.setEndDate(DateUtilities.parseDate(endDate)); 
    cruise.setChiefScientist(chiefScientist);
    cruise.setChiefScientistOrganisation(csorg);
    cruise.setPlatformCode(platformCode);
    cruise.setPlatformClass(platformClass);
    cruise.setObjectives(objectives);
    cruise.setCollateCenter(collateCenter);
    cruise.setStartingHarbor(startingHarbor);
    cruise.setArrivalHarbor(arrivalHarbor);
    
    if (seaAreas != null) {
      String[] seaAreasAsArray = seaAreas.split("\\,");
      Set<SeaArea> seaAreasSet = new HashSet<SeaArea>();
      
      for (String str : seaAreasAsArray) {
        SeaArea seaArea = null;
        try {
          seaArea = this.cruiseService.getSeaArea(str);
        } catch (NumberFormatException e) {}
        
        if (seaArea == null) {
          seaArea = new SeaArea(str, "urn:" + str);
        }
        seaAreasSet.add(seaArea);
      } 
      cruise.setSeaAreas(seaAreasSet);
    } 
    
    this.cruiseService.setCruise(cruise);
    
    return new Message(cruise.getCruiseId(), "Cruise inserted");
  }


  
  @RequestMapping(method = {RequestMethod.GET}, value = {"insertCruise"}, params = {"newId", "originId"}, produces = {"application/xml"})
  public Message insertCruiseByModifyingId(@RequestParam(required = true) String newId, @RequestParam(required = true) String originId) {
    Cruise cruise = this.cruiseService.getCruiseByCruiseId(originId);
    Message res = new Message("-1", "Cruise not inserted");
    if (cruise == null) {
      res = new Message("-1", "Cruise " + originId + " does not exist");
    } else {
      try {
        this.cruiseService.setCruise(newId, cruise);
        res = new Message(newId, "Cruise inserted Succesfully");
      } catch (DuplicateIdException e) {
        res = new Message("-1", "Cruise " + newId + " exists in the DataBase");
      
      }
      catch (Exception e) {
        res = new Message("-1", "Cruise " + newId + " Some errores occurred coping the Cruise. The Cruise has not been copied to DDBB ");
      } 
    } 
    
    return res;
  }














  
  @RequestMapping(method = {RequestMethod.GET}, value = {"modifyCruise"}, params = {"id"}, produces = {"application/xml"})
  public Message modifyCruise(@RequestParam(required = true) String id, @RequestParam(required = false) String cruiseName, @RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, @RequestParam(required = false) String chiefScientist, @RequestParam(required = false) String csorg, @RequestParam(required = false) String platformCode, @RequestParam(required = false) String platformClass, @RequestParam(required = false) String objectives, @RequestParam(required = false) String collateCenter, @RequestParam(required = false) String startingHarbor, @RequestParam(required = false) String arrivalHarbor, @RequestParam(required = false) String seaAreas) throws ParseException {
    Cruise cruise = this.cruiseService.getCruiseByCruiseId(id);
    if (cruiseName != null)
      cruise.setCruiseName(cruiseName); 
    if (startDate != null)
      cruise.setStartDate(DateUtilities.parseDate(startDate)); 
    if (endDate != null)
      cruise.setEndDate(DateUtilities.parseDate(endDate)); 
    if (chiefScientist != null)
      cruise.setChiefScientist(chiefScientist); 
    if (csorg != null)
      cruise.setChiefScientistOrganisation(csorg); 
    if (platformCode != null)
      cruise.setPlatformCode(platformCode); 
    if (platformClass != null)
      cruise.setPlatformClass(platformClass); 
    if (objectives != null)
      cruise.setObjectives(objectives); 
    if (collateCenter != null)
      cruise.setCollateCenter(collateCenter); 
    if (startingHarbor != null)
      cruise.setStartingHarbor(startingHarbor); 
    if (arrivalHarbor != null) {
      cruise.setArrivalHarbor(arrivalHarbor);
    }
    if (seaAreas != null) {
      String[] seaAreasAsArray = seaAreas.split("\\,");
      Set<SeaArea> seaAreasSet = new HashSet<SeaArea>();
      
      for (String str : seaAreasAsArray) {
        SeaArea seaArea = null;
        try {
          seaArea = this.cruiseService.getSeaArea(str);
        } catch (NumberFormatException e) {}
        
        if (seaArea == null) {
          seaArea = new SeaArea(str, "urn:" + str);
        }
        seaAreasSet.add(seaArea);
      } 
      cruise.setSeaAreas(seaAreasSet);
    } 
    
    this.cruiseService.setCruise(cruise);
    
    return new Message(cruise.getCruiseId(), "Cruise modified");
  }

  
  @RequestMapping(method = {RequestMethod.GET}, value = {"removeCruise"}, params = {"id"}, produces = {"application/xml"})
  public Message removeCruiseById(@RequestParam(required = true) String id) {
    this.cruiseService.removeCruise(id);
    return new Message("0", "Cruise deleted");
  }



  
  @RequestMapping(method = {RequestMethod.GET}, value = {"removeCruise"}, params = {"startDate", "endDate"}, produces = {"application/xml"})
  public Message removeCruiseByDateRange(@RequestParam(required = true, value = "startDate") String startDate, @RequestParam(required = true, value = "endDate") String endDate) {
    try {
		this.cruiseService.removeCruise(DateUtilities.parseDate(startDate), DateUtilities.parseDate(endDate));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    
    return new Message("0", "Cruises deleted");
  }
}
