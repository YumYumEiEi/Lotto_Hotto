package Middlewear;

import ActionObjects.ActionObject;
import ActionObjects.LoginActionObject;
import Backend.Backend;
import BackendObjects.User;
import Frontend.LoginFrontend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class LoginHeandlerTest {
    LoginHeandler testHeandler;

    @Mock
    LoginFrontend frontendMock;
    @Mock
    Backend backendMock;

    @BeforeEach
    public void setUp(){
        testHeandler = new LoginHeandler(frontendMock, backendMock);
    }

    @Test
    public void shouldStartSwitchingToTheMainWindowIfLoggindataIsCorrect(){
        // Setup
        when(backendMock.getUser("Peter", "1234wasd")).thenReturn(new User("Peter", "1234wasd"));
        LoginActionObject testAction = new LoginActionObject("login", "Peter", "1234wasd");

        // Test
        testHeandler.heandleAction(testAction);

        // Assert
        verify(frontendMock, times(1)).goToMainWindow(any(User.class));
    }

    @Test
    public void shouldTellMeThatMyLoginInformationAreWrongIfThereIsNoUserWithTheUserdLoginInformation(){
        // Setup
        when(backendMock.getUser("Peter", "1234wasd")).thenReturn(null);
        LoginActionObject testAction = new LoginActionObject("login", "Peter", "1234wasd");

        // Test
        testHeandler.heandleAction(testAction);

        // Assert
        verify(frontendMock, times(1)).showUserNotFoundMessage();
    }
}