package com.uas.dao;

import java.util.List;

import com.uas.beans.Application;
import com.uas.beans.Program;
import com.uas.beans.ProgramScheduled;

public interface ApplicationDAO {
	
	public int addApplicationDetails(Application app);
	public List<Program> showDetails();
	public List<ProgramScheduled> showScheduledDetails();

}
