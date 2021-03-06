/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package streams.api.examples;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	private final Stream<Order> orders;

	public App(Stream<Order> orders) {
		this.orders = orders;
	}

	public Map<String, BigDecimal> sumOfTheOrdersByCustomer() {
		Map<String, BigDecimal> sumMap = orders
				.collect(Collectors.groupingBy(Order::getEmail, Collectors.reducing(BigDecimal.ZERO, Order::getAmount, BigDecimal::add)));
		return sumMap;
	}
}
