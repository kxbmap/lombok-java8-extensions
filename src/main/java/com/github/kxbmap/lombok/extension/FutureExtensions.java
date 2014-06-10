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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @see lombok.experimental.ExtensionMethod
 */
public class FutureExtensions {

    public static <T> CompletableFuture<T> exceptionallyFuture(Throwable ex) {
        CompletableFuture<T> future = new CompletableFuture<>();
        future.completeExceptionally(ex);
        return future;
    }

    public static <T> CompletableFuture<T> whenComplete(CompletableFuture<T> future,
                                                        Consumer<? super T> onSuccess,
                                                        Consumer<? super Throwable> onFailure) {
        return future.whenComplete(whenCompleteAction(onSuccess, onFailure));
    }

    public static <T> CompletableFuture<T> whenCompleteAsync(CompletableFuture<T> future,
                                                             Consumer<? super T> onSuccess,
                                                             Consumer<? super Throwable> onFailure) {
        return future.whenCompleteAsync(whenCompleteAction(onSuccess, onFailure));
    }

    public static <T> CompletableFuture<T> whenCompleteAsync(CompletableFuture<T> future,
                                                             Consumer<? super T> onSuccess,
                                                             Consumer<? super Throwable> onFailure,
                                                             Executor executor) {
        return future.whenCompleteAsync(whenCompleteAction(onSuccess, onFailure), executor);
    }

    private static <T> BiConsumer<T, Throwable> whenCompleteAction(Consumer<? super T> onSuccess,
                                                                   Consumer<? super Throwable> onFailure) {
        return (t, e) -> {
            if (e == null) {
                onSuccess.accept(t);
            } else {
                onFailure.accept(e);
            }
        };
    }

}
