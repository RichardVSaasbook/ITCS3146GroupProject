package itcs3146groupproject;
import java.util.*;

public class NullJob implements AbstractJob
{
	public NullJob(){}
	
	public int getSize(){return 0;}
	public int getCycles(){return 0;}
	public void decrementRunTime(){}
	public boolean isFinishedRunning(){return true;}
	public int getNumberOfPages(int pageSize){return 0;}
}