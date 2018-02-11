package com.pluralsight.calcengine;

public class CalculateHelper {
    MathCommand command;
    double leftValue;
    double rightvalue;
    double result;

    public void process(String statement) {
        // add 2.0 1.0
        String[] parts = statement.split(" ");
        String commandString = parts[0]; // add
        leftValue = Double.parseDouble(parts[1]); // 2.0
        rightvalue = Double.parseDouble(parts[2]); // 1.0
        setCommandFromString(commandString);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightvalue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightvalue);
                break;
            case Subtract:
                calculator = new Subtractor(leftValue, rightvalue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightvalue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString) {
        // add -> MathCommand.Add
        if (commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    @Override
    public String toString() {
        // 1.0 + 2.0 = 3.0
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = '+';
                break;
            case Divide:
                symbol = '/';
                break;
            case Subtract:
                symbol = '-';
                break;
            case Multiply:
                symbol = '*';
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightvalue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

}
