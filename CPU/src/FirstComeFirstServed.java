import java.util.ArrayList;
import java.util.List;


public class FirstComeFirstServed extends AllocationStrategy {
    
    int temp;
    int proceessArrivalTime;
    int waitingTime;
    double avgWaitingTime;
    double avgTurnAroundTime;
    int CpuTime;
    
    public FirstComeFirstServed(List<CPUJob> jobs) {
        super(jobs);
    }
    
    @Override
    public void run() {
        
    }
    
    public void run(List<CPUJob> jobList) {
        int count = 0;
        System.out.println("============================== ");
        System.out.println("First Come First Served ");
        System.out.println("============================== ");
        System.out.println("Process ID | Arrival time  | Burst time  | Completion time  | Turnaround time | Waiting time ");
        System.out.println("================================================================================================== ");
        for(CPUJob job:jobList){
            
            if(count==0){
                job.processArrivalTime = job.getArrivalTime();
                job.ProcessCompletionTime = job.getArrivalTime()+job.getCpuTime();
                }else{
                job.processArrivalTime = temp-job.getArrivalTime();
                job.ProcessCompletionTime = temp+job.getCpuTime();
            }
            
            
            temp = job.ProcessCompletionTime;
            job.turnAroundTime = temp-job.getArrivalTime();
            job.waitingTime = job.turnAroundTime-job.getCpuTime();
            count++;
            
            avgWaitingTime =  avgWaitingTime+job.waitingTime;
            avgTurnAroundTime = avgTurnAroundTime+job.turnAroundTime;
            System.out.println("   "+job.getProcessId()+" |     "+"  "+job.getArrivalTime()+"       |    "+" "+job.getCpuTime() +"     |      "+"   "+job.ProcessCompletionTime+"        |      "+"   "+job.turnAroundTime+"      |      "+"   "+job.waitingTime+"  ");
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
        System.out.println("===============================================");
        System.out.println("Avg waiting time:"+avgWaitingTime/jobList.size());
        System.out.println("===============================================");
        System.out.println("Avg turn around time:"+avgTurnAroundTime/jobList.size());
        System.out.println("===============================================");
        
    }
    
  
    
}
