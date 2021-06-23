package communication;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CollectionInfo implements Serializable {
    private final LocalDate lastUpdate;
    private final Date initializationDate;
    private final int size;
    private final Class collectionClass;

    public CollectionInfo(LocalDate lastUpdate, Date initializationDate, int size, Class collectionClass) {
        this.lastUpdate = lastUpdate;
        this.initializationDate = initializationDate;
        this.size = size;
        this.collectionClass = collectionClass;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public Date getInitializationDate() {
        return initializationDate;
    }

    public int getSize() {
        return size;
    }

    public Class getCollectionClass() {
        return collectionClass;
    }
}
