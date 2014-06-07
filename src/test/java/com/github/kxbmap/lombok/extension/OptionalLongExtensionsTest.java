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

@ExtensionMethod(OptionalLongExtensions.class)
public class OptionalLongExtensionsTest {

    // map

    @Test
    public void mapIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.map(n -> n + 1), is(OptionalLong.of(43)));
    }

    @Test
    public void mapIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.map(n -> n + 1), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapIfNullMapper() {
        OptionalLong.empty().map(null);
    }


    @Test
    public void mapToIntIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.mapToInt(n -> (int)(n + 1)), is(OptionalInt.of(43)));
    }

    @Test
    public void mapToIntIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.mapToInt(n -> (int)(n + 1)), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToIntIfNullMapper() {
        OptionalLong.empty().mapToInt(null);
    }


    @Test
    public void mapToDoubleIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.mapToDouble(n -> n + 1), is(OptionalDouble.of(43)));
    }

    @Test
    public void mapToDoubleIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.mapToDouble(n -> n + 1), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToDoubleIfNullMapper() {
        OptionalLong.empty().mapToDouble(null);
    }


    @Test
    public void mapToObjIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.mapToObj(n -> n + 1), is(Optional.of(43L)));
    }

    @Test
    public void mapToObjIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.mapToObj(n -> n + 1), is(Optional.empty()));
    }

    @Test
    public void mapToObjIfNullResult() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.mapToObj(n -> null), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void mapToObjIfNullMapper() {
        OptionalLong.empty().mapToObj(null);
    }


    // flatMap

    @Test
    public void flatMapIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.flatMap(n -> OptionalLong.of(n + 1)), is(OptionalLong.of(43)));
    }

    @Test
    public void flatMapIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.flatMap(n -> OptionalLong.of(n + 1)), is(OptionalLong.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapIfNullMapper() {
        OptionalLong.empty().flatMap(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapIfNullResult() {
        OptionalLong.of(42).flatMap(n -> null);
    }


    @Test
    public void flatMapToIntIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.flatMapToInt(n -> OptionalInt.of((int)(n + 1))), is(OptionalInt.of(43)));
    }

    @Test
    public void flatMapToIntIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.flatMapToInt(n -> OptionalInt.of((int)(n + 1))), is(OptionalInt.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToIntIfNullMapper() {
        OptionalLong.empty().flatMapToInt(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToIntIfNullResult() {
        OptionalLong.of(42).flatMapToInt(n -> null);
    }


    @Test
    public void flatMapToDoubleIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.flatMapToDouble(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.of(43)));
    }

    @Test
    public void flatMapToDoubleIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.flatMapToDouble(n -> OptionalDouble.of(n + 1)), is(OptionalDouble.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToDoubleIfNullMapper() {
        OptionalLong.empty().flatMapToDouble(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToDoubleIfNullResult() {
        OptionalLong.of(42).flatMapToDouble(n -> null);
    }


    @Test
    public void flatMapToObjIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.flatMapToObj(n -> Optional.of(n + 1)), is(Optional.of(43L)));
    }

    @Test
    public void flatMapToObjIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.flatMapToObj(n -> Optional.of(n + 1)), is(Optional.empty()));
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToObjIfNullMapper() {
        OptionalLong.empty().flatMapToObj(null);
    }

    @Test(expected = NullPointerException.class)
    public void flatMapToObjIfNullResult() {
        OptionalLong.of(42).flatMapToObj(n -> null);
    }


    // fold

    @Test
    public void foldIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.fold(n -> n + 1, () -> 0), is(43L));
    }

    @Test
    public void foldIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.fold(n -> n + 1, () -> 0), is(0L));
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullMapper() {
        OptionalLong.empty().fold(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldIfNullOther() {
        OptionalLong.of(42).fold(n -> n + 1, null);
    }


    @Test
    public void foldToIntIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.foldToInt(n -> (int)(n + 1), () -> 0), is(43));
    }

    @Test
    public void foldToIntIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.foldToInt(n -> (int)(n + 1), () -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void foldToIntIfNullMapper() {
        OptionalLong.empty().foldToInt(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToIntIfNullOther() {
        OptionalLong.of(42).foldToInt(n -> (int)(n + 1), null);
    }


    @Test
    public void foldToDoubleIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.foldToDouble(n -> n + 1, () -> 0), is(43d));
    }

    @Test
    public void foldToDoubleIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.foldToDouble(n -> n + 1, () -> 0), is(0d));
    }

    @Test(expected = NullPointerException.class)
    public void foldToDoubleIfNullMapper() {
        OptionalLong.empty().foldToDouble(null, () -> 0);
    }

    @Test(expected = NullPointerException.class)
    public void foldToDoubleIfNullOther() {
        OptionalLong.of(42).foldToDouble(n -> n + 1, null);
    }


    @Test
    public void foldToObjIfPresent() {
        OptionalLong opt = OptionalLong.of(42);
        assertThat(opt.foldToObj(n -> n + 1, () -> 0L), is(43L));
    }

    @Test
    public void foldToObjIfEmpty() {
        OptionalLong opt = OptionalLong.empty();
        assertThat(opt.foldToObj(n -> n + 1, () -> 0L), is(0L));
    }

    @Test(expected = NullPointerException.class)
    public void foldToObjIfNullMapper() {
        OptionalLong.empty().foldToObj(null, () -> 0L);
    }

    @Test(expected = NullPointerException.class)
    public void foldToObjIfNullOther() {
        OptionalLong.of(42).foldToObj(n -> n + 1, null);
    }

}
