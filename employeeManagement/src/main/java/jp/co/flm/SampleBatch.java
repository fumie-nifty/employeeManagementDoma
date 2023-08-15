/**
 * SampleBatch.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * SampleBatchクラス
 * @author kuga
 * @version 1.0 2023/08/12
 */
@Component
public class SampleBatch {

	@Scheduled(cron="${scheduler.cron}")
	public void task4() {
        System.out.println("task");
    }
}
