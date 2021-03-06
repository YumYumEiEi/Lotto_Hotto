package Middlewear;

import ActionObjects.GiveATippActionObject;
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
        String[] tippedNumbers = new String[]{"3", "7", "18", "21", "22", "35"};

        GiveATippActionObject testTipp = new GiveATippActionObject( tippedNumbers, "7", User.getEmptyUser());

        when(mockBackend.isTippAlreaddyGiven(any(Tipp.class), any(String.class))).thenReturn(false);
        when(mockBackend.getNextDrawing()).thenReturn(new Drawing("0", new String[]{}, "", "11.11.1111"));

        //Test
        testHandler.heandleAction(testTipp);

        //Assert
        verify(mockBackend, times(1)).saveTipp(any(Tipp.class));
    }

    @Test
    public void shouldShowAnErrorMessageIfTheCurrendUserAlreadyGaveTheExactSameTippForThisDrawing(){
        //Setup
        String[] tippedNumbers = new String[]{"3", "7", "18", "21", "22", "35"};

        GiveATippActionObject testTipp = new GiveATippActionObject( tippedNumbers, "7", User.getEmptyUser());

        when(mockBackend.getNextDrawing()).thenReturn(new Drawing("0", new String[]{}, "", "22.12.1111"));
        when(mockBackend.isTippAlreaddyGiven(any(Tipp.class), any(String.class))).thenReturn(true);

        //Test
        testHandler.heandleAction(testTipp);

        //Assert
        verify(mockBackend, times(0)).saveTipp(any(Tipp.class));
        verify(mockFrontend, times(1)).showTippAlreaddyThereErrorMessage();
    }

    @Test
    public void shouldShowAnErrorMessageIfThereAreNotSixNumbersTipped(){
        //Setup
        String[] tippedNumbers = new String[]{"3", "7", "18", "22", "46"};

        GiveATippActionObject testTipp = new GiveATippActionObject( tippedNumbers, "7", User.getEmptyUser());

        when(mockBackend.getNextDrawing()).thenReturn(new Drawing("0", new String[]{}, "", "31.08.1942"));

        //Test
        testHandler.heandleAction(testTipp);

        //Assert
        verify(mockBackend, times(0)).saveTipp(any(Tipp.class));
        verify(mockFrontend, times(1)).showNotSixNumbersPickedErrorMessage();
    }
}