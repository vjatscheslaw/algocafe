package algos.recursion;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursiveFunctionsTests {

	@Test
	public void fibbonacchiTest() {
		int input = 9;
		int factorial = RecursiveFunctions.factorial(input);
		Assertions.assertEquals(362880, factorial);
	}

	@Test
	public void fibbonacciComparativeTest() {
		LocalDateTime start = LocalDateTime.now();

		Assertions.assertEquals(483944808890094715L, new RecursiveFunctions.Fibbonacci().iterativeFibbonacci(4000));
		LocalDateTime finish = LocalDateTime.now();
		System.out.println("Iterative Fibbonacci from book took " + Duration.between(start, finish).toMillis() + " millis");
		start = LocalDateTime.now();
		Assertions.assertEquals(483944808890094715L, new RecursiveFunctions.Fibbonacci().recursiveFibbonacciWithMemoization(4000));
		finish = LocalDateTime.now();
		System.out.println("Recursive Fibbonacci with memoization took " + Duration.between(start, finish).toMillis() + " millis");
		start = LocalDateTime.now();
		Assertions.assertEquals(102334155L, new RecursiveFunctions.Fibbonacci().recursiveFibbonacci(40));
		finish = LocalDateTime.now();
		System.out.println("Recursive Fibbonacci took " + Duration.between(start, finish).toMillis() + " millis");


		System.out.println("Num: " + (1 << 6));
		System.out.println("Num: " + 0x0f);
	}

	@Test
	public void recursiveFibbonacciTest() {
		Assertions.assertEquals(8L, new RecursiveFunctions.Fibbonacci().recursiveFibbonacci(6));
		LongStream fibStream = new RecursiveFunctions.FibbonacciStream().stream();
		fibStream.limit(16).forEach(System.out::println);
	}

	@Test
	public void triangleNumberTest() {
		for (int i = 1; i < 45; i++) System.out.print(RecursiveFunctions.triangleNumberRecursive(i) + " ");
		System.out.println();
		for (int i = 1; i < 45; i++) System.out.print(RecursiveFunctions.triangleNumber(i) + " ");
	}
	
	@Test
	void factorialArraysParrallelTest() {
		double[] array = new double[9];
		Arrays.parallelSetAll(array, i -> i + 1);
		for (int n = 0; n < array.length; n++) Assertions.assertEquals(n + 1, array[n]);
		Arrays.parallelPrefix(array, (x1, x2) -> x1 * x2);
		for (double d : array) System.out.println(d + " ");
		for (int n = 0; n < array.length; n++) Assertions.assertEquals(array[n], RecursiveFunctions.factorial(n + 1));
		
	}
}