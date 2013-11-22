package itcs3146groupproject;

import java.util.*;

public class FixedPageMemoryManager {
	private int totalNumberOfPages,
		availableNumberOfPages,
		pageSize;
   private Master MasterProcessor;
	private PriorityQueue<Job> JobsInMemory = new PriorityQueue<Job>();
	
	private LinkedList<Job> jobList;
	
	public FixedPageMemoryManager(int numberOfPages, int pageSize, Master MasterProcessor) {
		totalNumberOfPages = availableNumberOfPages = numberOfPages;
		this.pageSize = pageSize;
		jobList = new LinkedList<>();
      this.MasterProcessor = MasterProcessor;  
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
		PriorityQueue<Job> updatedList = new PriorityQueue<Job>();
		
		while (jobIterator.hasNext()) {
			Job j = jobIterator.next();
			while(jobIterator.hasNext())
			{
				updatedList.offer(j);
			}
			MasterProcessor.runTimeCycle(updatedList);
			
			if (j.isFinishedRunning()) {
				availableNumberOfPages += j.getNumberOfPages(pageSize);
				jobList.remove(j);
			}
		}
	}
}
