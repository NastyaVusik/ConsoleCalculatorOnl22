package ConsoleCalculatorRev0.Services;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.CalculationHistory.FileHistory;
import ConsoleCalculatorRev0.CalculationHistory.History;
import ConsoleCalculatorRev0.CalculationHistory.InMemoryHistory;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperationService {

    History fileHistory = new FileHistory();
    History inMemoryHistory = new InMemoryHistory();


    public History getInMemoryHistory() {
        return inMemoryHistory;
    }

    //Method for realisation of operations with numbers
    public double calculateResult(CalcOperation calcOperation, CalculatorUser calculatorUser) {            //Pass object calcOperation instead (double num1, double num2, String action)

        switch (calcOperation.getAction()) {
            case ("+") -> {
                double res1 = calcOperation.getNum1() + calcOperation.getNum2();
                CalcOperation calcOperation1 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res1, calcOperation.getFormatDateTime(), calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistoryWithUser(calcOperation1, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation1);
                return res1;
            }
            case ("-") -> {
                double res2 = calcOperation.getNum1() - calcOperation.getNum2();
                CalcOperation calcOperation2 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res2, calcOperation.getFormatDateTime(),  calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistoryWithUser(calcOperation2, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation2);
                return res2;
            }
            case ("*") -> {
                double res3 = calcOperation.getNum1() * calcOperation.getNum2();
                CalcOperation calcOperation3 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res3, calcOperation.getFormatDateTime(),  calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistoryWithUser(calcOperation3, calculatorUser);;
                inMemoryHistory.writeHistory(calcOperation3);
                return res3;
            }
            case ("/") -> {
                double res4 = calcOperation.getNum1() / calcOperation.getNum2();
                CalcOperation calcOperation4 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res4, calcOperation.getFormatDateTime(),  calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistoryWithUser(calcOperation4, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation4);
                return res4;
            }
        }

        throw new RuntimeException();
    }

}

