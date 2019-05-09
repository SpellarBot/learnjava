Few cases of memory leaks:

. If you create Logger related class and use it, Logger will keep the object alive. If this object is used as InnerClass, it will keep outerClass alive. Outer class can hold heavy objects leading to Memory consumption and reducing available memory.
example - ApplicationRunner
. If you create ThreadLocal values, and the threads are part of ExecutorService i.e. the threads will not shutdown post work, the values will also remain. If these values have large memory foot print, memory is lost. You need to call .remove method on THreadLocal values to remove them from thread.
. If you are using Off-Heap Memory data and not cleaning up later. 


-------------------------------
Off-Heap Memory

Native Code - JNI invoked native lib
DirectBuffers - Off heap buffers allocated by Java code.
Memory Mapped Files - used for inter process communications.

top -p <pid> - can tell the memory usage in such cases.
Also - -XX:MaxDirectMemorySize=1G will limit the buffer allocation limit.

-------------------------------
Out of memory can happen due to 
. memory leak
. actual need for high mem
