public class LoopPractice {
    void LoopFor(int n) {
        for (int i = 1; i <= n; i ++) {
            System.out.println("Turn-" + i);
        }
    }

    void LoopWhile(int i) {
        int n = 0;
        while (i >= n) {
            System.out.println("Enemy HP: " + i);
            i--;
        }
    }
}