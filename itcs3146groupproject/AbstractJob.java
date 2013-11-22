package itcs3146groupproject;

import java.util.*;

public interface AbstractJob
{
   public int getSize();
	public int getCycles();
	public void decrementRunTime();
	public boolean isFinishedRunning();
	public int getNumberOfPages(int pageSize);
}