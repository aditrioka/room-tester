package id.iruna.roomtester.repository

import android.arch.persistence.db.SupportSQLiteQuery
import id.iruna.roomtester.database.MyDatabase
import id.iruna.roomtester.vo.Person
import io.reactivex.Flowable

class Repository(val database: MyDatabase): Repo {

    override fun insertPerson(person: Person) {
        database.personDao().insertPerson(person)
    }

    override fun getAllPersons(): Flowable<MutableList<Person>> {
        return database.personDao().getAllPersons()
    }

    override fun getByName(name: String): Flowable<MutableList<Person>> {
        return database.personDao().getByName(name)
    }

    override fun getByRawQuery(query: SupportSQLiteQuery): Flowable<MutableList<Person>> {
        return database.personDao().getByRawQuery(query)
    }

    override fun getCounts(query: SupportSQLiteQuery): Flowable<Long> {
        return database.personDao().getCounts(query)
    }

}