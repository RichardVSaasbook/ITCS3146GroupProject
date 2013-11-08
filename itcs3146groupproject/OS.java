package itcs3146groupproject;

import java.util.LinkedList;
import java.util.ListIterator;

public class OS {
	LinkedList waitingJobs;
	
	public OS(LinkedList waitingJobs) {
		this.waitingJobs = waitingJobs;
		
		FixedPageMemoryManager m = new FixedPageMemoryManager(25, 100);
		
		while(!waitingJobs.isEmpty() && m.hasJobs()) {
			ListIterator<Job> jobIterator = waitingJobs.listIterator();
			
			while (jobIterator.hasNext()) {
				Job j = jobIterator.next();
				
				if (m.jobCanFit(j)) {
					m.addJob(j);
				}
			}
		}
	}
}
