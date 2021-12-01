package Middlewear;

import ActionObjects.InitializeShowTippsWindowActionObject;
import Backend.Backend;
import BackendObjects.Tipp;
import BackendObjects.TippTableView;
import Frontend.ShowTippFrontend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class ShowTippHandlerTest {

    ShowTippHandler testHandler;

    @Mock
    ShowTippFrontend frontendMock;
    @Mock
    Backend backendMock;

    @BeforeEach
    public void setUp(){
        testHandler = new ShowTippHandler(frontendMock, backendMock);
    }

    @Test
    public void shouldGetTheTippsOfAUserWhileInitializing(){
        testHandler.heandleAction(new InitializeShowTippsWindowActionObject("0"));

        verify(backendMock, times(1)).getAllTippsFromUser("0");
    }

    @Test
    public void shouldShowTheUserHisTipps(){

        TippTableView[] testTipps = new TippTableView[]{new TippTableView("1.1.1111", "1, 2, 3, 4, 5, 6", "1", "", "", "", "")};

        when(backendMock.getAllTippsFromUser(any(String.class))).thenReturn(testTipps);

        testHandler.heandleAction(new InitializeShowTippsWindowActionObject("0"));

        verify(frontendMock, times(1)).fillTippTabel(testTipps);
    }

}