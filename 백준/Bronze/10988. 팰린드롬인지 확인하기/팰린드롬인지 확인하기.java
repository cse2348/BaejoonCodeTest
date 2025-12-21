import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		
		String reversed = new StringBuilder(origin).reverse().toString();
		
		if(origin.equals(reversed)) {
			System.out.println(1);
		}else
			System.out.println(0);
	}

}