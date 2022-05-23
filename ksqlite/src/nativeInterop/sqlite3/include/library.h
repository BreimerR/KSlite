#include <sqlite3.h>


static sqlite3 *sqlite3Pointer() {
    sqlite3 *database;
    return database;
}

static sqlite3 **sqlite3PointerReference(sqlite3 *database) {
    return &database;
}

static sqlite3 *Sqlite3(const char *filePath) {

    sqlite3 *database;

    int connectionState = sqlite3_open(filePath, &database);

    return database;

}