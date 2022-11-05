package seedu.myinsurec.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.myinsurec.commons.exceptions.DataConversionException;
import seedu.myinsurec.model.ReadOnlyMyInsuRec;
import seedu.myinsurec.model.ReadOnlyUserPrefs;
import seedu.myinsurec.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends MyInsuRecStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getMyInsuRecFilePath();

    @Override
    Optional<ReadOnlyMyInsuRec> readMyInsuRec() throws DataConversionException, IOException;

    @Override
    void saveMyInsuRec(ReadOnlyMyInsuRec myInsuRec) throws IOException;

}
