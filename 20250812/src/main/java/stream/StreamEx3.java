package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {
		List<Integer>  numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> filtered = numbers.stream()
				.filter(n -> n%2 ==0)
				.collect(Collectors.toList());
		filtered.stream().forEach(n -> System.out.println(n));
	}

}
