package id.iruna.roomtester.main

import android.arch.persistence.db.SimpleSQLiteQuery
import id.iruna.roomtester.repository.Repo
import id.iruna.roomtester.vo.Person
import io.reactivex.Flowable

class MainActivityModel(val repo: Repo): MainMvp.Model {
    override fun insertPerson(person: Person) {
        repo.insertPerson(person)
    }

    override fun getAllPersons(): Flowable<MutableList<Person>> {
        return repo.getAllPersons()
    }

    override fun getByName(name: String): Flowable<MutableList<Person>> {
        return repo.getByName(name)
    }

    override fun getByRawQuery(query: String): Flowable<MutableList<Person>> {
        return repo.getByRawQuery(SimpleSQLiteQuery(query))
    }

    override fun getCounts(query: String): Flowable<Long> {
        return repo.getCounts(SimpleSQLiteQuery(query))
    }

}