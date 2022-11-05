package seedu.myinsurec.model;

import java.nio.file.Path;

import seedu.myinsurec.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getMyInsuRecFilePath();

}
