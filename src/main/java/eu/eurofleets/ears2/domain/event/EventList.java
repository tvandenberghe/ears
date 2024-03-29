package eu.eurofleets.ears2.domain.event;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "events")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventList
{
  public EventList() {}
  
  public EventList(List<Event> events) { this.events = events; }
  
  @XmlElement(name = "event")
  private List<Event> events = null;


  
  public List<Event> getCruises() { return this.events; }


  
  public void setEvents(List<Event> events) { this.events = events; }
}
