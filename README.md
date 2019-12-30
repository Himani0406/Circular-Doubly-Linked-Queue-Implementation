# Circular-Doubly-Linked-Queue-Implementation
Queue supports adding new elements, returns the element with the first element and removing the first element. Adding an element and removing the element with the highest element is at most O(1) where N is the size of the queue. The queue starts with a capacity greater that 1. When the queue is full and another element is added the queue capacity is doubled. If additions and deletions are intermixed it is possible that a large number additions can be done without increasing the capacity.

Queue also holds process objects. A process has a name (String), an owner (String), PID (int), number of threads, percent of CPU currently being used and total amount of CPU time used.

Programs that use this queue displays and prints out the elements in the queue. They display/print out the queue ordered by name, PID, CPU time used, percent of CPU time, total CPU time or by owner.
