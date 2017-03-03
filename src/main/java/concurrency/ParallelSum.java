package concurrency;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;

import java.io.File;
import java.util.concurrent.*;

public class ParallelSum {

    public int sum(File file) throws Exception {
        ImmutableList<String> lines = ImmutableList.copyOf(Files.readLines(file, Charsets.UTF_8));
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<Integer> numberOfLeftCurlyBrace = threadPool.submit(() -> count(lines, "{"));
        Future<Integer> numberOfRightCurlyBrace = threadPool.submit(() -> count(lines, "}"));

        return numberOfLeftCurlyBrace.get() + numberOfRightCurlyBrace.get();
    }

    public int sumWithLambda(File file) throws Exception {
        ImmutableList<String> lines = ImmutableList.copyOf(Files.readLines(file, Charsets.UTF_8));
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<Integer> numberOfLeftCurlyBrace = threadPool.submit(() -> count(lines, "{"));
        Future<Integer> numberOfRightCurlyBrace = threadPool.submit(() -> count(lines, "}"));

        return numberOfLeftCurlyBrace.get() + numberOfRightCurlyBrace.get();
    }

    public int sumWithMoreLambda(File file) throws Exception {
        return Files.readLines(file, Charsets.UTF_8)
                .parallelStream()
                .mapToInt(line -> count(line, "{") + count(line, "}"))
                .sum();
    }

    private int count(ImmutableList<String> lines, String substring) {
        int times = 0;
        for (String line: lines) {
            times += count(line, substring);
        }
        return times;
    }

    private int count(String singleLine, String substring) {
        if (singleLine.contains(substring)) {
            return 1;
        }
        return 0;
    }
}
