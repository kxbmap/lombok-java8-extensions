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
import java.util.function.IntSupplier;
import java.util.function.LongFunction;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * @see lombok.experimental.ExtensionMethod
 */
public class OptionalLongExtensions {

    // map

    /**
     * map OptionalLong to OptionalLong
     */
    public static OptionalLong map(OptionalLong opt, LongUnaryOperator mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.getAsLong())) : OptionalLong.empty();
    }

    /**
     * map OptionalLong to OptionalInt
     */
    public static OptionalInt mapToInt(OptionalLong opt, LongToIntFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.getAsLong())) : OptionalInt.empty();
    }

    /**
     * map OptionalLong to OptionalDouble
     */
    public static OptionalDouble mapToDouble(OptionalLong opt, LongToDoubleFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.getAsLong())) : OptionalDouble.empty();
    }

    /**
     * map OptionalLong to Optional&lt;T&gt;
     */
    public static <T> Optional<T> mapToObj(OptionalLong opt, LongFunction<? extends T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? Optional.ofNullable(mapper.apply(opt.getAsLong())) : Optional.empty();
    }


    // flatMap

    /**
     * flatMap OptionalLong to OptionalLong
     */
    public static OptionalLong flatMap(OptionalLong opt, LongFunction<OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : OptionalLong.empty();
    }

    /**
     * flatMap OptionalLong to OptionalInt
     */
    public static OptionalInt flatMapToInt(OptionalLong opt, LongFunction<OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : OptionalInt.empty();
    }

    /**
     * flatMap OptionalLong to OptionalDouble
     */
    public static OptionalDouble flatMapToDouble(OptionalLong opt, LongFunction<OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : OptionalDouble.empty();
    }

    /**
     * flatMap OptionalLong to Optional&lt;T&gt;
     */
    public static <T> Optional<T> flatMapToObj(OptionalLong opt, LongFunction<Optional<T>> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : Optional.empty();
    }


    // fold

    /**
     * fold OptionalLong to long
     */
    public static long fold(OptionalLong opt, LongUnaryOperator mapper, LongSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsLong(opt.getAsLong()) : other.getAsLong();
    }

    /**
     * fold OptionalLong to int
     */
    public static int foldToInt(OptionalLong opt, LongToIntFunction mapper, IntSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsInt(opt.getAsLong()) : other.getAsInt();
    }

    /**
     * fold OptionalLong to double
     */
    public static double foldToDouble(OptionalLong opt, LongToDoubleFunction mapper, DoubleSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsDouble(opt.getAsLong()) : other.getAsDouble();
    }

    /**
     * fold OptionalLong to T
     */
    public static <T> T foldToObj(OptionalLong opt, LongFunction<? extends T> mapper, Supplier<? extends T> other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.apply(opt.getAsLong()) : other.get();
    }

}
