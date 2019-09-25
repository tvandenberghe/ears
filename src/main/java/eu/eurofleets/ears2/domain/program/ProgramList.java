package eu.eurofleets.ears2.domain.program;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;








@XmlRootElement(name = "programs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProgramList
{
  public ProgramList() {}
  
  public ProgramList(List<Program> programs) { this.programs = programs; }
  
  @XmlElement(name = "program")
  private List<Program> programs = null;


  
  public List<Program> getPrograms() { return this.programs; }


  
  public void setPrograms(List<Program> programs) { this.programs = programs; }
}
