package id.iruna.roomtester.main

import android.arch.persistence.db.SimpleSQLiteQuery
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import dagger.android.AndroidInjection
import id.iruna.roomtester.PersonAdapter
import id.iruna.roomtester.R
import id.iruna.roomtester.database.MyDatabase
import id.iruna.roomtester.vo.Person
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainMvp.View {
    @Inject lateinit var database: MyDatabase
    @Inject lateinit var presenter: MainMvp.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getAllRecords()

        btnSubmit.setOnClickListener {
            try {
                val name = getName()
                val age = getAge().toInt()
                val hobby = getHobby()

                if (!(name.equals("") || age.equals("") || hobby.equals(""))) {
                    presenter.submitData()
                }
            } catch (e: NumberFormatException) {
                // TODO: handle error here
            }
        }

        btnSearchByName.setOnClickListener { _ ->
            presenter.searchByName()
        }

        btnSearchByWhereClause.setOnClickListener {
            presenter.searchByWhereClause()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.rxUnsubscribe()
    }

    override fun getName(): String {
        return etName.text.toString()
    }

    override fun getAge(): String {
        return etAge.text.toString()
    }

    override fun getHobby(): String {
        return etHobby.text.toString()
    }

    override fun getSearchedName(): String {
        return etSearchByName.text.toString()
    }

    override fun getWhereClause(): String {
        return etSearchByWhereClause.text.toString()
    }

    override fun displayAllRecords(records: String) {
        this.tvContainer.text = records
    }

    override fun displaySearchResult(searchResult: String) {
        tvSearchResultByName.text = searchResult
    }

    override fun displaySearchResultByWhereClause(searchResult: String) {
        tvSearchResultByWhereClause.text = searchResult
    }
}
