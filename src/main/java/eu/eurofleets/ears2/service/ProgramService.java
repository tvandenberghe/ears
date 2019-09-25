package eu.eurofleets.ears2.service;

import eu.eurofleets.ears2.domain.program.Program;
import eu.eurofleets.ears2.domain.program.Project;
import java.util.List;

public interface ProgramService {
  List<Program> getProgramList();
  
  Program getProgramByID(String paramString);
  
  List<Program> getProgramListByCruiseId(String paramString);
  
  void setProgram(Program paramProgram);
  
  void setProgram(String paramString, Program paramProgram);
  
  void removeProgram(String paramString);
  
  Project getProject(String paramString);
}
