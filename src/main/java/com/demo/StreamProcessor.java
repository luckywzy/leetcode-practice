package com.demo;

import java.util.ArrayDeque;
import java.util.concurrent.locks.ReentrantLock;

public class StreamProcessor {
    private ArrayDeque<Integer[]> queue; // 双端队列，存储数据流中的数据
    private ReentrantLock lock; // 锁，保证数据的一致性和同步性

    public StreamProcessor() {
        this.queue = new ArrayDeque<>();
        this.lock = new ReentrantLock();
    }

    public void addData(int data) {
        // 添加数据
        lock.lock(); // 加锁
        try {
            long timestamp = System.currentTimeMillis() / 1000;
            queue.addLast(new Integer[]{data, (int) timestamp});
        } finally {
            lock.unlock(); // 解锁
        }
    }

    public double getAverage() {
        // 返回过去 5 分钟内已插入数据的平均值
        lock.lock(); // 加锁
        try {
            long threshold = System.currentTimeMillis() / 1000 - 300;
            int total = 0; // 元素个数
            int sum = 0; // 总和
            for (Integer[] element : queue) { // 从队列尾部开始遍历，找到第一个在过去 5 分钟内的元素
                if (element[1] >= threshold) { // 如果该元素在过去 5 分钟内
                    total++;
                    sum += element[0];
                } else { // 剩下的元素就在5分钟开外了
                    break;
                }
            }
            if (total == 0) {
                return 0;
            } else {
                return (double) sum / total;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StreamProcessor streamProcessor = new StreamProcessor();
        int i = 1;
        while (true) {
            streamProcessor.addData(i);
            Thread.sleep(1000);
            i++;
            double average = streamProcessor.getAverage();
            System.out.println(average);
        }
    }
}


