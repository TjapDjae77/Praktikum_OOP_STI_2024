public class NumberSumIIDemo {
    public static void main(String[] args) {
        NumberSumII calculator = new NumberSumII();
        
        Number[] array1 = { (Short)((short) 32767), (Short)((short) 10) };
        Number[] array2 = { (Integer)((int) 10), (Double)((double) 20.5), (Integer)((int) 1) };
        Number[] array3 = { (Integer)((int) 10), (Double)((double) 20.5), (Double) ((double) 570.5), (Byte)((byte) 3), (Double)((double) 11.5) };

        
        Number sum1 = calculator.sumNumberII(array1);
        Number sum2 = calculator.sumNumberII(array2);
        Number sum3 = calculator.sumNumberII(array3);


        System.out.println("Hasil: " + sum1 + " TYPE: " + sum1.getClass().getSimpleName()); // Output: 32767
        System.out.println("Hasil: " + sum2 + " TYPE: " + sum2.getClass().getSimpleName()); // Output: 31
        System.out.println("Hasil: " + sum3 + " TYPE: " + sum3.getClass().getSimpleName()); // Output: 103.5


        short a = Short.MAX_VALUE;
        short b = 1;
        System.out.println("Result: " + ((short) (a+b)));

    }
}
