package id.iruna.roomtester.database

import android.arch.persistence.db.SupportSQLiteQuery
import android.arch.persistence.room.*
import id.iruna.roomtester.vo.Person
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by aditrioka on 21/02/18.
 */

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Query("SELECT * FROM person")
    fun getAllPersons(): Flowable<MutableList<Person>>

    @Query("SELECT * FROM person WHERE name LIKE '%' || :name || '%'")
    fun getByName(name: String): Flowable<MutableList<Person>>

    @RawQuery(observedEntities = arrayOf(Person::class))
    fun getByRawQuery(query: SupportSQLiteQuery): Flowable<MutableList<Person>>

    @RawQuery(observedEntities = arrayOf(Person::class))
    fun getCounts(query: SupportSQLiteQuery): Flowable<Long>
}