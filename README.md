# SchedulingALGO

This repository contains implementations of various scheduling algorithms in different programming languages. Each algorithm is implemented in separate files.

## FIFO (First-In-First-Out)

### C# Implementation
- `FIFO.cs` contains the C# implementation of the FIFO scheduling algorithm.
- The `Process` class represents a process with its process ID, arrival time, and burst time.
- The `FIFOAlgorithm` class implements the FIFO algorithm using a queue data structure.
- The `Main` method in `FIFO.cs` demonstrates how to use the FIFO algorithm with sample processes.

### Java Implementation
- `FIFO.java` contains the Java implementation of the FIFO scheduling algorithm.
- Similar to the C# implementation, it includes the `Process` and `FIFOAlgorithm` classes.
- The `Main` method in `FIFO.java` demonstrates how to use the FIFO algorithm with sample processes.

## Round Robin

### Java Implementation
- `RoundRobin.java` contains the Java implementation of the Round Robin scheduling algorithm.
- The `Process` class represents a process with its process ID, arrival time, burst time, and remaining burst time.
- The `RoundRobin` class implements the Round Robin algorithm using a queue data structure and a time quantum.
- The `main` method in `RoundRobin.java` demonstrates how to use the Round Robin algorithm with sample processes.

## SJF (Shortest Job First)

### Java Implementation
- `SJFAlgorithm.java` contains the Java implementation of the Shortest Job First (SJF) scheduling algorithm.
- Similar to other implementations, it includes the `Process` class.
- The `SJFAlgorithm` class implements the SJF algorithm using a priority queue to prioritize processes based on burst time.
- The `main` method in `SJFAlgorithm.java` demonstrates how to use the SJF algorithm with sample processes.

Enjoy exploring the different scheduling algorithms in the SchedulingALGO repository!
