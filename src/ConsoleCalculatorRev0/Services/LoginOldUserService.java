package ConsoleCalculatorRev0.Services;

import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUserInJDBC;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.util.List;
import java.util.Optional;

public class LoginOldUserService {
//    SaveNewUserInFile saveNewUserInFile = new SaveNewUserInFile();

    SaveNewUserInJDBC jdbcUserStorage = new SaveNewUserInJDBC();           //!!!!!!!!!!!!!!!!!!!!! Changed from File storage

    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();


//Method for finding old user by userName and userPassword

    public Optional<CalculatorUser> getOldUserFromList() {

//        List<CalculatorUser> list = saveNewUserInFile.addUsersInfoToArrayList();
        List<CalculatorUser> list = jdbcUserStorage.addUsersInfoToArrayList();                //!!!!!!!!!!!!!!!!!!!!! Changed from File storage



            consoleWriter.printMessage("\nEnter your username: ");
            String userName = consoleReader.readAction();

            consoleWriter.printMessage("\nEnter your password: ");
            String userPassword = consoleReader.readAction();


            for (CalculatorUser calculatorUser : list) {

                if ((userName.equalsIgnoreCase(calculatorUser.getUserName())) && (userPassword.equals(calculatorUser.getUserPassword()))) {

                    consoleWriter.printMessage("Hi, " +calculatorUser.getUserName() + " with ID = "
                            + calculatorUser.getUserID() + "! " + "Authorisation is successful!\n");

                    return Optional.of(calculatorUser);
                }

            }

            consoleWriter.printMessage("\nYou username or password are wrong. Please, try again.\n");

            return Optional.empty();


    }
}