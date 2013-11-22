package itcs3146groupproject;
import java.util.*;

public class Master
{
	LinkedList<Slave> processors = new LinkedList();
	ListIterator<Slave> JobIterator = processors.listIterator();
	
	public void runTimeCycle(PriorityQueue<Job> available)
	{
		while(JobIterator.hasNext())
		{
			Slave j = JobIterator.next();
			j.processJob();
			
			if(j.isFinishedRunning())
			{
				j.removeJob();
				j.addJob(available.poll());
			}
		}
	}
}