import java.util.LinkedList;
import java.util.Queue;

class Process {
    int pid; // Process ID
    int arrivalTime; // Arrival time of the process
    int burstTime; // Burst time of the process
    int remainingBurstTime; // Remaining burst time of the process

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime; // Initialize remaining burst time
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        // Create an array of processes
        Process[] processes = {
                new Process(1, 0, 5),
                new Process(2, 1, 4),
                new Process(3, 2, 2),
                new Process(4, 3, 1)
        };

        int timeQuantum = 2;
        roundRobinScheduling(processes, timeQuantum);
    }

    // Function to implement Round Robin scheduling algorithm with given time quantum
    public static void roundRobinScheduling(Process[] processes, int timeQuantum) {
        Queue<Process> queue = new LinkedList<>();
        int currentTime = 0;

        while (!allProcessesCompleted(processes)) {
           
            for (Process process : processes) {
                if (process.arrivalTime == currentTime && process.remainingBurstTime > 0) {
                    queue.add(process);
                }
            }

            
            while (!queue.isEmpty()) {
                Process currentProcess = queue.poll();
                int executionTime = Math.min(timeQuantum, currentProcess.remainingBurstTime);
                currentProcess.remainingBurstTime -= executionTime;
                currentTime += executionTime;

               
                if (currentProcess.remainingBurstTime == 0) {
                    int turnaroundTime = currentTime - currentProcess.arrivalTime;
                    int waitingTime = turnaroundTime - currentProcess.burstTime;
                    System.out.println("Process " + currentProcess.pid + " completed. Turnaround Time: "
                            + turnaroundTime + ", Waiting Time: " + waitingTime);
                } else {
                  
                    queue.add(currentProcess);
                }
            }

            // If no process arrived, move to the next time unit
            if (queue.isEmpty()) {
                currentTime++;
            }
        }
    }

    public static boolean allProcessesCompleted(Process[] processes) {
        for (Process process : processes) {
            if (process.remainingBurstTime > 0) {
                return false;
            }
        }
        return true;
    }
}

