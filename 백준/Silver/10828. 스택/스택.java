import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    // 스택을 직접 구현하기 위한 배열
    // N이 최대 10,000이므로 10,000 크기로 생성
    public static int[] stack = new int[10000];
    
    // 스택의 맨 위를 가리키는 포인터 (top)
    // 0이 아닌 -1로 시작해야 스택이 비어있음(empty)을 표현하기 쉽습니다.
    public static int topIndex = -1;

    public static void main(String[] args) throws IOException {
        
        // 1. 빠른 입출력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2. 출력을 한 번에 모아서 하기 위한 StringBuilder (속도 향상)
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수

        for (int i = 0; i < N; i++) {
            String commandLine = br.readLine();
            
            // "push" 명령어인지 확인 (공백 포함)
            if (commandLine.startsWith("push")) {
                // " " (공백)을 기준으로 문자열을 자름
                String[] parts = commandLine.split(" ");
                int X = Integer.parseInt(parts[1]);
                push(X);
            } else {
                // "push"가 아닌 나머지 명령어 처리
                switch (commandLine) {
                    case "pop":
                        // pop은 결과를 출력해야 하므로 StringBuilder에 추가
                        sb.append(pop()).append('\n');
                        break;
                    case "size":
                        sb.append(size()).append('\n');
                        break;
                    case "empty":
                        sb.append(empty()).append('\n');
                        break;
                    case "top":
                        sb.append(top()).append('\n');
                        break;
                }
            }
        }
        
        // 3. 모아둔 출력을 한 번에 인쇄
        System.out.print(sb);
    }

    // --- 스택 기능 구현 ---

    // push X: 정수 X를 스택에 넣는 연산
    public static void push(int X) {
        topIndex++; // top 포인터 1 증가
        stack[topIndex] = X; // 해당 위치에 X 저장
    }

    // pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 반환
    public static int pop() {
        if (empty() == 1) { // 스택이 비어있으면
            return -1;
        } else {
            int value = stack[topIndex]; // 맨 위 값 저장
            topIndex--; // top 포인터 1 감소
            return value;
        }
    }

    // size: 스택에 들어있는 정수의 개수
    public static int size() {
        // topIndex가 -1 (0개) 이면, size는 0
        // topIndex가 0 (1개) 이면, size는 1 ...
        return topIndex + 1;
    }

    // empty: 스택이 비어있으면 1, 아니면 0
    public static int empty() {
        if (topIndex == -1) {
            return 1;
        } else {
            return 0;
        }
    }

    // top: 스택의 가장 위에 있는 정수
    public static int top() {
        if (empty() == 1) { // 스택이 비어있으면
            return -1;
        } else {
            return stack[topIndex]; // 맨 위 값 반환 (pop과 달리 포인터는 유지)
        }
    }
}