import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 1. 노드 구조 정의
class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
    }
}

public class Main {
    static Node[] tree; // 노드들을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        tree = new Node[n];
        
        // 2. 노드 초기화 (A, B, C...)
        for (int i = 0; i < n; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        // 3. 트리 연결하기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 부모 노드의 인덱스 찾기 (A=0, B=1...)
            int pIdx = parent - 'A';
            
            // 왼쪽 자식 연결
            if (left != '.') {
                tree[pIdx].left = tree[left - 'A'];
            }
            // 오른쪽 자식 연결
            if (right != '.') {
                tree[pIdx].right = tree[right - 'A'];
            }
        }

        // 4. 세 가지 순회 실행
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
        System.out.println();
    }

    // 전위 순회: 루트 -> 왼 -> 오
    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);      // 나(루트) 출력
        preOrder(node.left);              // 왼쪽 방문
        preOrder(node.right);             // 오른쪽 방문
    }

    // 중위 순회: 왼 -> 루트 -> 오
    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);               // 왼쪽 방문
        System.out.print(node.data);      // 나(루트) 출력
        inOrder(node.right);              // 오른쪽 방문
    }

    // 후위 순회: 왼 -> 오 -> 루트
    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);               // 왼쪽 방문
        postOrder(node.right);              // 오른쪽 방문
        System.out.print(node.data);        // 나(루트) 출력
    }
}