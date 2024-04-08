import java.util.*;

class Process {
    int pid; // Process ID
    int arrivalTime; // Arrival time of the process
    int burstTime; // Burst time of the process

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class SJFAlgorithm {
    // Function to implement Shortest Job First (SJF) scheduling algorithm
    public static void sjfScheduling(Process[] processes) {
        // Sort processes based on arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        // Create a priority queue to store processes based on burst time
        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.burstTime));

        int currentTime = 0;
        float totalWaitingTime = 0;
        float totalTurnaroundTime = 0;

        // Process each process
        for (Process process : processes) {
            // Add processes that have arrived to the queue
            while (!pq.isEmpty() && currentTime < process.arrivalTime) {
                Process currentProcess = pq.poll();
                currentTime += currentProcess.burstTime;
                totalTurnaroundTime += currentTime - currentProcess.arrivalTime;
            }

            // If process hasn't arrived yet, update current time
            if (currentTime < process.arrivalTime) {
                currentTime = process.arrivalTime;
            }

            // Add current process to the queue
            pq.offer(process);

            // Process the current process
            currentTime += process.burstTime;
            totalTurnaroundTime += currentTime - process.arrivalTime;

            // Calculate waiting time for the current process
            totalWaitingTime += currentTime - process.arrivalTime - process.burstTime;
        }

        // Calculate average waiting time and average turnaround time
        float avgWaitingTime = totalWaitingTime / processes.length;
        float avgTurnaroundTime = totalTurnaroundTime / processes.length;

        // Display average waiting time and average turnaround time
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void main(String[] args) {
        // Create an array of processes
        Process[] processes = {
                new Process(1, 0, 6),
                new Process(2, 1, 3),
                new Process(3, 2, 7),
                new Process(4, 3, 2),
                new Process(5, 4, 5)
        };

        // Call SJF scheduling algorithm
        sjfScheduling(processes);
    }
}
