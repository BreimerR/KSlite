package libetal.libraries.sqlite

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import libetal.interop.*

class KSqlite(private val databaseName: String, val version: Int) {

    private var _connection: CPointer<sqlite3>? = null

    // TODO replace with laziest
    val connection
        get() = _connection ?: open("$databaseName.db").also {
            _connection = it
        }

    companion object {
        fun open(filePath: String): CPointer<sqlite3>? {
            val database = sqlite3Pointer()
            sqlite3_open(filePath, sqlite3PointerReference(database))
            return database;
        }

    }
}