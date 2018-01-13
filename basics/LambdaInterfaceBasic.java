import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaInterfaceBasic {

	/**
	 * RxAndroid를 사용하는 것을 보면 java의 Functional Interface를 받아 사용하는 것을 알 수 있다
	 */
	public void run() {
		/**
		 * 단항 인터페이스
		 */
		// 1. Supplier : 입력값이 없고, 반환값이 있을 때 사용
		Supplier<Integer> supplier = ()->180 +20;
		System.out.println(supplier.get());
		// 2. Consumer : 입력값이 있고, 반환값이 없을 때 사용
		//				 코드블럭에서 사용처리가 되어야 한다
		Consumer<Integer> consumer = System.out::println;
		consumer.accept(100);
		// 3. Function : 입력값도 있고, 반환값도 있다
		//				  입력값과 반환값의 타입을 제네릭으로 정의
		Function<Integer, Double> function = x -> x*0.5;
		System.out.println(function.apply(50));
		// 4. Predicate : 입력값에 대한 참 거짓을 판단. 리턴 타입이 boolean
		Predicate<Integer> predicate = x -> x < 100;
		System.out.println(predicate.test(50));
		// 5. 입력값과 반환값이 동일할 때 사용
		UnaryOperator<Integer> unary = x -> x+20;
		System.out.println(unary.apply(100));
		
		/*
		 * 이항 인터페이스 : 입력값이 2개(당연히 Supplier 없음)
		 */
		// 1. BiConsumer		: Consumer 입력값이 2개
		BiConsumer<Integer, Integer> biconsumer = (x,y)->System.out.println(x+y);
		biconsumer.accept(30, 20);
		// 2. BiFunction		: Function 입력값이 2개
		// 3. BiPredicate		: Predicate 입력값이 2개
		// 4. BinaryOperator	: UnaryOperator 입력값이 2개
		
		
	}
	
}
