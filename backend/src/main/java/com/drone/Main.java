package com.drone;

import java.net.UnknownHostException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

public class Main {

	static AnnotationConfigApplicationContext applicationContext = null;

	@Configuration
	public static class DroneClientConfiguration {

		@Bean
		TaskExecutor taskExecutor() {
			return new SimpleAsyncTaskExecutor();
		}

		@Bean
		DroneTemplate provideDroneTemplate(TaskExecutor taskExecutor)
				throws UnknownHostException {
			DroneStateChangeCallback listener = latestState -> {
				System.out.println("altitude: " + latestState.getAltitude());
			};
			return new DroneTemplate(taskExecutor, listener);
		}
	}

	public static void main(String[] args) throws Throwable {
		applicationContext = new AnnotationConfigApplicationContext(
				DroneClientConfiguration.class);
		applicationContext.start();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		applicationContext.close();
	}
}
