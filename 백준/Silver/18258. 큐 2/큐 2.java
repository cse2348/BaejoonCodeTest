import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> q =new LinkedList<>();
		
		int X = Integer.parseInt(br.readLine());
		
		for(int i=0; i<X; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
				case "push":
					int m = Integer.parseInt(st.nextToken());
					q.add(m); 
					break;
					
				case "pop":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.poll()).append('\n'); 
					}
					break;
					
				case "size":
					sb.append(q.size()).append('\n');
					break;
					
				case "empty":
					sb.append(q.isEmpty() ? 1 : 0).append('\n');
					break;
					
				case "front":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.peek()).append('\n'); 
					}
					break;
					
				case "back":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.peekLast()).append('\n'); 
					}
					break;
			}
		}
		System.out.print(sb);
		
	}
} 