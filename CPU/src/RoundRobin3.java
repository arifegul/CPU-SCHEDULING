import java.util.List;

public class RoundRobin3  {
    
    int [] temp;
    int [] tempWaitinTime;
    int commBT, k;
    int tq;
    int[][] d;
    int btcache;
    
    void start( ){
        for (int i = 0; i < d.length; i++) {
            int bt  = d[i][1];
            if( bt > 0){
                if( bt <= tq){
                    temp[i] = btcache+bt;
                    btcache = temp[i];
                    k += bt;
                    bt -= bt;
                    
                }
                else{
                    temp[i] = btcache+tq;
                    btcache = temp[i];
                    bt -= tq;
                    k += tq;
                }
                
                d[i][1] = bt;
                
            }
        }
        if( k!= commBT)
        start();
    }
    
    private void display(List<CPUJob> jobList) {
        float avgTurnArroundTime = 0;
        float avgWaitigTime = 0;
     int c = 1;
         System.out.println("=================== ");
        System.out.println("ROUND ROBIN-3 ");
        System.out.println("=================== ");
        System.out.println("Process ID | Arrival time |  Burst time  | Turnaround time | Waiting time ");
        System.out.println("========================================================================== ");
        Object[] job = jobList.toArray();
        for (int i : temp) {
            CPUJob job1 = (CPUJob) job[c-1];
            System.out.println( "    " + job1.getProcessId() + "       "  + job1.getArrivalTime() + "        |     "+job1.getCpuTime()+"         |     " + i +"       |     "+(i-job1.getCpuTime()));
            System.out.println("-----------------------------------------------------------------------------");
            avgTurnArroundTime += i;
            avgWaitigTime += (i-job1.getCpuTime());
            c++;
        }
        System.out.println("===============================================");
        System.out.println( "Avg waiting time = " + avgWaitigTime/temp.length);
        System.out.println("===============================================");
        System.out.println( "Avg turn round time = " + avgTurnArroundTime/temp.length);
        System.out.println("===============================================");
    }
    public void run(List<CPUJob> jobList, int quantum) {
        
        int pcount = jobList.size();
        d = new int[pcount][2];
        
        temp = new int[pcount];
        int count = 0;
        for(CPUJob job:jobList){
            d[count][0] = count;
            
            int m = job.getCpuTime();
            d[count][1] = m;
            
            commBT += m;
            count++;
        }
        
        
        tq = quantum=3;
        start();
        display(jobList);
        
    }
}