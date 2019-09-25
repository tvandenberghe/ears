package eu.eurofleets.ears2.domain.cruise;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;

public @interface SSRSchema {
  String namespace();
  
  XmlNsForm elementFormDefault();
  
  XmlNs[] xmlns();
}
