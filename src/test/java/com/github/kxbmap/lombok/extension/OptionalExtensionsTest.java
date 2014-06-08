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
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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


    // fold

    @Test
    public void foldIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.fold(n -> n + 1, () -> 0), is(43));
    }

    @Test
    public void foldIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.fold(n -> n + 1, () -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullMapper() {
        Optional.empty().fold(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullOther() {
        Optional.of(42).fold(n -> n + 1, null);
    }


    @Test
    public void foldToIntIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.foldToInt(n -> n + 1, () -> 0), is(43));
    }

    @Test
    public void foldToIntIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.foldToInt(n -> n + 1, () -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void foldToIntIfNullMapper() {
        Optional.empty().foldToInt(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToIntIfNullOther() {
        Optional.of(42).foldToInt(n -> n + 1, null);
    }


    @Test
    public void foldToLongIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.foldToLong(n -> n + 1, () -> 0), is(43L));
    }

    @Test
    public void foldToLongIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.foldToLong(n -> n + 1, () -> 0), is(0L));
    }

    @Test(expected = NullPointerException.class)
    public void foldToLongIfNullMapper() {
        Optional.empty().foldToLong(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToLongIfNullOther() {
        Optional.of(42).foldToLong(n -> n + 1, null);
    }


    @Test
    public void foldToDoubleIfPresent() {
        Optional<Integer> opt = Optional.of(42);
        assertThat(opt.foldToDouble(n -> n + 1, () -> 0), is(43d));
    }

    @Test
    public void foldToDoubleIfEmpty() {
        Optional<Integer> opt = Optional.empty();
        assertThat(opt.foldToDouble(n -> n + 1, () -> 0), is(0d));
    }

    @Test(expected = NullPointerException.class)
    public void foldToDoubleIfNullMapper() {
        Optional.empty().foldToDouble(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToDoubleIfNullOther() {
        Optional.of(42).foldToDouble(n -> n + 1, null);
    }


    // isAbsent

    @Test
    public void isAbsentIfPresent() {
        assertThat(Optional.of(42).isAbsent(), is(false));
    }

    @Test
    public void isAbsentIfEmpty() {
        assertThat(Optional.empty().isAbsent(), is(true));
    }


    // ifAbsent

    @Test
    public void ifAbsentIfPresent() {
        Optional.of(42).ifAbsent(Assert::fail);
    }

    @Test(expected = RuntimeException.class)
    public void ifAbsentIfEmpty() {
        Optional.empty().ifAbsent(() -> {
            throw new RuntimeException();
        });
        fail();
    }


    // consume

    @Test(expected = RuntimeException.class)
    public void consumeIfPresent() {
        Optional.of(42).consume(
            n -> { throw new RuntimeException(); },
            Assert::fail
        );
    }

    @Test(expected = RuntimeException.class)
    public void consumeIfEmpty() {
        Optional.empty().consume(
            n -> fail(),
            () -> { throw new RuntimeException(); }
        );
    }

}
