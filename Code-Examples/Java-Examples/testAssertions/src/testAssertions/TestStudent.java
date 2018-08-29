package testAssertions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestStudent {

	final int idLength = 14083324;
	Student student = null;

	@Before
	public void setUp() throws Exception {
		student = new Student();
	}

	@After
	public void tearDown() throws Exception {
		student = null;
	}

	@Test
	public void testAssertionFailure() {
		assertTrue(false);
	}

	@Test
	public void testException() throws Exception {
		throw new java.io.IOException();
	}

	public void testPi() {
		double pi = 3.14159;
		double myPi = 3.09;
		double delta = 0.04;
		assertEquals("Difference is > ", pi, myPi, delta);
	}

	public void testId() {
		int id = 999_999_999;
		Student student = new Student();
		assertEquals(id, student.generateRandomId());
	}

	@Test
	public void testIdLength() {
		Student student = new Student();

		String expected = "Ross";
		String actual = student.getName();
		assertEquals("Student Name:", actual, expected);
	}

	@RunWith(value = Parameterized.class)
	class IncomeTax {
		private IncomeTax tax = null;
		private double income = 0.0;
		private double expIncomeTax = 0.0;

		public IncomeTax(double income, double expIncomeTax) {
			super();
			this.income = income;
			this.expIncomeTax = expIncomeTax;
		}

		public double calculateIncomeTax(double income) {
			return income;
		}

		@Parameters
		public Collection<Object> data() {
			Object[][] data = new Object[][] { { 0, 0 }, { 1000, 10 } };
			return Arrays.asList(data);
		}
	}
}
