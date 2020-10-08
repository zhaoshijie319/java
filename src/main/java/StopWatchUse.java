
import org.springframework.util.StopWatch;

public class StopWatchUse {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("任务一");
        System.out.println("\ncurrentTaskName:\t" + stopWatch.currentTaskName() +
                "\ngetId\t" + stopWatch.getId() + "\nprettyPrint\t" + stopWatch.prettyPrint());
        stopWatch.stop();
        stopWatch.start("\n任务二\t");
        System.out.println("shortSummary" + stopWatch.shortSummary() + "getTaskInfo" + stopWatch.getTaskInfo()
                + "getLastTaskName" + stopWatch.getLastTaskName());
        stopWatch.stop();
        System.out.println("getTotalTimeMillis" + stopWatch.getTotalTimeMillis() + "getLastTaskInfo" + stopWatch.getLastTaskInfo()
                + "isRunning" + stopWatch.isRunning());

    }
}
