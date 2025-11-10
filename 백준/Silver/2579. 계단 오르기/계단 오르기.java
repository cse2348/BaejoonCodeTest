import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 1. 계단 점수를 저장할 배열 (1번부터 n번까지 사용)
        int[] scores = new int[n + 1]; 
        
        // 2. i번째 계단까지의 최대 점수를 저장할 DP 배열
        int[] dp = new int[n + 1];

        // n개의 계단 점수를 입력받아 scores 배열에 저장
        for (int i = 1; i <= n; i++) {
            scores[i] = scanner.nextInt();
        }

        // 3. DP의 시작점 (Base Case) 설정
        
        // dp[1] = 1번째 계단까지의 최대 점수 (자기 자신)
        dp[1] = scores[1];

        // n=1일 수도 있으므로, n이 2 이상일 때만 dp[2]를 계산
        if (n >= 2) {
            // dp[2] = 2번째 계단까지의 최대 점수 (1번 + 2번)
            dp[2] = scores[1] + scores[2];
        }

        // 4. 점화식을 이용해 3번째 계단부터 n번째 계단까지 계산
        for (int i = 3; i <= n; i++) {
            // 경우 1: (i-2) -> i 로 2칸 점프 (항상 안전)
            int case1 = dp[i-2] + scores[i];
            
            // 경우 2: (i-3) -> (i-1) -> i 로 1칸 점프 (3연속 방지)
            int case2 = dp[i-3] + scores[i-1] + scores[i];

            // 두 경우 중 더 큰 값을 저장
            dp[i] = Math.max(case1, case2);
        }

        // 5. 마지막 계단(n)까지의 최대 점수를 출력
        System.out.println(dp[n]);
        
        scanner.close();
    }
}