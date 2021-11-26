package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.LoginActionObject;
import ActionObjects.RegisterActionObject;
import Backend.Backend;
import BackendObjects.Adress;
import BackendObjects.BankAccount;
import BackendObjects.User;
import Frontend.LoginFrontend;
import Frontend.RegistrationFrontend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class RegistrationHaendlerTest {
    RegistrationHaendler testHeandler;

    @Mock
    RegistrationFrontend frontendMock;
    @Mock
    Backend backendMock;

    @BeforeEach
    public void setUp(){
        testHeandler = new RegistrationHaendler(frontendMock, backendMock);
    }

    @Test
    public void shouldRegsterTheUserIfTheUsernameIsUniqueAndPasswordIsTwoTimesTheSame(){
        // Setup
        RegisterActionObject testRegistrationInfo = new RegisterActionObject("register",  "SusiBusi", "1234wasd",
                "1234wasd", "Frau", "Susi", "Schneider", "07.08.2013",  "Friedrichstraße 65",
                "Berlin", "12456", "DE983746627381000023");
        uniqueUsername(true);

        // Test
        testHeandler.heandleAction(testRegistrationInfo);

        // Assert
        verify(backendMock, times(1)).saveNewUser(any(User.class));
    }

    @Test
    public void shouldShowErrorMessageIfUsernameAlreadyUsed(){
        // Setup
        RegisterActionObject testRegistrationInfo = new RegisterActionObject("register",  "SusiBusi", "1234wasd",
                "1234wasd", "Frau", "Susi", "Schneider", "07.08.1913",  "Friedrichstraße 65",
                "Berlin", "12456", "DE983746627381000023");;
        uniqueUsername(false);

        // Test
        testHeandler.heandleAction(testRegistrationInfo);

        // Assert
        verify(frontendMock, times(1)).showUsernameNotUniqueMessage();
    }

    @Test
    public void shouldShowErrorMessageIfPasswordIsDifferent(){
        // Setup
        RegisterActionObject testRegistrationInfo = new RegisterActionObject("register", "SusiBusi", "1234wasd",
                "1234wasf", "Frau", "Susi", "Schneider", "04.05.1454",  "Friedrichstraße 65",
                "Berlin", "12456", "DE983746627381000023");
        uniqueUsername(true);

        // Test
        testHeandler.heandleAction(testRegistrationInfo);

        // Assert
        verify(frontendMock, times(1)).showDifferentPasswordMessage();
    }

    @Test
    public void shouldShowErrorMessageIfFieldsAreEmpty(){
        // Setup
        RegisterActionObject testRegistrationInfo = new RegisterActionObject("register", "SusiBusi", "1234wasd",
                "1234wasd", "Frau", "Susi", "", "",  "Friedrichstraße 65",
                "Berlin", "12456", "DE983746627381000023");
        uniqueUsername(true);

        // Test
        testHeandler.heandleAction(testRegistrationInfo);

        // Assert
        verify(frontendMock, times(1)).showMissingFieldMessage();
    }

    private void uniqueUsername(boolean uniqueUsername){
        when(backendMock.isUsernameUnique(any(String.class))).thenReturn(uniqueUsername);
    }


}