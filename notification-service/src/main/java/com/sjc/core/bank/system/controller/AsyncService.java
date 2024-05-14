package com.sjc.core.bank.system.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async("asyncTaskExecutor")
	public void doAction() throws InterruptedException {
		Thread.sleep(4000L);
		System.out.println("Done");
	}

	public void multiOperation() {

		final CompletableFuture<Integer> service1 = CompletableFuture.supplyAsync(() -> slowService(1));
		final CompletableFuture<Integer> service2 = CompletableFuture.supplyAsync(() -> slowService(2));
		final CompletableFuture<Integer> service3 = CompletableFuture.supplyAsync(() -> slowService(3));

		CompletableFuture.allOf(service1, service2, service3).join();
	}

	private static Integer slowService(final int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return i;
	}
}