/*
 * Copyright 2014 Tsukasa Kitachi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.kxbmap.lombok.extension;

import lombok.experimental.ExtensionMethod;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@ExtensionMethod(FutureExtensions.class)
public class FutureExtensionsTest {

    private static Thread executorThread;
    private static ExecutorService executor;

    @BeforeClass
    public static void setupExecutor() throws Exception {
        executor = Executors.newSingleThreadExecutor(r -> {
            executorThread = new Thread(r);
            return executorThread;
        });
    }

    @AfterClass
    public static void shutdownExecutor() throws Exception {
        executor.shutdown();
        executor = null;
        executorThread = null;
    }

    @Test
    public void exceptionallyFuture() throws Exception {
        Exception ex = new Exception();
        CompletableFuture<Object> f = FutureExtensions.exceptionallyFuture(ex);
        try {
            f.get();
            fail();
        } catch (ExecutionException e) {
            assertThat(e.getCause(), is(ex));
        }
    }

    @Test
    public void completeWith() throws Exception {
        CompletableFuture<Integer> f = CompletableFuture.completedFuture(42);
        AtomicReference<Thread> thread = new AtomicReference<>();

        CompletableFuture<Integer> g = f.whenComplete(
            n -> thread.set(Thread.currentThread()),
            e -> fail()
        );

        assertThat(g.get(), is(42));
        assertThat(thread.get(), is(Thread.currentThread()));
    }

    @Test
    public void completeWithIfExceptionally() throws Exception {
        CompletableFuture<Integer> f = new CompletableFuture<>();
        Exception ex = new Exception();
        f.completeExceptionally(ex);

        AtomicReference<Thread> thread = new AtomicReference<>();

        CompletableFuture<Integer> g = f.whenComplete(
            n -> fail(),
            e -> thread.set(Thread.currentThread())
        );

        try {
            g.get();
            fail();
        } catch (ExecutionException e) {
            assertThat(e.getCause(), is(ex));
        }
        assertThat(thread.get(), is(Thread.currentThread()));
    }

    @Test
    public void completeWithAsync() throws Exception {
        CompletableFuture<Integer> f = CompletableFuture.completedFuture(42);
        AtomicReference<Thread> thread = new AtomicReference<>();

        CompletableFuture<Integer> g = f.whenCompleteAsync(
            n -> thread.set(Thread.currentThread()),
            e -> fail()
        );

        assertThat(g.get(), is(42));
        assertThat(thread.get(), is(not(Thread.currentThread())));
    }

    @Test
    public void completeWithAsyncIfExceptionally() throws Exception {
        CompletableFuture<Integer> f = new CompletableFuture<>();
        Exception ex = new Exception();
        f.completeExceptionally(ex);

        AtomicReference<Thread> thread = new AtomicReference<>();

        CompletableFuture<Integer> g = f.whenCompleteAsync(
            n -> fail(),
            e -> thread.set(Thread.currentThread())
        );

        try {
            g.get();
            fail();
        } catch (ExecutionException e) {
            assertThat(e.getCause(), is(ex));
        }
        assertThat(thread.get(), is(not(Thread.currentThread())));
    }

    @Test
    public void completeWithAsyncWithExecutor() throws Exception {
        CompletableFuture<Integer> f = CompletableFuture.completedFuture(42);
        AtomicReference<Thread> thread = new AtomicReference<>();

        CompletableFuture<Integer> g = f.whenCompleteAsync(
            n -> thread.set(Thread.currentThread()),
            e -> fail(),
            executor
        );

        assertThat(g.get(), is(42));
        assertThat(thread.get(), is(executorThread));
    }

    @Test
    public void completeWithAsyncWithExecutorIfExceptionally() throws Exception {
        CompletableFuture<Integer> f = new CompletableFuture<>();
        Exception ex = new Exception();
        f.completeExceptionally(ex);

        AtomicReference<Thread> thread = new AtomicReference<>();

        CompletableFuture<Integer> g = f.whenCompleteAsync(
            n -> fail(),
            e -> thread.set(Thread.currentThread()),
            executor
        );

        try {
            g.get();
            fail();
        } catch (ExecutionException e) {
            assertThat(e.getCause(), is(ex));
        }
        assertThat(thread.get(), is(executorThread));
    }

}
