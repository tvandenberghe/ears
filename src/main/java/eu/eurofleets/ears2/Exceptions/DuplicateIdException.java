package eu.eurofleets.ears2.Exceptions;

import org.springframework.dao.DuplicateKeyException;

public class DuplicateIdException
  extends DuplicateKeyException
{
  private static final long serialVersionUID = 1L;
  
  public DuplicateIdException(String msg) { super(msg); }
}
