/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNegativeNumbers(){
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoFloatNumbers(){
        double resultAdd = mCalculator.add(1.111f,1.111d);
        assertThat(resultAdd,is(closeTo(2.222d,0.01)));
    }

    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powpositivenums(){
        double result = mCalculator.pow(2d,4d);
        assertThat(result,is(equalTo(16d)));
    }
    @Test
    public void powfirstnegative(){
        double result = mCalculator.pow(-2d,3d);
        assertThat(result,is(equalTo(-8d)));
    }
    @Test
    public void powsecondnegative(){
        double result = mCalculator.pow(2d,-1d);
        assertThat(result,is(equalTo(0.5d)));
    }
    @Test
    public void powfirstzero(){
        double result = mCalculator.pow(0d,3d);
        assertThat(result,is(equalTo(0d)));
    }
    @Test
    public void powsecondzero(){
        double result = mCalculator.pow(-2d,0d);
        assertThat(result,is(equalTo(1d)));
    }
    @Test
    public void powfirstzerosecondminus(){
        double result = mCalculator.pow(0d,-3d);
        assertThat(result,is(equalTo(Double.POSITIVE_INFINITY)));
    }
    @Test
    public void powfirstminuszerosecondnegative(){
        double result = mCalculator.pow(-0d,-3d);
        assertThat(result,is(equalTo(Double.NEGATIVE_INFINITY)));
    }
}