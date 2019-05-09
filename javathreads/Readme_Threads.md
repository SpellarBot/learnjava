**What is thread ?**
* All Java programs run on at least one thread - main
* A thread is an independent path of code execution
* Many threads can run concurrently
* Runnable are objects that encapsulate code sequences
* Each thread executes a runnable object
* Threads can initiate an asynchronous task i.e. a task that can run concurrently

**Each Thread** - has its separate stack space
* This avoids interference
* stack holds local variables
* It also tracks next instructions and calls methods

**Java Supports thread through:**
* java.lang.Thread
* java.lang.Runnable

**Types** 
* daemon or non-daemon
* Java GC - daemon thread. 
* Can use `setDaemon(true)` to mark thread as Daemon. 
* Daemon thread would not stop jvm from exiting.

**States:**

**New** --_start()_-- **Runnable** --_run()_--  **Running** --_wait()/sleep()_-- **Waiting** --notify()-- **Dead**  

**wait vs sleep**
* The major difference is that wait() releases the lock while sleep() doesn't release any lock while waiting. wait() is used for inter-thread communication while sleep() is used to introduce a pause on execution, generally.
* sleep is static method while wait has to be called on thread object.

**Daemon vs User Threads**
* **Priority**: When the only remaining threads in a process are daemon threads, the interpreter exits. This makes sense because when only daemon threads remain, there is no other thread for which a daemon thread can provide a service.
* **Usage**: Daemon thread is to provide services to user thread for background supporting task.

**Thread States**
* NEW - created but not started
* RUNNABLE - executing in JVM
* BLOCKED - waiting for a monitor to be unlocked
* WAITING - waiting to be notified to continue
* TIMED_WAITING - waiting with time limit
* TERMINATED - thread has completed execution


Create 2 threads, start them, and wait for termination. This is how it looks.

```
NAME|Alive|State|Priority
----|-----|-----|--------
T1|false|NEW|5
Thread-0|false|NEW|5
---------------above status is before threads started.----------
main|true|RUNNABLE|5
T1|true|RUNNABLE|5
Thread-0|true|RUNNABLE|5
---------------above status is after threads started.----------
---------------sleep 10000 over.----------
main|true|RUNNABLE|5
T1|false|TERMINATED|5
Thread-0|false|TERMINATED|5
```


**Static Methods**
* activeCount() - returns estimated number of threads
* currentThread() - returns ref to current thread
* enumerate(Thread[] tarr) - active threads array
* sleep(long millis) - sleep or stop execution
* join() - waits for this thread to die. can have max wait.  
* interrupt() - stops execution of current thread
 
**Synchronization**
* Synchronized code is known as critical sections
* JVM Supports it via monitors
* Every Java Object is associated with a monitor
* Before a thread enters a critical section, it must get a lock on the monitor
* if monitor is already blocked, thread is blocked
* Shared variables are copied into thread's working memory
* This ensures access to most recent values
* When done, thread writes values back to main memory


**Wait and Notify**
* wait() - causes thread to wait till another thread calls notify() or notifyall()
* wait( long millis ) - same as above or till time gets over
* wait( long millis, int nano ) - nanoseconds for finer precision

* notify() - notifies the threads waiting for this objects monitor. arbitrary thread
* notifyAll() - all threads are notified. they wake one by one but all will get chance vs notify() where after first thread, others will not get chance.

* wait set - all waiting threads
* IllegalMonitorStateException - if thread invokes wait or notify but it actually does not have the lock on the object.

**Threading Utilities**
* Task Executor services
* Fork/Join framework
* Concurrent collections
* Atomic Variables
* Synchronizers
* Locks
* Nanosecond granularity timing

**Executor services to simplify thread creation**
* Executor - supports launching new tasks
* ExecutorService - add features to manager lifecycle
* ScheduledExecutorService - support future tasks

* Executor example 
`
Executors.newFixedThreadPool(5);
`

**Synchronizers :**
* Latches - CountDownLatch
* Barriers
* Semaphores
* Exchangers

**CountDownLatch** causes one or more threads to wait at a "gate".
Another thread opens the gate.
It contains a count value and logic to decrement the count until it reaches zero.

* void await()
* boolean await(long timeout, TimeUnit u)
* void countdown()
* long getcount()
* String toString()

**Locking**
* Lock, ReentrantLock
* Condition
* ReadWriteLock, ReentrantReadWriteLock

* void lock() - thread waits till lock obtained
* void lockinterruptibly()  - locks object till interrupted
* Condition newCondition() - new Condition thats bound to this lock instance
* boolean tryLock(), boolean tryLock(long time, TimeUnit u) - true/false - depending upon if lock is obtained or not.
* void unlock() - releases the lock



 
