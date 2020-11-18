import be.pxl.ja.streamingservice.exception.InvalidDateException;
import be.pxl.ja.streamingservice.exception.TooManyProfilesException;
import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.Profile;
import be.pxl.ja.streamingservice.model.StreamingPlan;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToomanyProfilesExceptionTest {
    @Test
    public void throwsInvalidDateExceptionWhenMaximumProfilesReached() {
        Account acc = new Account("JohnDoe@example.be", "1234");
        acc.setStreamingPlan(StreamingPlan.BASIC);
        assertThrows(TooManyProfilesException.class, () -> acc.addProfile(new Profile("John Doe")));

    }
}
