package com.github.kxbmap.lombok.extension;

import lombok.experimental.ExtensionMethod;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@ExtensionMethod(OptionalExtensions.class)
public class OptionalExtensionsTest {

    // map

    @Test
    public void mapToIntIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.mapToInt(n -> n + 1), is(OptionalInt.of(43)));
    }

    @Test
    public void mapToIntIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.mapToInt(n -> n + 1), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToIntIfNullMapper() {
        Optional.empty().mapToInt(null);
    }


    @Test
    public void mapToLongIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.mapToLong(n -> n + 1), is(OptionalLong.of(43)));
    }

    @Test
    public void mapToLongIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.mapToLong(n -> n + 1), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToLongIfNullMapper() {
        Optional.empty().mapToLong(null);
    }


    @Test
    public void mapToDoubleIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.mapToDouble(n -> n + 1), is(OptionalDouble.of(43)));
    }

    @Test
    public void mapToDoubleIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.mapToDouble(n -> n + 1), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToDoubleIfNullMapper() {
        Optional.empty().mapToDouble(null);
    }


    // flatMap

    @Test
    public void flatMapToIntIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.flatMapToInt(n -> OptionalInt.of(n + 1)), is(OptionalInt.of(43)));
    }

    @Test
    public void flatMapToIntIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.flatMapToInt(n -> OptionalInt.of(n + 1)), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToIntIfNullMapper() {
        Optional.empty().flatMapToInt(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToIntIfNullResult() {
        Optional.of(42).flatMapToInt(n -> null);
    }


    @Test
    public void flatMapToLongIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.flatMapToLong(n -> OptionalLong.of(n + 1)), is(OptionalLong.of(43)));
    }

    @Test
    public void flatMapToLongIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.flatMapToLong(n -> OptionalLong.of(n + 1)), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToLongIfNullMapper() {
        Optional.empty().flatMapToLong(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToLongIfNullResult() {
        Optional.of(42).flatMapToLong(n -> null);
    }


    @Test
    public void flatMapToDoubleIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.flatMapToDouble(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.of(43)));
    }

    @Test
    public void flatMapToDoubleIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.flatMapToDouble(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToDoubleIfNullMapper() {
        Optional.empty().flatMapToDouble(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToDoubleIfNullResult() {
        Optional.of(42).flatMapToDouble(n -> null);
    }

}
