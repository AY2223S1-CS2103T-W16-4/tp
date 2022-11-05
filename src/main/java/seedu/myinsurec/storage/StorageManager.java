package seedu.myinsurec.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.myinsurec.commons.core.LogsCenter;
import seedu.myinsurec.commons.exceptions.DataConversionException;
import seedu.myinsurec.model.ReadOnlyMyInsuRec;
import seedu.myinsurec.model.ReadOnlyUserPrefs;
import seedu.myinsurec.model.UserPrefs;

/**
 * Manages storage of MyInsuRec data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private MyInsuRecStorage myInsuRecStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code MyInsuRecStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(MyInsuRecStorage myInsuRecStorage, UserPrefsStorage userPrefsStorage) {
        this.myInsuRecStorage = myInsuRecStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ MyInsuRec methods ==============================

    @Override
    public Path getMyInsuRecFilePath() {
        return myInsuRecStorage.getMyInsuRecFilePath();
    }

    @Override
    public Optional<ReadOnlyMyInsuRec> readMyInsuRec() throws DataConversionException, IOException {
        return readMyInsuRec(myInsuRecStorage.getMyInsuRecFilePath());
    }

    @Override
    public Optional<ReadOnlyMyInsuRec> readMyInsuRec(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return myInsuRecStorage.readMyInsuRec(filePath);
    }

    @Override
    public void saveMyInsuRec(ReadOnlyMyInsuRec myInsuRec) throws IOException {
        saveMyInsuRec(myInsuRec, myInsuRecStorage.getMyInsuRecFilePath());
    }

    @Override
    public void saveMyInsuRec(ReadOnlyMyInsuRec myInsuRec, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        myInsuRecStorage.saveMyInsuRec(myInsuRec, filePath);
    }

}
