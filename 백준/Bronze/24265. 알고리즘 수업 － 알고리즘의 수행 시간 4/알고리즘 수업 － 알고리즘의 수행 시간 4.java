import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	long s = Long.parseLong(br.readLine());
        System.out.println((s*(s-1))/2);
        System.out.println(2);
    	
    }
}