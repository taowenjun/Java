Fork/Join

一、背景

虽然目前处理器核心数已经发展到很大数目，但是按任务并发处理并不能完全充分的利用处理器资源，因为一般的应用程序没有那么多的并发处理任务。基于这种现状，考虑把一个任务拆分成多个单元，每个单元分别得到执行，最后合并每个单元的结果。

Fork/Join框架是JAVA7提供的一个用于并行执行任务的框架，是一个把大任务分割成若干个小任务，最终汇总每个小任务结果后得到大任务结果的框架。


二、工作窃取算法

指的是某个线程从其他队列里窃取任务来执行。使用的场景是一个大任务拆分成多个小任务，为了减少线程间的竞争，把这些子任务分别放到不同的队列中，并且每个队列都有单独的线程来执行队列里的任务，线程和队列一一对应。但是会出现这样一种情况：A线程处理完了自己队列的任务，B线程的队列里还有很多任务要处理。A是一个很热情的线程，想过去帮忙，但是如果两个线程访问同一个队列，会产生竞争，所以A想了一个办法，从双端队列的尾部拿任务执行。而B线程永远是从双端队列的头部拿任务执行（任务是一个个独立的小任务），这样感觉A线程像是小偷在窃取B线程的东西一样。

工作窃取算法的优点：

         利用了线程进行并行计算，减少了线程间的竞争。

工作窃取算法的缺点：

         1、如果双端队列中只有一个任务时，线程间会存在竞争。

         2、窃取算法消耗了更多的系统资源，如会创建多个线程和多个双端队列。
         
         
三、框架设计

Fork/Join中两个重要的类：

1、ForkJoinTask：使用该框架，需要创建一个ForkJoin任务，它提供在任务中执行fork和join操作的机制。一般情况下，我们并不需要直接继承ForkJoinTask类，只需要继承它的子类，它的子类有两个：

a、RecursiveAction:用于没有返回结果的任务。

b、RecursiveTask:用于有返回结果的任务。

2、ForkJoinPool：任务ForkJoinTask需要通过ForkJoinPool来执行。


四、源码解读

1、fork()

public final ForkJoinTask<V> fork() {

        Thread t;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread)
            ((ForkJoinWorkerThread)t).workQueue.push(this);
        else
            ForkJoinPool.common.externalPush(this);
        return this;
}

fork方法内部会先判断当前线程是否是ForkJoinWorkerThread的实例，如果满足条件，则将task任务push到当前线程所维护的双端队列中。

final void push(ForkJoinTask<?> task) {

            ForkJoinTask<?>[] a; ForkJoinPool p;
            int b = base, s = top, n;
            if ((a = array) != null) {    // ignore if queue removed
                int m = a.length - 1;     // fenced write for task visibility
                U.putOrderedObject(a, ((m & s) << ASHIFT) + ABASE, task);
                U.putOrderedInt(this, QTOP, s + 1);
                if ((n = s - b) <= 1) {
                    if ((p = pool) != null)
                        p.signalWork(p.workQueues, this);
                }
                else if (n >= m)
                    growArray();
            }
}
        
在push方法中，会调用ForkJoinPool的signalWork方法唤醒或创建一个工作线程来异步执行该task任务。

2、join()

public final V join() {

        int s;
        if ((s = doJoin() & DONE_MASK) != NORMAL)
            reportException(s);
        return getRawResult();
}
    
通过doJoin方法返回的任务状态来判断，如果不是NORMAL，则抛异常：

private void reportException(int s) {

        if (s == CANCELLED)
            throw new CancellationException();
        if (s == EXCEPTIONAL)
            rethrow(getThrowableException());
}

doJoin()方法

private int doJoin() {
        int s; Thread t; ForkJoinWorkerThread wt; ForkJoinPool.WorkQueue w;
        return (s = status) < 0 ? s :
            ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
            (w = (wt = (ForkJoinWorkerThread)t).workQueue).
            tryUnpush(this) && (s = doExec()) < 0 ? s :
            wt.pool.awaitJoin(w, this, 0L) :
            externalAwaitDone();
}

先查看任务状态，如果已经完成，则直接返回任务状态；如果没有完成，则从任务队列中取出任务并执行。



