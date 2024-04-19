using System;
using System.Collections.Generic;

class Process
{
    public double pid, AT, BT;

    public Process(double pid, double AT, double BT)
    {
        this.pid = pid;
        this.AT = AT;
        this.BT = BT;
    }
}

public class FIFO
{
    public static void Main(string[] args)
    {
        Process[] pro = {
            new Process(1, 0, 3),
            new Process(2, 2, 5),
            new Process(3, 4, 2)
        };

        FIFOAlgorithm.FIFO(pro);
    }
}

class FIFOAlgorithm
{
    public static void FIFO(Process[] processes)
    {
        Queue<Process> queue = new Queue<Process>();

        float TWT = 0, TAT = 0;
        foreach (Process process in processes)
        {
            if (queue.Count != 0)
            {
                TAT += queue.Peek().BT;
            }
            queue.Enqueue(process);
            Console.WriteLine("Process " + process.pid + " is being executed.");
            TWT += TAT - (float)process.AT;
            queue.Dequeue();
        }
        float avgWT = TWT / processes.Length;
        float avgTAT = TAT / processes.Length;
        Console.WriteLine("Average Waiting Time: " + avgWT);
        Console.WriteLine("Average Turnaround Time: " + avgTAT);
    }
}
