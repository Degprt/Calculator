public class Number {
    private final int MIN_NUMBER;
    private final int MAX_NUMBER;
    private final NumberKind kind;
    private final String[] NUMBERS;

    private int value;

    protected Number(NumberKind kind, String[] numbers, int min, int max) {
        this.NUMBERS = numbers;
        this.kind = kind;
        this.MIN_NUMBER = min;
        this.MAX_NUMBER = max;
        this.value = 0;
    }

    public NumberKind kind() {
        return kind;
    }

    public boolean isNumber(String str) {
        int n = getNumber(str);
        return MIN_NUMBER <= n && n <= MAX_NUMBER;
    }

    public void setValue(String str) {
        int num = getNumber(str);
        if (num < 0)
            throw new IllegalArgumentException("Неверное число \"" + str + "\"");
        if (num < MIN_NUMBER || num > MAX_NUMBER)
            throw new IllegalArgumentException("Число вне диапазона от "
                    + MIN_NUMBER + " до "
                    + MAX_NUMBER + ": \"" + str + "\"");
        this.value = num;
    }

    public void setValue(int n) {
        if (n < MIN_NUMBER - MAX_NUMBER || n > MAX_NUMBER * MAX_NUMBER)
            throw new IllegalArgumentException("Число вне диапазона от "
                    + (MIN_NUMBER - MAX_NUMBER) + " до "
                    + (MAX_NUMBER * MAX_NUMBER) + ": \"" + n + "\"");
        this.value = n;
    }

    public int getValue() {
        return this.value;
    }

    public String getStrValue() {
        String sign;
        int n = this.value;
        if (n < 0) {
            sign = "-";
            n = -n;
        } else
            sign = "";

        return sign + NUMBERS[n];
    }

    private int getNumber(String s) {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (s.equals(NUMBERS[i]))
                return i;
        }
        return Integer.MIN_VALUE;
    }
}
