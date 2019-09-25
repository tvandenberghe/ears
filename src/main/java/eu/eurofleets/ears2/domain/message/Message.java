package eu.eurofleets.ears2.domain.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;







@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message
{
  public static final long RESPONSE_OK = 0L;
  public static final long RESPONSE_NOK = -1L;
  private String code;
  private String description;
  
  public Message() {}
  
  public Message(String code, String description) {
    this.code = code;
    this.description = description;
  }

  
  public String getCode() { return this.code; }


  
  public void setCode(String code) { this.code = code; }


  
  public String getDescription() { return this.description; }


  
  public void setDescription(String description) { this.description = description; }
}
