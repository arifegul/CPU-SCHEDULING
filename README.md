# CPU SCHEDULING
 Java implementation of 4 CPU scheduling algorithms: First Come First Serve (FCFS), Shortest Job First (SJF), Round Robin-3 (RR-3) and Round Robin-5 (RR-5).

1.	First Come First Serve
It is the simplest algorithm to implement. The process with the minimal arrival time will get the CPU first. The lesser the arrival time, the sooner will the process gets the CPU. It is the non-preemptive type of scheduling.
IMPLEMENTATION
	The file is read (filename).
	Process ids specified as String in the file are imported (processId). Arrival time is synchronized to 0 (arrivalTime). The burst times specified as integer are taken (cpuTime).
	Completion Timer is synchronized to something temporary (temp) each time. Then each new job is collected with cpuTime (burst time) and Completion Time is obtained.
	With each new job, Completion Time is gathered with cpuTime (burst time) and synchronized to something temporary (temp) each time. Completion Time is obtained.
	temp-getArrivalTime () is equal to turnaround time (turnAround Time).
	turnAroundTime-getCpuTime() is equal to waiting time(waitingTime).

2.	Shortest Job First
The job with the shortest burst time will get the CPU first. The lesser the burst time, the sooner will the process get the CPU. It is the non-preemptive type of scheduling.
IMPLEMENTATION
	The file is read (filename).
	Process ids specified as String in the file are imported (processId). Arrival time is synchronized to 0 (arrivalTime). The burst times specified as integer are taken (cpuTime).
	Sort all the process according to the cpuTime(Burst time).
	Then select that process which has minimum Burst time.
	After completion of process make a pool of process which after till the completion of previous process and select that process among the pool which is having minimum Burst time.
	Waiting Time is equal to i (wt[q]).
	Turnaround time is equal to burst time total waiting time( tat[q] = i + bt[q]).

3.	Round Robin
In the Round Robin scheduling algorithm, the OS defines a time quantum (slice). All the processes will get executed in the cyclic way. Each of the process will get the CPU for a small amount of time (called time quantum) and then get back to the ready queue to wait for its next turn. It is a preemptive type of scheduling.
IMPLEMENTATION
	The file is read (filename).
	Process ids specified as String in the file are imported (processId). Arrival time is synchronized to 0 (arrivalTime). The burst times specified as integer are taken (cpuTime).
	An arraylist named job is determined.
	Initialize count = 0
	for loop is applied for job.
	Quantum is equal to tg and quantum is determined as 3 or 5 according to the Round Robin-3 or Round Robin-5 request.i (turnAround Time).
	i-getCpuTime()is equal to waiting time(waitingTime).
