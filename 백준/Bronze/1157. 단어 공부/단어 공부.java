import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase(); //받아서 모두 대문자로 바꾸기
		
		int[] alphabet = new int[26];
		
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i)-'A';
			alphabet[index]++;
		}
		
		int maxCount = -1;
		char answer ='?';
		
		for(int i=0;i<26;i++) {
			if(maxCount < alphabet[i]) {
				maxCount = alphabet[i];
				answer = (char)(i+'A');
			}else if(maxCount == alphabet[i]){
				answer = '?';
			}
		}
		System.out.println(answer);
	}
}