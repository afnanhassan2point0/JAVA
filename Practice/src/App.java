public class App {
    public static void main(String[] args) throws Exception {

        int[][] array = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int x[] : array) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
