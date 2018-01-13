package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    private Button button, stream;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // 람다는 객체 안에 함수가 하나만 있을 때 사용할 수 있다.

        // 코드 내부에서 반복 처리를 해줄 수 있다.

        // 람다는 거의 콜백 패턴과 스트림에서밖에 사용하지 않는다.
        // 현재는 onClickListener 와 스레드에서만 사용한다. 단 두 군데에서만 사용한다

        // 결국 생략할 수 있는 것은 생략하고 최소한으로 써주는 것!

        // 인자가 없으면 ()로 사용한다.

//        button.setOnClickListener((view) -> { textView.setText("Hello");});
//        button.setOnClickListener( view -> System.out.println(view)  );
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


        // 꼭 알아야 하는 내용
        // 1. 객체 안의 함수가 한개여야 한다.
        // 2. 함수의 파라미터 수는 상관 없다.
        // 3. 람다식으로 사용하는 원본 인터페이스는 껍데기만 존재한다. <- 즉, 설계 도구라는 뜻
//        LambdaFunction arg_original = new LambdaFunction() {// 참고로 인터페이스가 아닌 것들은 안에 코드를 써 줄 수 없음
//            @Override
//            public int squareParameter(int p) {
//
//                return p*p;
//            }
//        };
//        calc(arg_original);

        // 인터페이스 하나 함수 하나
        LambdaFunction arg = p -> p*p;
        calc(arg);

        button.setOnClickListener(view->printWorld(objArray));

        Stream<String> data = Arrays.stream(objArray);

        stream.setOnClickListener(view->printStream(data));
    }

    public void calc(LambdaFunction param){
        int result = param.squareParameter(7);
        System.out.print(result);
    }


    @FunctionalInterface
    interface LambdaFunction {
        int squareParameter(int number);
    }

    private void initView() {
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
    }


    String[] objArray = {"A","B","C","DX123","F","G","H","J", "K"};


    private void printWorld(String[] array){
        for(String item : array){
            if(item.length() == 1){
                System.out.print(item);
            }
        }
    }

    public void printStream(Stream<String> data){
        // 실시간으로 필터링해 줄 수 있다. 즉, 가져오면서 중간에 처리해 줄 수 있다.
        // 이렇게 해 주면 위의 printWorld 와 동일한 효과를 낼 수 있다.
        data.filter(item -> item.length() == 1)
        .forEach(item -> System.out.println(item));
    }


    // 그렇다면 두 함수의 차이는 무엇인가 printWorld 의 인자로는 처음부터 데이터의 전체가 들어가지만
    // printStream 의 경우는 Stream<String> data 가 데이터의 처음 부분만을 가리키고 있다가
    // foreach 문이 시작될 때 데이터를 하나씩 읽어오기 시작하는 것이다.
}
