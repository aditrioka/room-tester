package id.iruna.roomtester.repository

import android.arch.persistence.db.SupportSQLiteQuery
import id.iruna.roomtester.vo.Person
import io.reactivex.Flowable

interface Repo {
    fun insertPerson(person: Person)

    fun getAllPersons(): Flowable<MutableList<Person>>

    fun getByName(name: String): Flowable<MutableList<Person>>

    fun getByRawQuery(query: SupportSQLiteQuery): Flowable<MutableList<Person>>

    fun getCounts(query: SupportSQLiteQuery): Flowable<Long>
}