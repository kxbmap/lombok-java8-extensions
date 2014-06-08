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
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * @see lombok.experimental.ExtensionMethod
 */
public class OptionalDoubleExtension {

    // map

    /**
     * map OptionalDouble to OptionalDouble
     */
    public static OptionalDouble map(OptionalDouble opt, DoubleUnaryOperator mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.getAsDouble())) : OptionalDouble.empty();
    }

    /**
     * map OptionalDouble to OptionalInt
     */
    public static OptionalInt mapToInt(OptionalDouble opt, DoubleToIntFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.getAsDouble())) : OptionalInt.empty();
    }

    /**
     * map OptionalDouble to OptionalLong
     */
    public static OptionalLong mapToLong(OptionalDouble opt, DoubleToLongFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.getAsDouble())) : OptionalLong.empty();
    }

    /**
     * map OptionalDouble to Optional&lt;T&gt;
     */
    public static <T> Optional<T> mapToObj(OptionalDouble opt, DoubleFunction<? extends T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? Optional.ofNullable(mapper.apply(opt.getAsDouble())) : Optional.empty();
    }


    // flatMap

    /**
     * flatMap OptionalDouble to OptionalDouble
     */
    public static OptionalDouble flatMap(OptionalDouble opt, DoubleFunction<OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : OptionalDouble.empty();
    }

    /**
     * flatMap OptionalDouble to OptionalInt
     */
    public static OptionalInt flatMapToInt(OptionalDouble opt, DoubleFunction<OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : OptionalInt.empty();
    }

    /**
     * flatMap OptionalDouble to OptionalLong
     */
    public static OptionalLong flatMapToLong(OptionalDouble opt, DoubleFunction<OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : OptionalLong.empty();
    }

    /**
     * flatMap OptionalDouble to Optional&lt;T&gt;
     */
    public static <T> Optional<T> flatMapToObj(OptionalDouble opt, DoubleFunction<Optional<T>> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : Optional.empty();
    }


    // fold

    /**
     * fold OptionalDouble to double
     */
    public static double fold(OptionalDouble opt, DoubleUnaryOperator mapper, DoubleSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsDouble(opt.getAsDouble()) : other.getAsDouble();
    }

    /**
     * fold OptionalDouble to int
     */
    public static int foldToInt(OptionalDouble opt, DoubleToIntFunction mapper, IntSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsInt(opt.getAsDouble()) : other.getAsInt();
    }

    /**
     * fold OptionalDouble to long
     */
    public static long foldToLong(OptionalDouble opt, DoubleToLongFunction mapper, LongSupplier other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.applyAsLong(opt.getAsDouble()) : other.getAsLong();
    }

    /**
     * fold OptionalDouble to T
     */
    public static <T> T foldToObj(OptionalDouble opt, DoubleFunction<? extends T> mapper, Supplier<? extends T> other) {
        requireNonNull(mapper);
        requireNonNull(other);
        return opt.isPresent() ? mapper.apply(opt.getAsDouble()) : other.get();
    }

}
