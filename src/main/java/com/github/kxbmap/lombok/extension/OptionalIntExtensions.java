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
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * @see lombok.experimental.ExtensionMethod
 */
public class OptionalIntExtensions {

    // map

    /**
     * map OptionalInt to OptionalInt
     */
    public static OptionalInt map(OptionalInt opt, IntUnaryOperator mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.getAsInt())) : OptionalInt.empty();
    }

    /**
     * map OptionalInt to OptionalLong
     */
    public static OptionalLong mapToLong(OptionalInt opt, IntToLongFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.getAsInt())) : OptionalLong.empty();
    }

    /**
     * map OptionalInt to OptionalDouble
     */
    public static OptionalDouble mapToDouble(OptionalInt opt, IntToDoubleFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.getAsInt())) : OptionalDouble.empty();
    }

    /**
     * map OptionalInt to Optional&lt;T&gt;
     */
    public static <T> Optional<T> mapToObj(OptionalInt opt, IntFunction<? extends T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? Optional.ofNullable(mapper.apply(opt.getAsInt())) : Optional.empty();
    }


    // flatMap

    /**
     * flatMap OptionalInt to OptionalInt
     */
    public static OptionalInt flatMap(OptionalInt opt, IntFunction<OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : OptionalInt.empty();
    }

    /**
     * flatMap OptionalInt to OptionalLong
     */
    public static OptionalLong flatMapToLong(OptionalInt opt, IntFunction<OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : OptionalLong.empty();
    }

    /**
     * flatMap OptionalInt to OptionalDouble
     */
    public static OptionalDouble flatMapToDouble(OptionalInt opt, IntFunction<OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : OptionalDouble.empty();
    }

    /**
     * flatMap OptionalInt to Optional&lt;T&gt;
     */
    public static <T> Optional<T> flatMapToObj(OptionalInt opt, IntFunction<Optional<T>> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : Optional.empty();
    }


    // fold

    /**
     * fold OptionalInt to int
     */
    public static int fold(OptionalInt opt, IntUnaryOperator mapper, IntSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsInt(opt.getAsInt()) : other.getAsInt();
    }

    /**
     * fold OptionalInt to long
     */
    public static long foldToLong(OptionalInt opt, IntToLongFunction mapper, LongSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsLong(opt.getAsInt()) : other.getAsLong();
    }

    /**
     * fold OptionalInt to double
     */
    public static double foldToDouble(OptionalInt opt, IntToDoubleFunction mapper, DoubleSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsDouble(opt.getAsInt()) : other.getAsDouble();
    }

    /**
     * fold OptionalInt to T
     */
    public static <T> T foldToObj(OptionalInt opt, IntFunction<? extends T> mapper, Supplier<? extends T> other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.apply(opt.getAsInt()) : other.get();
    }


    /**
     *
     */
    public static boolean isAbsent(OptionalInt opt) {
        return !opt.isPresent();
    }

    /**
     *
     */
    public static void ifAbsent(OptionalInt opt, Runnable runnable) {
        if (!opt.isPresent()) {
            runnable.run();
        }
    }

    /**
     *
     */
    public static void consume(OptionalInt opt, IntConsumer consumer, Runnable runnable) {
        if (opt.isPresent()) {
            consumer.accept(opt.getAsInt());
        } else {
            runnable.run();
        }
    }

}
