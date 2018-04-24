package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import repeat.Repeat;
import repeat.RepeatRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {
    private PatriotBattery batteryMock;
    private BetterRadar radar;

    @Before
    public void setUp() throws Exception {
        batteryMock = mock( PatriotBattery.class );
        radar = new BetterRadar( batteryMock );
    }

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {

        radar.notice( new Scud() );
        verify( batteryMock ).launchPatriot();

    }
}