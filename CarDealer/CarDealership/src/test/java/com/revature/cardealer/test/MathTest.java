package com.revature.cardealer.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.extramethods.MathTime;

class MathTest {
	
	private static final MathTime mt = new MathTime();

	@Test
	@DisplayName("Testing Addition Normal Conditions")
	public void AddNorm() {
		int a = 5;
		int b = 10;
		int expected = 15;
		assertEquals(expected, mt.Addition(a, b));
	}
	
	@Test
	@DisplayName("Testing Addition Variable A is negative")
	public void TestAdditionANegative() {
		int a = -2;
		int b = 5;
		int expected = -1;
		assertEquals(expected, mt.Addition(a, b));
	}
	
	@Test
	@DisplayName("Testing Addition Variable B is negative")
	public void TestAdditionBNegative() {
		int a = 2;
		int b = -5;
		int expected = -1;
		assertEquals(expected, mt.Addition(a, b));
	}
	
	@Test
	@DisplayName("Testing Subtraction Normal")
	public void TestNormalSub() {
		int a = 12;
		int b = 5;
		int expected = 7;
		assertEquals(expected, mt.Subtraction(a, b));
	}
	
	@Test
	@DisplayName("Testing Subtraction Variable A is negative")
	public void TestSubANegative() {
		int a = -2;
		int b = 5;
		int expected = -1;
		assertEquals(expected, mt.Subtraction(a, b));
	}
	
	@Test
	@DisplayName("Testing Subtraction Variable B is negative")
	public void TestSubBNegative() {
		int a = 2;
		int b = -5;
		int expected = -1;
		assertEquals(expected, mt.Subtraction(a, b));
	}
	
	@Test
	@DisplayName("Testing Subtraction Where Output is negative")
	public void TestSubNegativeOut() {
		int a = 2;
		int b = 10;
		int expected = -1;
		assertEquals(expected, mt.Subtraction(a, b));
	}
	
	@Test
	@DisplayName("Testing Dividing by 12 Normal Conditions")
	public void Testnorm12() {
		int a = 144;
		int expected = 12;
		assertEquals(expected, mt.DivideBy12(a));
	}
	
	@Test
	@DisplayName("Testing Dividing by 12 input is negative")
	public void Testnorm12neg() {
		int a = -144;
		int expected = -1;
		assertEquals(expected, mt.DivideBy12(a));
	}
}
