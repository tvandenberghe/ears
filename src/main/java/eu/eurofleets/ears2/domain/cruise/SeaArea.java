package eu.eurofleets.ears2.domain.cruise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "SEAAREA")
@XmlAccessorType(XmlAccessType.FIELD)
public class SeaArea
{
  @Id
  @GeneratedValue
  @Column(name = "ID")
  @XmlTransient
  private Long id;
  
  public SeaArea(String seaAreaId, String uRN) {
    this.seaAreaId = seaAreaId;
    this.URN = uRN;
  }


  
  @Column(length = 15)
  @XmlAttribute(name = "id")
  private String seaAreaId;

  
  @Column(length = 150)
  private String URN;

  
  public SeaArea() {}

  
  public Long getId() { return this.id; }


  
  public void setId(Long id) { this.id = id; }


  
  public String getSeaAreaId() { return this.seaAreaId; }


  
  public void setSeaAreaId(String seaAreaId) { this.seaAreaId = seaAreaId; }


  
  public String getURN() { return this.URN; }


  
  public void setURN(String uRN) { this.URN = uRN; }



  
  public String toString() { return "SeaArea [id=" + this.id + ", seaAreaId=" + this.seaAreaId + ", URN=" + this.URN + "]"; }
}
