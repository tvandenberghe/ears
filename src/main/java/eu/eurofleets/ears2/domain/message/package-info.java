// 
 // fichier package-info.java
 //
 @XmlSchema ( 
   xmlns = {
       @XmlNs(prefix="ewsl", namespaceURI="http://www.eurofleets.eu/"),
       @XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
   }, 
   namespace="http://www.eurofleets.eu/", 
   elementFormDefault=XmlNsForm.QUALIFIED, 
   attributeFormDefault=XmlNsForm.UNQUALIFIED
)
 


package eu.eurofleets.ears2.domain.message;


import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
