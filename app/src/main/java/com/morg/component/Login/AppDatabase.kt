import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [User::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
}