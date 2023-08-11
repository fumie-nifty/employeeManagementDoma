package jp.co.flm;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SampleBatch {

	@Scheduled(cron="${scheduler.cron}")
	public void task4() {
        System.out.println("task");
    }
}
