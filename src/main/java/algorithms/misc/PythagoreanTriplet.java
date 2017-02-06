package algorithms.misc;

public class PythagoreanTriplet {

    public Result find(int ... parameters) {
        L1: for (int i=0; i<parameters.length; i++) {
            L2: for (int j=0; j<parameters.length; j++) {

                if (j==i) {
                    continue L2;
                }

                L3: for (int k=0; k<parameters.length; k++) {
                    if (k==j || k==i) {
                        continue L3;
                    }

                    if (matches(parameters[i], parameters[j], parameters[k])) {
                        return new Result(parameters[i], parameters[j], parameters[k]);
                    }
                }
            }
        }

        return new Result();
    }

    private boolean matches(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    public static class Result {
        private boolean exists;
        private int a, b, c;

        public Result() {
            this.exists = false;
        }

        public Result(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.exists = true;
        }

        public boolean exists() {
            return exists;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }
    }
}
