package com.github.kxbmap.lombok.extension;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import static java.util.Objects.requireNonNull;

/**
 * @see lombok.experimental.ExtensionMethod
 */
public class OptionalExtensions {

    // Optional<T> map

    /**
     * map Optional&lt;T&gt; -> OptionalInt
     */
    public static <T> OptionalInt mapToInt(Optional<T> opt, ToIntFunction<T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.get())) : OptionalInt.empty();
    }

    /**
     * map Optional&lt;T&gt; -> OptionalLong
     */
    public static <T> OptionalLong mapToLong(Optional<T> opt, ToLongFunction<T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.get())) : OptionalLong.empty();
    }

    /**
     * map Optional&lt;T&gt; -> OptionalDouble
     */
    public static <T> OptionalDouble mapToDouble(Optional<T> opt, ToDoubleFunction<T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.get())) : OptionalDouble.empty();
    }


    // OptionalInt map

    /**
     * map OptionalInt -> OptionalInt
     */
    public static OptionalInt map(OptionalInt opt, IntUnaryOperator mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.getAsInt())) : OptionalInt.empty();
    }

    /**
     * map OptionalInt -> OptionalLong
     */
    public static OptionalLong mapToLong(OptionalInt opt, IntToLongFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.getAsInt())) : OptionalLong.empty();
    }

    /**
     * map OptionalInt -> OptionalDouble
     */
    public static OptionalDouble mapToDouble(OptionalInt opt, IntToDoubleFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.getAsInt())) : OptionalDouble.empty();
    }

    /**
     * map OptionalInt -> Optional&lt;T&gt;
     */
    public static <T> Optional<T> mapToObj(OptionalInt opt, IntFunction<T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? Optional.ofNullable(mapper.apply(opt.getAsInt())) : Optional.empty();
    }


    // OptionalLong map

    /**
     * map OptionalLong -> OptionalLong
     */
    public static OptionalLong map(OptionalLong opt, LongUnaryOperator mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.getAsLong())) : OptionalLong.empty();
    }

    /**
     * map OptionalLong -> OptionalInt
     */
    public static OptionalInt mapToInt(OptionalLong opt, LongToIntFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.getAsLong())) : OptionalInt.empty();
    }

    /**
     * map OptionalLong -> OptionalDouble
     */
    public static OptionalDouble mapToDouble(OptionalLong opt, LongToDoubleFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.getAsLong())) : OptionalDouble.empty();
    }

    /**
     * map OptionalLong -> Optional&lt;T&gt;
     */
    public static <T> Optional<T> mapToObj(OptionalLong opt, LongFunction<T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? Optional.ofNullable(mapper.apply(opt.getAsLong())) : Optional.empty();
    }


    // OptionalDouble map

    /**
     * map OptionalDouble -> OptionalDouble
     */
    public static OptionalDouble map(OptionalDouble opt, DoubleUnaryOperator mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalDouble.of(mapper.applyAsDouble(opt.getAsDouble())) : OptionalDouble.empty();
    }

    /**
     * map OptionalDouble -> OptionalInt
     */
    public static OptionalInt mapToInt(OptionalDouble opt, DoubleToIntFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalInt.of(mapper.applyAsInt(opt.getAsDouble())) : OptionalInt.empty();
    }

    /**
     * map OptionalDouble -> OptionalLong
     */
    public static OptionalLong mapToLong(OptionalDouble opt, DoubleToLongFunction mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? OptionalLong.of(mapper.applyAsLong(opt.getAsDouble())) : OptionalLong.empty();
    }

    /**
     * map OptionalDouble -> Optional&lt;T&gt;
     */
    public static <T> Optional<T> mapToObj(OptionalDouble opt, DoubleFunction<T> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? Optional.ofNullable(mapper.apply(opt.getAsDouble())) : Optional.empty();
    }


    // Optional<T> flatMap

    /**
     * flatMap Optional&lt;T&gt; -> OptionalInt
     */
    public static <T> OptionalInt flatMapToInt(Optional<T> opt, Function<T, OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.get())) : OptionalInt.empty();
    }

    /**
     * flatMap Optional&lt;T&gt; -> OptionalLong
     */
    public static <T> OptionalLong flatMapToLong(Optional<T> opt, Function<T, OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.get())) : OptionalLong.empty();
    }

    /**
     * flatMap Optional&lt;T&gt; -> OptionalDouble
     */
    public static <T> OptionalDouble flatMapToDouble(Optional<T> opt, Function<T, OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.get())) : OptionalDouble.empty();
    }


    // OptionalInt flatMap

    /**
     * flatMap OptionalInt -> OptionalInt
     */
    public static OptionalInt flatMap(OptionalInt opt, IntFunction<OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : OptionalInt.empty();
    }

    /**
     * flatMap OptionalInt -> OptionalLong
     */
    public static OptionalLong flatMapToLong(OptionalInt opt, IntFunction<OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : OptionalLong.empty();
    }

    /**
     * flatMap OptionalInt -> OptionalDouble
     */
    public static OptionalDouble flatMapToDouble(OptionalInt opt, IntFunction<OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : OptionalDouble.empty();
    }

    /**
     * flatMap OptionalInt -> Optional&lt;T&gt;
     */
    public static <T> Optional<T> flatMapToObj(OptionalInt opt, IntFunction<Optional<T>> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsInt())) : Optional.empty();
    }


    // OptionalLong flatMap

    /**
     * flatMap OptionalLong -> OptionalLong
     */
    public static OptionalLong flatMap(OptionalLong opt, LongFunction<OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : OptionalLong.empty();
    }

    /**
     * flatMap OptionalLong -> OptionalInt
     */
    public static OptionalInt flatMapToInt(OptionalLong opt, LongFunction<OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : OptionalInt.empty();
    }

    /**
     * flatMap OptionalLong -> OptionalDouble
     */
    public static OptionalDouble flatMapToDouble(OptionalLong opt, LongFunction<OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : OptionalDouble.empty();
    }

    /**
     * flatMap OptionalLong -> Optional&lt;T&gt;
     */
    public static <T> Optional<T> flatMapToObj(OptionalLong opt, LongFunction<Optional<T>> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsLong())) : Optional.empty();
    }


    // OptionalDouble flatMap

    /**
     * flatMap OptionalDouble -> OptionalDouble
     */
    public static OptionalDouble flatMap(OptionalDouble opt, DoubleFunction<OptionalDouble> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : OptionalDouble.empty();
    }

    /**
     * flatMap OptionalDouble -> OptionalInt
     */
    public static OptionalInt flatMapToInt(OptionalDouble opt, DoubleFunction<OptionalInt> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : OptionalInt.empty();
    }

    /**
     * flatMap OptionalDouble -> OptionalLong
     */
    public static OptionalLong flatMapToLong(OptionalDouble opt, DoubleFunction<OptionalLong> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : OptionalLong.empty();
    }

    /**
     * flatMap OptionalDouble -> Optional&lt;T&gt;
     */
    public static <T> Optional<T> flatMapToObj(OptionalDouble opt, DoubleFunction<Optional<T>> mapper) {
        requireNonNull(mapper);
        return opt.isPresent() ? requireNonNull(mapper.apply(opt.getAsDouble())) : Optional.empty();
    }

}