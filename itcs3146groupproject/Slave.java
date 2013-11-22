package itcs3146groupproject;
import java.util.*;

public class Slave
{
	AbstractJob runningJob;
	private int id, size, cycles;
	
	public boolean processJob()
	{
		runningJob.decrementRunTime();
      return runningJob.isFinishedRunning();
	}

	public boolean isFinishedRunning()
	{
		return runningJob.isFinishedRunning();
	}
	
	public void removeJob()
	{			
		runningJob = new NullJob();
	}
	
	public void addJob(Job j)
	{
		runningJob = j;
	}
}