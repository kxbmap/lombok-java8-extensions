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
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ExtensionMethod(OptionalExtensions.class)
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

}
