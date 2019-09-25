package eu.eurofleets.ears2.domain.program;

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
@Table(name = "PROGRAM")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Program {
  @Id
 

  @Column(name = "ID")
  private Long id;
  
  @Column(unique = true, nullable = false, length = 15)
  @XmlAttribute
  private String programId;
  @Column(unique = true, nullable = false, length = 15)
  @XmlAttribute
  private String cruiseId;
  
  public Program(String programId, String cruiseId, String originatorCode, String PIName, String description) {
    this.programId = programId;
    this.cruiseId = cruiseId;
    this.originatorCode = originatorCode;
    this.PIName = PIName;
    this.description = description;
  }


  
  @Column(length = 150)
  private String originatorCode;

  
  @Column(length = 150)
  private String PIName;

  
  @Column(length = 150)
  private String description;


  
  public Program() {}

  
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  @JoinTable(name = "Program_Project", joinColumns = {@JoinColumn(name = "Program_ID")}, inverseJoinColumns = {@JoinColumn(name = "Project_ID")})
  @XmlElementWrapper(name = "projects")
  @XmlElement(name = "project")
  private Set<Project> projects = new HashSet<>();









  
  public Long getId() { return this.id; }


  
  public void setId(Long id) { this.id = id; }


  
  public String getProgramId() { return this.programId; }


  
  public void setProgramId(String programId) { this.programId = programId; }


  
  public String getCruiseId() { return this.cruiseId; }


  
  public void setCruiseId(String cruiseId) { this.cruiseId = cruiseId; }


  
  public String getOriginatorCode() { return this.originatorCode; }


  
  public void setOriginatorcode(String originatorCode) { this.originatorCode = originatorCode; }


  
  public String getPIName() { return this.PIName; }


  
  public void setPIName(String PIName) { this.PIName = PIName; }


  
  public String getDescription() { return this.description; }


  
  public void setDescription(String description) { this.description = description; }


  
  public Set<Project> getProjects() { return this.projects; }


  
  public void setProjects(Set<Project> projects) { this.projects = projects; }
}
