import java.util.LinkedList;
import java.util.Queue;

class Process {
    double pid, AT, BT;

    public Process(double pid, double AT, double BT) {
        this.pid = pid;
        this.AT = AT;
        this.BT = BT;
    }
}

public class FIFO {
    public static void main(String[] args) {
        Process[] pro = {
                new Process(1, 0, 3),
                new Process(2, 2, 5),
                new Process(3, 4, 2)
        };

        FIFOAlgorithm.FIFO(pro); 
    }
}

class FIFOAlgorithm {
    public static void FIFO(Process[] processes) { 
        Queue<Process> queue = new LinkedList<>();

        float TWT = 0, TAT = 0;
        for (Process process : processes) {
            if (!queue.isEmpty()) {
                TAT += queue.peek().BT;
            }
            queue.add(process);
            System.out.println("Process " + process.pid + " is being executed.");
            TWT += TAT - process.AT;
            queue.remove();
        }
        float avgWT = TWT / processes.length;
        float avgTAT = TAT / processes.length;
        System.out.println("Average Waiting Time: " + avgWT); 
        System.out.println("Average Turnaround Time: " + avgTAT); 
    }
}
