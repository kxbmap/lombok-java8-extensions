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

@ExtensionMethod(OptionalIntExtensions.class)
public class OptionalIntExtensionsTest {

    // map

    @Test
    public void mapIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.map(n -> n + 1), is(OptionalInt.of(43)));
    }

    @Test
    public void mapIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.map(n -> n + 1), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapIfNullMapper() {
        OptionalInt.empty().map(null);
    }


    @Test
    public void mapToLongIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.mapToLong(n -> n + 1), is(OptionalLong.of(43)));
    }

    @Test
    public void mapToLongIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.mapToLong(n -> n + 1), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToLongIfNullMapper() {
        OptionalInt.empty().mapToLong(null);
    }


    @Test
    public void mapToDoubleIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.mapToDouble(n -> n + 1), is(OptionalDouble.of(43)));
    }

    @Test
    public void mapToDoubleIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.mapToDouble(n -> n + 1), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToDoubleIfNullMapper() {
        OptionalInt.empty().mapToDouble(null);
    }


    @Test
    public void mapToObjIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.mapToObj(n -> n + 1), is(Optional.of(43)));
    }

    @Test
    public void mapToObjIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.mapToObj(n -> n + 1), is(Optional.empty()));
    }

    @Test
    public void mapToObjIfNullResult() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.mapToObj(n -> null), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToObjIfNullMapper() {
        OptionalInt.empty().mapToObj(null);
    }


    // flatMap

    @Test
    public void flatMapIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.flatMap(n -> OptionalInt.of(n + 1)), is(OptionalInt.of(43)));
    }

    @Test
    public void flatMapIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.flatMap(n -> OptionalInt.of(n + 1)), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapIfNullMapper() {
        OptionalInt.empty().flatMap(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapIfNullResult() {
        OptionalInt.of(42).flatMap(n -> null);
    }


    @Test
    public void flatMapToLongIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.flatMapToLong(n -> OptionalLong.of(n + 1)), is(OptionalLong.of(43)));
    }

    @Test
    public void flatMapToLongIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.flatMapToLong(n -> OptionalLong.of(n + 1)), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToLongIfNullMapper() {
        OptionalInt.empty().flatMapToLong(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToLongIfNullResult() {
        OptionalInt.of(42).flatMapToLong(n -> null);
    }


    @Test
    public void flatMapToDoubleIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.flatMapToDouble(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.of(43)));
    }

    @Test
    public void flatMapToDoubleIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.flatMapToDouble(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToDoubleIfNullMapper() {
        OptionalInt.empty().flatMapToDouble(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToDoubleIfNullResult() {
        OptionalInt.of(42).flatMapToDouble(n -> null);
    }


    @Test
    public void flatMapToObjIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.flatMapToObj(n -> Optional.of(n + 1)), is(Optional.of(43)));
    }

    @Test
    public void flatMapToObjIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.flatMapToObj(n -> Optional.of(n + 1)), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToObjIfNullMapper() {
        OptionalInt.empty().flatMapToObj(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToObjIfNullResult() {
        OptionalInt.of(42).flatMapToObj(n -> null);
    }


    // fold

    @Test
    public void foldIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.fold(n -> n + 1, () -> 0), is(43));
    }

    @Test
    public void foldIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.fold(n -> n + 1, () -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullMapper() {
        OptionalInt.empty().fold(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullOther() {
        OptionalInt.of(42).fold(n -> n + 1, null);
    }


    @Test
    public void foldToLongIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.foldToLong(n -> n + 1, () -> 0), is(43L));
    }

    @Test
    public void foldToLongIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.foldToLong(n -> n + 1, () -> 0), is(0L));
    }

    @Test(expected = NullPointerException.class)
    public void foldToLongIfNullMapper() {
        OptionalInt.empty().foldToLong(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToLongIfNullOther() {
        OptionalInt.of(42).foldToLong(n -> n + 1, null);
    }


    @Test
    public void foldToDoubleIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.foldToDouble(n -> n + 1, () -> 0), is(43d));
    }

    @Test
    public void foldToDoubleIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.foldToDouble(n -> n + 1, () -> 0), is(0d));
    }

    @Test(expected = NullPointerException.class)
    public void foldToDoubleIfNullMapper() {
        OptionalInt.empty().foldToDouble(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToDoubleIfNullOther() {
        OptionalInt.of(42).foldToDouble(n -> n + 1, null);
    }


    @Test
    public void foldToObjIfPresent() {
        OptionalInt opt = OptionalInt.of(42);
        assertThat(opt.foldToObj(n -> n + 1, () -> 0), is(43));
    }

    @Test
    public void foldToObjIfEmpty() {
        OptionalInt opt = OptionalInt.empty();
        assertThat(opt.foldToObj(n -> n + 1, () -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void foldToObjIfNullMapper() {
        OptionalInt.empty().foldToObj(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToObjIfNullOther() {
        OptionalInt.of(42).foldToObj(n -> n + 1, null);
    }


    // isAbsent

    @Test
    public void isAbsentIfPresent() {
        assertThat(OptionalInt.of(42).isAbsent(), is(false));
    }

    @Test
    public void isAbsentIfEmpty() {
        assertThat(OptionalInt.empty().isAbsent(), is(true));
    }


    // ifAbsent

    @Test
    public void ifAbsentIfPresent() {
        OptionalInt.of(42).ifAbsent(Assert::fail);
    }

    @Test(expected = RuntimeException.class)
    public void ifAbsentIfEmpty() {
        OptionalInt.empty().ifAbsent(() -> {
            throw new RuntimeException();
        });
        fail();
    }


    // consume

    @Test(expected = RuntimeException.class)
    public void consumeIfPresent() {
        OptionalInt.of(42).consume(
            n -> { throw new RuntimeException(); },
            Assert::fail
        );
    }

    @Test(expected = RuntimeException.class)
    public void consumeIfEmpty() {
        OptionalInt.empty().consume(
            n -> fail(),
            () -> { throw new RuntimeException(); }
        );
    }

}
