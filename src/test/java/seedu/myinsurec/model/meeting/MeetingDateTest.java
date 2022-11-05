package seedu.myinsurec.model.meeting;

import static seedu.myinsurec.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MeetingDateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MeetingDate(null));
    }

}
