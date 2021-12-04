package Middlewear;

import Backend.Backend;
import Frontend.StatisticFrontend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StatisticHandlerTest {

    StatisticHandler testHandler;

    @Mock
    private Backend mockBackend;

    @Mock
    private StatisticFrontend mockedFrontend;

    @BeforeEach
    public void setUp(){
        this.testHandler = new StatisticHandler(mockedFrontend, mockBackend);
    }

}