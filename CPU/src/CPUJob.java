
public class CPUJob {
    private int id, submitTime, CPUTime, CPUTimeLeft;
    
    private int startTime = 0, endTime = 0;
    
    
    public int ProcessCompletionTime;
    public int processArrivalTime;
    public int waitingTime;
    public int turnAroundTime;
    private CPUJobFinishEvt evt;
    
    private int arrivalTime,cpuTime;
    private String processId;
    
    public CPUJob(int id, int submitTime, int CPUTime, CPUJobFinishEvt evt) {
        super();
        this.id = id;
        this.submitTime = submitTime;
        this.CPUTime = CPUTime;
        this.CPUTimeLeft = CPUTime;
        this.evt = evt;
    }
    
    public CPUJob(String processId, int arrivalTime, int cpuTime) {
        
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.cpuTime = cpuTime;
        
    }

  

    public void start(int sysTime) {
        startTime = sysTime;
    }
    
    public void tick(int sysTime) {
        CPUTimeLeft --;
        if (CPUTimeLeft <= 0){
            endTime = sysTime;
            evt.onFinish(this);
        }
        
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getSubmitTime() {
        return submitTime;
    }
    
    public void setSubmitTime(int submitTime) {
        this.submitTime = submitTime;
    }
    
    public int getCPUTime() {
        return CPUTime;
    }
    
    public void setCPUTime(int cPUTime) {
        CPUTime = cPUTime;
    }
    
    public int getCPUTimeLeft() {
        return CPUTimeLeft;
    }
    
    public void setCPUTimeLeft(int cPUTimeLeft) {
        CPUTimeLeft = cPUTimeLeft;
    }
    
    public int getStartTime() {
        return startTime;
    }
    
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    
    public int getEndTime() {
        return endTime;
    }
    
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }
    
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    public int getCpuTime() {
        return cpuTime;
    }
    
    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }
    
    public String getProcessId() {
        return processId;
    }
    
    public void setProcessId(String processId) {
        this.processId = processId;
    }
    
    
}
