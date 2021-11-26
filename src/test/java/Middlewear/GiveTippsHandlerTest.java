package Middlewear;

import ActionObjects.TippActionObject;
import Backend.Backend;
import BackendObjects.Drawing;
import BackendObjects.Tipp;
import BackendObjects.User;
import Frontend.GiveTippsFrontend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GiveTippsHandlerTest {
    GiveTippsHandler testHandler;

    @Mock
    GiveTippsFrontend mockFrontend;
    @Mock
    Backend mockBackend;

    @BeforeEach
    public void setUp(){
        testHandler = new GiveTippsHandler(mockFrontend, mockBackend);
    }

    @Test
    public void shouldSaveTheTippIfEverythingIsbCorrect(){
        //Setup
        String[] tippedNumbers = new String[]{"3", "7", "18", "21", "22", "35", "46"};

        TippActionObject testTipp = new TippActionObject( tippedNumbers, "7", User.getEmptyUser());

        when(mockBackend.isTippAlreaddyGiven(any(Tipp.class), any(String.class))).thenReturn(false);
        when(mockBackend.getNextDrawing()).thenReturn(new Drawing("0"));

        //Test
        testHandler.heandleAction(testTipp);

        //Assert
        verify(mockBackend, times(1)).saveTipp(any(Tipp.class));
    }

    @Test
    public void shouldShowAnErrorMessageIfTheCurrendUserAlreadyGaveTheExactSameTippForThisDrawing(){
        //Setup
        String[] tippedNumbers = new String[]{"3", "7", "18", "21", "22", "35", "46"};

        TippActionObject testTipp = new TippActionObject( tippedNumbers, "7", User.getEmptyUser());

        when(mockBackend.getNextDrawing()).thenReturn(new Drawing("0"));
        when(mockBackend.isTippAlreaddyGiven(any(Tipp.class), any(String.class))).thenReturn(true);

        //Test
        testHandler.heandleAction(testTipp);

        //Assert
        verify(mockBackend, times(0)).saveTipp(any(Tipp.class));
        verify(mockFrontend, times(1)).showTippAlreaddyThereErrorMessage();
    }

    @Test
    public void shouldShowAnErrorMessageIfThereAreNotSevenNumbersTipped(){
        //Setup
        String[] tippedNumbers = new String[]{"3", "7", "18", "21", "22", "46"};

        TippActionObject testTipp = new TippActionObject( tippedNumbers, "7", User.getEmptyUser());

        when(mockBackend.getNextDrawing()).thenReturn(new Drawing("0"));

        //Test
        testHandler.heandleAction(testTipp);

        //Assert
        verify(mockBackend, times(0)).saveTipp(any(Tipp.class));
        verify(mockFrontend, times(1)).showNotSevenNumbersPickedErrorMessage();
    }
}