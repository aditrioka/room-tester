package id.iruna.roomtester.main

import id.iruna.roomtester.base.BaseMvp
import id.iruna.roomtester.vo.Person
import io.reactivex.Flowable

interface MainMvp {
    interface Model: BaseMvp.Model {
        fun insertPerson(person: Person)

        fun getAllPersons(): Flowable<MutableList<Person>>

        fun getByName(name: String): Flowable<MutableList<Person>>

        fun getByRawQuery(query: String): Flowable<MutableList<Person>>

        fun getCounts(query: String): Flowable<Long>
    }

    interface View: BaseMvp.View<Presenter> {
        fun getName(): String

        fun getAge(): String

        fun getHobby(): String

        fun getSearchedName(): String

        fun getWhereClause(): String

        fun displayAllRecords(records: String): Unit

        fun displaySearchResult(searchResult: String): Unit

        fun displaySearchResultByWhereClause(searchResult: String): Unit
    }

    interface Presenter: BaseMvp.Presenter<View> {
        fun submitData()

        fun getAllRecords()

        fun searchByName()

        fun searchByWhereClause()
    }
}