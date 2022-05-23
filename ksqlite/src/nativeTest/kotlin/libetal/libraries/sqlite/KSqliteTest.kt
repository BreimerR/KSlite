package libetal.libraries.sqlite

import kotlin.test.Test

class KSqliteTest {

    @Test
    fun initClass() {
        val instance = KSqlite("test", 1);
        println(instance.connection)
    }

}