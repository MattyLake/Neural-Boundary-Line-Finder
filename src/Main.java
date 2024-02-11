public class Main {
    double[] x1 = {1, 2, 5, 4, 6, 1};
    double[] x2 = {4, 9, 6, 5, 0.7, 1.5};
    int[] classes = {-1, +1, +1, +1, -1, -1};
    double[] weights = {0, 0, 0}; // {W_0, W_1, W_2}
    double gradient;
    double yIntercept;

    public Main() {
        boolean changeMade = true;
        while (changeMade) {
            changeMade = false;
            for (int i = 0; i < x1.length - 1; i++) {
                double S = weights[0] + x1[i] * weights[1] + x2[i] * weights[2];
                if ((S <= 0 && classes[i] == +1) || (S >= 0 && classes[i] == -1)) {
                    weights[0] += classes[i] * 1;
                    weights[1] += classes[i] * x1[i];
                    weights[2] += classes[i] * x2[i];
                    changeMade = true;
                }
            }
        }
        this.gradient = -weights[1]/weights[2];
        this.yIntercept = -weights[0]/weights[2];
    }

   public void printResult() {
        System.out.println("Gradient: "+gradient+", Y-Intercept: "+yIntercept);
   }

    public static void main(String[] args) {
        Main main = new Main();
        main.printResult();
    }
}