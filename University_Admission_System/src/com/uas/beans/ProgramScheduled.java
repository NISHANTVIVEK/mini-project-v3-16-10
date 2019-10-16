package com.uas.beans;

public class ProgramScheduled {

	String programId;
	String programName;
	String location;
	String startDate;
	String endDate;
	int sessionsPerWeek;
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}
	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}
	
	@Override
	public String toString() {
		return "ProgramScheduled [programId=" + programId + ", programName=" + programName + ", location=" + location
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", sessionsPerWeek=" + sessionsPerWeek + "]";
	}
	
	
}
