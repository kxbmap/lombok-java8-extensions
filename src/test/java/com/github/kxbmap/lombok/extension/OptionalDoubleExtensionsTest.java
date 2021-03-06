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

@ExtensionMethod(OptionalDoubleExtensions.class)
public class OptionalDoubleExtensionsTest {

    // map

    @Test
    public void mapIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.map(n -> n + 1), is(OptionalDouble.of(43)));
    }

    @Test
    public void mapIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.map(n -> n + 1), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapIfNullMapper() {
        OptionalDouble.empty().map(null);
    }


    @Test
    public void mapToIntIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.mapToInt(n -> (int)(n + 1)), is(OptionalInt.of(43)));
    }

    @Test
    public void mapToIntIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.mapToInt(n -> (int)(n + 1)), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToIntIfNullMapper() {
        OptionalDouble.empty().mapToInt(null);
    }


    @Test
    public void mapToLongIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.mapToLong(n -> (long)(n + 1)), is(OptionalLong.of(43)));
    }

    @Test
    public void mapToLongIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.mapToLong(n -> (long)(n + 1)), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToLongIfNullMapper() {
        OptionalDouble.empty().mapToLong(null);
    }


    @Test
    public void mapToObjIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.mapToObj(n -> n + 1), is(Optional.of(43d)));
    }

    @Test
    public void mapToObjIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.mapToObj(n -> n + 1), is(Optional.empty()));
    }

    @Test
    public void mapToObjIfNullResult() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.mapToObj(n -> null), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToObjIfNullMapper() {
        OptionalDouble.empty().mapToObj(null);
    }


    // flatMap

    @Test
    public void flatMapIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.flatMap(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.of(43)));
    }

    @Test
    public void flatMapIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.flatMap(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapIfNullMapper() {
        OptionalDouble.empty().flatMap(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapIfNullResult() {
        OptionalDouble.of(42).flatMap(n -> null);
    }


    @Test
    public void flatMapToIntIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.flatMapToInt(n -> OptionalInt.of((int)(n + 1))), is(OptionalInt.of(43)));
    }

    @Test
    public void flatMapToIntIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.flatMapToInt(n -> OptionalInt.of((int)(n + 1))), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToIntIfNullMapper() {
        OptionalDouble.empty().flatMapToInt(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToIntIfNullResult() {
        OptionalDouble.of(42).flatMapToInt(n -> null);
    }


    @Test
    public void flatMapToLongIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.flatMapToLong(n -> OptionalLong.of((long)(n + 1))), is(OptionalLong.of(43)));
    }

    @Test
    public void flatMapToLongIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.flatMapToLong(n -> OptionalLong.of((long)(n + 1))), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToLongIfNullMapper() {
        OptionalDouble.empty().flatMapToLong(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToLongIfNullResult() {
        OptionalDouble.of(42).flatMapToLong(n -> null);
    }


    @Test
    public void flatMapToObjIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.flatMapToObj(n -> Optional.of(n + 1)), is(Optional.of(43d)));
    }

    @Test
    public void flatMapToObjIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.flatMapToObj(n -> Optional.of(n + 1)), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToObjIfNullMapper() {
        OptionalDouble.empty().flatMapToObj(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToObjIfNullResult() {
        OptionalDouble.of(42).flatMapToObj(n -> null);
    }


    // fold

    @Test
    public void foldIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.fold(n -> n + 1, () -> 0), is(43d));
    }

    @Test
    public void foldIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.fold(n -> n + 1, () -> 0), is(0d));
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullMapper() {
        OptionalDouble.empty().fold(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullOther() {
        OptionalDouble.of(42).fold(n -> n + 1, null);
    }


    @Test
    public void foldToIntIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.foldToInt(n -> (int)(n + 1), () -> 0), is(43));
    }

    @Test
    public void foldToIntIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.foldToInt(n -> (int)(n + 1), () -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void foldToIntIfNullMapper() {
        OptionalDouble.empty().foldToInt(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToIntIfNullOther() {
        OptionalDouble.of(42).foldToInt(n -> (int)(n + 1), null);
    }


    @Test
    public void foldToLongIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.foldToLong(n -> (long)(n + 1), () -> 0), is(43L));
    }

    @Test
    public void foldToLongIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.foldToLong(n -> (long)(n + 1), () -> 0), is(0L));
    }

    @Test(expected = NullPointerException.class)
    public void foldToLongIfNullMapper() {
        OptionalDouble.empty().foldToLong(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToLongIfNullOther() {
        OptionalDouble.of(42).foldToLong(n -> (long)(n + 1), null);
    }


    @Test
    public void foldToObjIfPresent() {
        OptionalDouble opt = OptionalDouble.of(42);
        assertThat(opt.foldToObj(n -> n + 1, () -> 0d), is(43d));
    }

    @Test
    public void foldToObjIfEmpty() {
        OptionalDouble opt = OptionalDouble.empty();
        assertThat(opt.foldToObj(n -> n + 1, () -> 0d), is(0d));
    }

    @Test(expected = NullPointerException.class)
    public void foldToObjIfNullMapper() {
        OptionalDouble.empty().foldToObj(null, () -> 0d);
    }

    @Test(expected = NullPointerException.class)
    public void foldToObjIfNullOther() {
        OptionalDouble.of(42).foldToObj(n -> n + 1, null);
    }


    // isAbsent

    @Test
    public void isAbsentIfPresent() {
        assertThat(OptionalDouble.of(42).isAbsent(), is(false));
    }

    @Test
    public void isAbsentIfEmpty() {
        assertThat(OptionalDouble.empty().isAbsent(), is(true));
    }


    // ifAbsent

    @Test
    public void ifAbsentIfPresent() {
        OptionalDouble.of(42).ifAbsent(Assert::fail);
    }

    @Test(expected = RuntimeException.class)
    public void ifAbsentIfEmpty() {
        OptionalDouble.empty().ifAbsent(() -> {
            throw new RuntimeException();
        });
        fail();
    }


    // consume

    @Test(expected = RuntimeException.class)
    public void consumeIfPresent() {
        OptionalDouble.of(42).consume(
            n -> {
                assertThat(n, is(42d));
                throw new RuntimeException();
            },
            Assert::fail
        );
    }

    @Test(expected = RuntimeException.class)
    public void consumeIfEmpty() {
        OptionalDouble.empty().consume(
            n -> fail(),
            () -> {
                throw new RuntimeException();
            }
        );
    }

}
