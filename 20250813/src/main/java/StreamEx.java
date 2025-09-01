import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamEx {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("김", "박", "정", "최");
//		for (String str : list) {
//			System.out.println(str);
//		}
		list.stream().forEach((n)->System.out.println(n));
		
		int sum = IntStream.rangeClosed(1, 10).sum();
		
		System.out.println(sum);
		
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
		List<String> items = Arrays.asList("apple","banana","orange","apple");
		long count = items.stream().filter(item->item.equals("apple")).count();
		System.out.println(count);
		
		List<Integer> nums = Arrays.asList(5,1,9,3);
		int max = nums.stream().max((a,b) -> a-b).get();
		System.out.println(max);
	}
}

//람다식을 쓴다는건 인터페이스 구현객체를 만든다.
