import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RadioTest {

    @Test
    public void testInitialStationAndVolume() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetCurrentStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
        radio.increaseVolume();
        radio.increaseVolume();
        assertEquals(2, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}