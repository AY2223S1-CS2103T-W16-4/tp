package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyMyInsuRec;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of MyInsuRec data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private MyInsuRecStorage addressBookStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code MyInsuRecStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(MyInsuRecStorage addressBookStorage, UserPrefsStorage userPrefsStorage) {
        this.addressBookStorage = addressBookStorage;
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
        return addressBookStorage.getMyInsuRecFilePath();
    }

    @Override
    public Optional<ReadOnlyMyInsuRec> readMyInsuRec() throws DataConversionException, IOException {
        return readMyInsuRec(addressBookStorage.getMyInsuRecFilePath());
    }

    @Override
    public Optional<ReadOnlyMyInsuRec> readMyInsuRec(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readMyInsuRec(filePath);
    }

    @Override
    public void saveMyInsuRec(ReadOnlyMyInsuRec addressBook) throws IOException {
        saveMyInsuRec(addressBook, addressBookStorage.getMyInsuRecFilePath());
    }

    @Override
    public void saveMyInsuRec(ReadOnlyMyInsuRec addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveMyInsuRec(addressBook, filePath);
    }

}
