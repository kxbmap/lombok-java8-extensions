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

}
