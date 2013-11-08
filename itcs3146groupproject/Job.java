package itcs3146groupproject;

public class Job implements Comparable<Job> {
	private static int totalNumberOfJobs = 0;
	private int id,
		size,
		cycles;
	
	public Job(int size, int cycles) {
		id = ++totalNumberOfJobs;
		this.size = size;
		this.cycles = cycles;
	}
	
	public int getSize() { return size; }
	public int getCycles() { return cycles; }
	
	public void decrementRunTime() { cycles--; }
	
	public boolean isFinishedRunning() { return cycles == 0; }
	
	public int getNumberOfPages(int pageSize) { return (int) Math.ceil(getSize() / pageSize); }
	
	@Override
	public int compareTo(Job j) {
		if (getCycles() < j.getCycles())
			return -1;
		else if (getCycles() == j.getCycles())
			return 0;
		else
			return 1;
	}
	
	@Override
	public String toString() { return "Job " + id; }
}