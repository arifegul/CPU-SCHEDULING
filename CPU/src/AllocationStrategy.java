import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;


public abstract class AllocationStrategy {
    protected List<CPUJob> Jobs;
    protected ArrayList<CPUJob> Queue;
    
    public AllocationStrategy(List<CPUJob> jobs) {
        super();
        Jobs = jobs;
    }
    
    public abstract void run();
  
}









