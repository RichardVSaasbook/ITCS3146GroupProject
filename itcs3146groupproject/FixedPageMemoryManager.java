package itcs3146groupproject;

import java.util.LinkedList;
import java.util.ListIterator;

public class FixedPageMemoryManager {
	private int totalNumberOfPages,
		availableNumberOfPages,
		pageSize;
	private LinkedList<Job> jobList;
	
	public FixedPageMemoryManager(int numberOfPages, int pageSize) {
		totalNumberOfPages = availableNumberOfPages = numberOfPages;
		this.pageSize = pageSize;
		jobList = new LinkedList<>();
	}
	
	public int getTotalNumberOfPages() { return totalNumberOfPages; }
	
	public boolean hasJobs() { return availableNumberOfPages != totalNumberOfPages; }
	
	public boolean jobCanFit(Job j) {
		return j.getNumberOfPages(pageSize) < availableNumberOfPages;
	}
	
	public void addJob(Job j) {
		availableNumberOfPages -= j.getNumberOfPages(pageSize);
		jobList.add(j);
	}
	
	public void performTimeCycle() {
		ListIterator<Job> jobIterator = jobList.listIterator();
		
		while (jobIterator.hasNext()) {
			Job j = jobIterator.next();
			
			if (j.isFinishedRunning()) {
				availableNumberOfPages += j.getNumberOfPages(pageSize);
				jobList.remove(j);
			}
		}
	}
}
