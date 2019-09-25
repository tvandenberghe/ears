package eu.eurofleets.ears2.domain.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.GenericGenerator;










@Entity
@Table(name = "TOOL")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tool
{
	  @Id
	 
  @Column(name = "ID")
  @XmlTransient
  private Long id;
  @Column(length = 45)
  private String name;
  
  public String toString() { return "Tool [id=" + this.id + ", name=" + this.name + "]"; }


  
  public Long getId() { return this.id; }


  
  public void setId(Long id) { this.id = id; }


  
  public String getName() { return this.name; }


  
  public void setName(String name) { this.name = name; }
}
