public class RomanNumber extends Number{
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 10;
    private static final String[] NUMBERS = {
            "0",    "I",     "II",     "III",     "IV",     "V",     "VI",     "VII",     "VIII",     "IX",
            "X",    "XI",    "XII",    "XIII",    "XIV",    "XV",    "XVI",    "XVII",    "XVIII",    "XIX",
            "XX",   "XXI",   "XXII",   "XXIII",   "XXIV",   "XXV",   "XXVI",   "XXVII",   "XXVIII",   "XXIX",
            "XXX",  "XXXI",  "XXXII",  "XXXIII",  "XXXIV",  "XXXV",  "XXXVI",  "XXXVII",  "XXXVIII",  "XXXIX",
            "XL",   "XLI",   "XLII",   "XLIII",   "XLIV",   "XLV",   "XLVI",   "XLVII",   "XLVIII",   "XLIX",
            "L",    "LI",    "LII",    "LIII",    "LIV",    "LV",    "LVI",    "LVII",    "LVIII",    "LIX",
            "LX",   "LXI",   "LXII",   "LXIII",   "LXIV",   "LXV",   "LXVI",   "LXVII",   "LXVIII",   "LXIX",
            "LXX",  "LXXI",  "LXXII",  "LXXIII",  "LXXIV",  "LXXV",  "LXXVI",  "LXXVII",  "LXXVIII",  "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XC",   "XCI",   "XCII",   "XCIII",   "XCIV",   "XCV",   "XCVI",   "XCVII",   "XCVIII",   "XCIX",
            "C"    };

    public RomanNumber() {
        super(NumberKind.ROMAN, NUMBERS, MIN_NUMBER, MAX_NUMBER);
    }

    @Override
    public String getStrValue() {
        if (getValue() < 1)
            throw new IllegalArgumentException("//т.к. в римской системе нет отрицательных чисел");
        return super.getStrValue();
    }
}
