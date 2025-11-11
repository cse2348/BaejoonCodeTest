import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    
    public static int[] stack = new int[10000];
    
    
    public static int topIndex = -1;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String commandLine = br.readLine();
            
            if (commandLine.startsWith("push")) {
              String[] parts = commandLine.split(" ");
                int X = Integer.parseInt(parts[1]);
                push(X);
            } else {

                switch (commandLine) {
                    case "pop":

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
        
        
        System.out.print(sb);
    }


    public static void push(int X) {
        topIndex++; 
        stack[topIndex] = X; 
    }


    public static int pop() {
        if (empty() == 1) { 
            return -1;
        } else {
            int value = stack[topIndex]; 
            topIndex--; 
            return value;
        }
    }


    public static int size() {

        return topIndex + 1;
    }


    public static int empty() {
        if (topIndex == -1) {
            return 1;
        } else {
            return 0;
        }
    }


    public static int top() {
        if (empty() == 1) {
            return -1;
        } else {
            return stack[topIndex];
        }
    }

}
