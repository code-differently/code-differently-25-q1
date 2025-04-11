package XboxTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson16.dylans_xbox.DiskDriveFullException;
import com.codedifferently.lesson16.dylans_xbox.Xbox;

public class DiskdrivefullTest {
    @Test 
    public void testDiskDriveFullException() throws Exception {
        // Create an instance of Xbox with diskDriveFull set to true
        Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, true);
        
        try {
            xbox.inputGame(1, "Call of Duty");
            fail("Expected DiskDriveFullException to be thrown.");
        } catch (DiskDriveFullException e) {
            assertEquals("Disk drive is full. Cannot insert game.", e.getMessage());
        }
    }
}
