package eu.eurofleets.ears2.domain.cruise;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name = "CRUISE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cruise
{
  @Id
 
  
  @Column(name = "ID")
  private Long id;
  @XmlAttribute(name = "id")
  @Column(unique = true, nullable = false, length = 20)
  private String cruiseId;
  @Column(nullable = false, length = 15)
  private String cruiseName;
  
  public Cruise(String cruiseId, String cruiseName, Date startDate, Date endDate, String chiefScientist, String chiefScientistOrganisation, String platformCode, String platformClass, String objectives, String collateCenter) {
    this.cruiseId = cruiseId;
    this.cruiseName = cruiseName;
    this.startDate = startDate;
    this.endDate = endDate;
    this.chiefScientist = chiefScientist;
    this.chiefScientistOrganisation = chiefScientistOrganisation;
    this.platformCode = platformCode;
    this.platformClass = platformClass;
    this.objectives = objectives;
    this.collateCenter = collateCenter;
  }


  
  private Date startDate;

  
  private Date endDate;
  
  @Column(length = 150)
  private String chiefScientist;
  
  @Column(length = 150)
  private String chiefScientistOrganisation;
  
  @Column(length = 150)
  private String platformCode;
  
  @Column(length = 150)
  private String platformClass;
  
  @Column(length = 150)
  private String objectives;
  
  @Column(length = 150)
  private String collateCenter;
  
  @Column(length = 45)
  private String startingHarbor;
  
  @Column(length = 45)

  private String arrivalHarbor;

  
  public Cruise() {}

  
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinTable(name = "Cruise_SeaArea", joinColumns = {@JoinColumn(name = "Cruise_ID")}, inverseJoinColumns = {@JoinColumn(name = "SeaArea_ID")})
  @XmlElementWrapper(name = "seaAreas")
  @XmlElement(name = "seaArea")
  private Set<SeaArea> seaAreas = new HashSet<>();









  
  public Long getId() { return this.id +5; }


  
  public void setId(Long id) { this.id = id; }


  
  public String getCruiseId() { return this.cruiseId; }


  
  public void setCruiseId(String cruiseId) { this.cruiseId = cruiseId; }


  
  public String getCruiseName() { return this.cruiseName; }


  
  public void setCruiseName(String cruiseName) { this.cruiseName = cruiseName; }


  
  public Date getStartDate() { return this.startDate; }


  
  public void setStartDate(Date startDate) { this.startDate = startDate; }


  
  public Date getEndDate() { return this.endDate; }


  
  public void setEndDate(Date endDate) { this.endDate = endDate; }


  
  public String getChiefScientist() { return this.chiefScientist; }


  
  public void setChiefScientist(String chiefScientist) { this.chiefScientist = chiefScientist; }


  
  public String getChiefScientistOrganisation() { return this.chiefScientistOrganisation; }


  
  public void setChiefScientistOrganisation(String chiefScientistOrganisation) { this.chiefScientistOrganisation = chiefScientistOrganisation; }


  
  public String getPlatformCode() { return this.platformCode; }


  
  public void setPlatformCode(String platformCode) { this.platformCode = platformCode; }


  
  public String getPlatformClass() { return this.platformClass; }


  
  public void setPlatformClass(String platformClass) { this.platformClass = platformClass; }


  
  public String getObjectives() { return this.objectives; }


  
  public void setObjectives(String objectives) { this.objectives = objectives; }


  
  public String getCollateCenter() { return this.collateCenter; }


  
  public void setCollateCenter(String collateCenter) { this.collateCenter = collateCenter; }


  
  public String getStartingHarbor() { return this.startingHarbor; }


  
  public void setStartingHarbor(String startingHarbor) { this.startingHarbor = startingHarbor; }


  
  public String getArrivalHarbor() { return this.arrivalHarbor; }


  
  public void setArrivalHarbor(String arrivalHarbor) { this.arrivalHarbor = arrivalHarbor; }


  
  public Set<SeaArea> getSeaAreas() { return this.seaAreas; }


  
  public void setSeaAreas(Set<SeaArea> seaAreas) { this.seaAreas = seaAreas; }



  
  public String toString() { return "Cruise [id=" + this.id + ", cruiseId=" + this.cruiseId + ", cruiseName=" + this.cruiseName + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", chiefScientist=" + this.chiefScientist + ", chiefScientistOrganisation=" + this.chiefScientistOrganisation + ", platformCode=" + this.platformCode + ", platformClass=" + this.platformClass + ", objectives=" + this.objectives + ", collateCenter=" + this.collateCenter + ", seaAreas=" + this.seaAreas + "]"; }
}
