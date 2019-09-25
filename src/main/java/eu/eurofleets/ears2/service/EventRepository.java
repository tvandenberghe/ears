package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.event.Event;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EventRepository extends JpaRepository<Event, Long> {
  Event findByEventId(String paramString);
  
  Event findFirstByTimeStampBeforeOrderByTimeStampDesc(Date paramDate);
  
  List<Event> findByTimeStampBetween(Date paramDate1, Date paramDate2);
  
  @Modifying
  @Transactional
  @Query("delete from Event e where e.eventId = ?1")
  void deleteByEventId(String paramString);
  
  @Modifying
  @Transactional
  @Query("delete from Event e where e.timeStamp between ?1 and ?2")
  void deleteByTimeStampBetween(Date paramDate1, Date paramDate2);
}
