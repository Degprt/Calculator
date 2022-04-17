public class Calculator {
    private static final char[] OPS = {'+', '-', '*', '/'};

    public String calculate(String inputStr) {
        Number left = null;
        Number right;

        char op = getOp(inputStr);
        String delimiter = (op == '/') ? "/" : ("\\" + op);
        String[] operandStrs = inputStr.split(delimiter);
        if (operandStrs.length != 2)
            throw new IllegalArgumentException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)" + operandStrs.length);

        left = getOperand(operandStrs[0].trim().toUpperCase());
        right = getOperand(operandStrs[1].trim().toUpperCase());

        if (left.kind() != right.kind())
            throw new IllegalArgumentException("//т.к. используются одновременно разные системы счисления");

        left.setValue(perform(left, right, op));

        return left.getStrValue();
    }

    private char getOp(String input) {
        for (char op : OPS) {
            if (input.indexOf(op) >= 0)
                return op;
        }
        throw new IllegalArgumentException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }

    private Number getOperand(String operand) {
        Number n = new ArabicNumber();
        if (n.isNumber(operand)) {
            n.setValue(operand);
            return n;
        }

        n = new RomanNumber();
        if (n.isNumber(operand)) {
            n.setValue(operand);
            return n;
        }
        throw new IllegalArgumentException("//т.к. указан нечисловой операнд");
    }

    private int perform(Number left, Number right, char operation) {
        switch (operation) {
            case '+':
                return left.getValue() + right.getValue();
            case '-':
                return left.getValue() - right.getValue();
            case '*':
                return left.getValue() * right.getValue();
            case '/':
                return left.getValue() / right.getValue();
        }
        throw new IllegalArgumentException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }
}
