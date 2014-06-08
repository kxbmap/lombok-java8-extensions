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

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import static java.util.Objects.requireNonNull;

/**
 * @see lombok.experimental.ExtensionMethod
 */
public class OptionalExtensions {

    // map

    /**
     * map Optional&lt;T&gt; to OptionalInt
     */
    public static <T> OptionalInt mapToInt(Optional<T> opt, ToIntFunction<? super T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.get())) : OptionalInt.empty();
    }

    /**
     * map Optional&lt;T&gt; to OptionalLong
     */
    public static <T> OptionalLong mapToLong(Optional<T> opt, ToLongFunction<? super T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.get())) : OptionalLong.empty();
    }

    /**
     * map Optional&lt;T&gt; to OptionalDouble
     */
    public static <T> OptionalDouble mapToDouble(Optional<T> opt, ToDoubleFunction<? super T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.get())) : OptionalDouble.empty();
    }


    // flatMap

    /**
     * flatMap Optional&lt;T&gt; to OptionalInt
     */
    public static <T> OptionalInt flatMapToInt(Optional<T> opt, Function<? super T, OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.get())) : OptionalInt.empty();
    }

    /**
     * flatMap Optional&lt;T&gt; to OptionalLong
     */
    public static <T> OptionalLong flatMapToLong(Optional<T> opt, Function<? super T, OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.get())) : OptionalLong.empty();
    }

    /**
     * flatMap Optional&lt;T&gt; to OptionalDouble
     */
    public static <T> OptionalDouble flatMapToDouble(Optional<T> opt, Function<? super T, OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.get())) : OptionalDouble.empty();
    }


    // fold

    /**
     * fold Optional&lt;T&gt; to R
     */
    public static <T, R> R fold(Optional<T> opt, Function<? super T, ? extends R> mapper, Supplier<? extends R> other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.apply(opt.get()) : other.get();
    }

    /**
     * fold Optional&lt;T&gt; to int
     */
    public static <T> int foldToInt(Optional<T> opt, ToIntFunction<? super T> mapper, IntSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsInt(opt.get()) : other.getAsInt();
    }

    /**
     * fold Optional&lt;T&gt; to long
     */
    public static <T> long foldToLong(Optional<T> opt, ToLongFunction<? super T> mapper, LongSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsLong(opt.get()) : other.getAsLong();
    }

    /**
     * fold Optional&lt;T&gt; to double
     */
    public static <T> double foldToDouble(Optional<T> opt, ToDoubleFunction<? super T> mapper, DoubleSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsDouble(opt.get()) : other.getAsDouble();
    }


    /**
     *
     */
    public static <T> boolean isAbsent(Optional<T> opt) {
        return !opt.isPresent();
    }

    /**
     *
     */
    public static <T> void ifAbsent(Optional<T> opt, Runnable runnable) {
        if (!opt.isPresent()) {
            runnable.run();
        }
    }

    /**
     *
     */
    public static <T> void consume(Optional<T> opt, Consumer<? super T> consumer, Runnable runnable) {
        if (opt.isPresent()) {
            consumer.accept(opt.get());
        } else {
            runnable.run();
        }
    }

}
