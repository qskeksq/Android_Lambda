import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaInterfaceBasic {

	/**
	 * RxAndroid�� ����ϴ� ���� ���� java�� Functional Interface�� �޾� ����ϴ� ���� �� �� �ִ�
	 */
	public void run() {
		/**
		 * ���� �������̽�
		 */
		// 1. Supplier : �Է°��� ����, ��ȯ���� ���� �� ���
		Supplier<Integer> supplier = ()->180 +20;
		System.out.println(supplier.get());
		// 2. Consumer : �Է°��� �ְ�, ��ȯ���� ���� �� ���
		//				 �ڵ������ ���ó���� �Ǿ�� �Ѵ�
		Consumer<Integer> consumer = System.out::println;
		consumer.accept(100);
		// 3. Function : �Է°��� �ְ�, ��ȯ���� �ִ�
		//				  �Է°��� ��ȯ���� Ÿ���� ���׸����� ����
		Function<Integer, Double> function = x -> x*0.5;
		System.out.println(function.apply(50));
		// 4. Predicate : �Է°��� ���� �� ������ �Ǵ�. ���� Ÿ���� boolean
		Predicate<Integer> predicate = x -> x < 100;
		System.out.println(predicate.test(50));
		// 5. �Է°��� ��ȯ���� ������ �� ���
		UnaryOperator<Integer> unary = x -> x+20;
		System.out.println(unary.apply(100));
		
		/*
		 * ���� �������̽� : �Է°��� 2��(�翬�� Supplier ����)
		 */
		// 1. BiConsumer		: Consumer �Է°��� 2��
		BiConsumer<Integer, Integer> biconsumer = (x,y)->System.out.println(x+y);
		biconsumer.accept(30, 20);
		// 2. BiFunction		: Function �Է°��� 2��
		// 3. BiPredicate		: Predicate �Է°��� 2��
		// 4. BinaryOperator	: UnaryOperator �Է°��� 2��
		
		
	}
	
}
