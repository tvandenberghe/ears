package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.event.Event;
import eu.eurofleets.ears2.domain.event.Tool;
import java.util.Date;
import java.util.List;

public interface EventService {
  void insertEvent(Event paramEvent);
  
  Event getEvent(Long paramLong);
  
  List<Event> getEvent();
  
  Event getEventById(String paramString);
  
  Event getEventByDate(Date paramDate);
  
  List<Event> getEventBetweenDates(Date paramDate1, Date paramDate2);
  
  void removeEvent(Long paramLong);
  
  void removeEventById(String paramString);
  
  void removeEventsBetweenDates(Date paramDate1, Date paramDate2);
  
  void modifyEvent(Long paramLong, Event paramEvent);
  
  Tool getTool(String paramString);
  
  void insertTool(Tool paramTool);
}
