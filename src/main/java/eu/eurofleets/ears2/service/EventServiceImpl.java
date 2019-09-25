package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.event.Event;
import eu.eurofleets.ears2.domain.event.Tool;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;





@Component("eventService")
@Transactional
public class EventServiceImpl
  implements EventService
{
  private final EventRepository eventRepository;
  private final ToolRepository toolRepository;
  
  @Autowired
  public EventServiceImpl(EventRepository eventRepository, ToolRepository toolRepository) {
    this.eventRepository = eventRepository;
    this.toolRepository = toolRepository;
  }

  
  public void insertEvent(Event event) {

	   this.toolRepository.save(event.getTool());
    this.eventRepository.save(event);
 
  }


  public Event getEvent(Long id) { return (Event)this.eventRepository.findById(id).get(); }
  
 //deprecated  public Event getEvent(Long id) { return (Event)this.eventRepository.findOne(id); }



  
  public List<Event> getEvent() { return this.eventRepository.findAll(); }



  
  public Event getEventById(String eventId) { return this.eventRepository.findByEventId(eventId); }



  
  public Event getEventByDate(Date date) { return this.eventRepository.findFirstByTimeStampBeforeOrderByTimeStampDesc(date); }



  
  public List<Event> getEventBetweenDates(Date startDate, Date endDate) { return this.eventRepository.findByTimeStampBetween(startDate, endDate); }



  
  public void removeEvent(Long id) { this.eventRepository.deleteById(id);}//YS deprecated delete(id); }



  
  public void removeEventById(String eventId) { this.eventRepository.deleteByEventId(eventId); }



  
  public void removeEventsBetweenDates(Date startDate, Date endDate) { this.eventRepository.deleteByTimeStampBetween(startDate, endDate); }


  
  public void modifyEvent(Long id, Event event) {
    event.setId(id);
    this.eventRepository.save(event);
  }


  
  public Tool getTool(String name) { return this.toolRepository.findByName(name); }



  
  public void insertTool(Tool tool) { this.toolRepository.save(tool); }
}
