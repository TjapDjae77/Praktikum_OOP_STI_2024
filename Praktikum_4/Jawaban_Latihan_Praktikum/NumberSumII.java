// NAMA = Rajendra Farras Rayhan
// NIM = 18222105
// TANGGAL = 02/06/2024


public class NumberSumII {
    public Number sumNumberII(Number[] numArr) {
        if (numArr.length == 0 || numArr == null) {
            return 0;
        }
        
        Number sum = numArr[0];

        for (int i = 1; i < numArr.length; i++) {
            sum = addNumbers(sum, numArr[i]);
        }

        return sum;
        
    }

    

    private Number addNumbers(Number sum, Number currentNumber) {
        String className = currentNumber.getClass().getSimpleName();
        
        switch (className) {
            case "Byte":
                return handleByteAddition(sum, (Byte)currentNumber);
            case "Integer":
                return handleIntegerAddition(sum, (Integer)currentNumber);
            case "Short":
                return handleShortAddition(sum, (Short)currentNumber);
            case "Long":
                return handleLongAddition(sum, (Long)currentNumber);
            case "Float":
                return handleFloatAddition(sum, (Float)currentNumber);
            case "Double":
                return handleDoubleAddition(sum, (Double)currentNumber);
            default:
                return sum;
        }
    }

    private Number handleByteAddition(Number sum, Byte currentNumber) {
        long res = sum.longValue() + currentNumber;
        if (res > Byte.MAX_VALUE) {
            return Byte.MAX_VALUE;
        } else if (res < Byte.MIN_VALUE) {
            return Byte.MIN_VALUE;
        } else {
            return (byte) res;
        }
    }

    private Number handleIntegerAddition(Number sum, Integer currentNumber) {
        long res = sum.longValue() + currentNumber;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }
    }

    private Number handleShortAddition(Number sum, Short currentNumber) {
        long res = sum.longValue() + currentNumber;
        if (res > Short.MAX_VALUE) {
            return Short.MAX_VALUE;
        } else if (res < Short.MIN_VALUE) {
            return Short.MIN_VALUE;
        } else {
            return (short) res;
        }
    }

    private Number handleLongAddition(Number sum, Long currentNumber) {
        if (sum.longValue() > 0 && currentNumber > 0 && Long.MAX_VALUE - sum.longValue() < currentNumber) {
            return Long.MAX_VALUE;
        }
        else if (sum.longValue() < 0 && currentNumber < 0 && Long.MAX_VALUE - sum.longValue() > currentNumber) {
            return Long.MIN_VALUE;
        }
        else {
            return sum.longValue() + currentNumber;
        }
    }

    private Number handleFloatAddition(Number sum, Float currentNumber) {
        float res = sum.floatValue() + currentNumber;
        if (Float.isInfinite(res)) {
            if (res > 0) {
                return Float.POSITIVE_INFINITY;
            }
            else {
                return Float.NEGATIVE_INFINITY;
            }
        } else {
            return res;
        }
    }

    private Number handleDoubleAddition(Number sum, Double currentNumber) {
        double res = sum.doubleValue() + currentNumber;
        if (Double.isInfinite(res)) {
            if (res > 0) {
                return Double.POSITIVE_INFINITY;
            }
            else {
                return Double.NEGATIVE_INFINITY;
            }
        } else {
            return res;
        }
    }
}