import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPU_MAIN{
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        
        String filename ;
        String allocationStrategy;
        int quantum=3;
        int quantum1=5;
    
        
        filename = "test.txt";
        allocationStrategy = "FCFS";
        
        if(args.length==3){
            quantum = new Integer(args[2]);
        }
         if(args.length==5){
            quantum1 = new Integer(args[2]);
        }
        
        BufferedReader br = null;
      
        
        try {
            
            String sCurrentLine;
            
            br = new BufferedReader(new FileReader("C:\\Users\\HP\\Documents\\NetBeansProjects\\CPU\\src\\"+filename));

            //System.out.println("processId  arrivalTime  cpuTime");
            
            List<CPUJob> jobList = new ArrayList<CPUJob>();
            while ((sCurrentLine = br.readLine()) != null) {
                
                String a[] = sCurrentLine.split(",");
                String processId = new String(a[0]);
                int arrivalTime = 0;
                int cpuTime =new Integer(a[1]) ;
                
                CPUJob job = new CPUJob(processId,arrivalTime,cpuTime);
                
                jobList.add(job);
                
                //System.out.println(processId+" "+ arrivalTime+" " + cpuTime);
            }
            
         
            
             
                FirstComeFirstServed firstComeFirstServed = new FirstComeFirstServed(jobList);
                firstComeFirstServed.run(jobList);
         
                
                RoundRobin3 roundRobin = new RoundRobin3();
                roundRobin.run(jobList,quantum);
                
            
                ShortestJobFirst shortestJobFirst = new ShortestJobFirst(jobList);
                shortestJobFirst.run(jobList);
                
                
                RoundRobin5 roundRobin1 = new RoundRobin5();
                roundRobin1.run(jobList,quantum1);
                
        }
            
            catch (IOException e) {
            e.printStackTrace();
            } finally {
            try {
                if (br != null)br.close();
                } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        CPUJobFinishEvt callback = new CPUJobFinishEvt() {
            @Override
            public void onFinish(CPUJob j) {
                // this will be called when a job is finished.
            }
        };
        
        
      
    }
    
}