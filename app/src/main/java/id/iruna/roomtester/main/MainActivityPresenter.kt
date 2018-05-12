package id.iruna.roomtester.main

import android.util.Log
import id.iruna.roomtester.vo.Person
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivityPresenter(var model: MainMvp.Model): MainMvp.Presenter {
    private var disposables: CompositeDisposable = CompositeDisposable()
    private var view: MainMvp.View? = null

    override fun setView(view: MainMvp.View?) {
        this.view = view
    }

    override fun submitData() {
        if (!view!!.getName().equals("") &&
                !view!!.getAge().equals("") &&
                !view!!.getHobby().equals("")) {

            val name = view!!.getName()
            val age = view!!.getAge().toInt()
            val hobby = view!!.getHobby()

            Log.v(TAG, "before executors")
            Log.v(TAG, "name: $name")
            Log.v(TAG, "age: $age")
            Log.v(TAG, "hobby: $hobby")

            Executors.newSingleThreadExecutor().execute {
                model.insertPerson(Person(name, age, hobby))
            }
        }

    }

    override fun getAllRecords() {

            disposables.add(
                    model.getAllPersons()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    { people ->
                                        view!!.displayAllRecords(people.toString())
                                    },
                                    { trowable ->
                                        // TODO: handle error
                                    }
                            )
            )

    }

    override fun searchByName() {
        disposables.add(
                model.getByName(view!!.getSearchedName())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { people ->
                                    if (people.size == 0) {
                                        view!!.displaySearchResult("NOT FOUND")
                                    } else {
                                        view!!.displaySearchResult(people.toString())
                                    }
                                },
                                { throwable ->
                                    // TODO: handle error
                                }
                        )
        )
    }

    override fun searchByWhereClause() {
        disposables.add(
                model.getByRawQuery(view!!.getWhereClause())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result ->
                                    if (result.size == 0) {
                                        view!!.displaySearchResultByWhereClause("NOT FOUND")
                                    } else {
                                        view!!.displaySearchResultByWhereClause(result.toString())
                                    }
                                },
                                { throwable ->
                                    // TODO: handle error
                                }
                        )
        )
    }

    override fun rxUnsubscribe() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    companion object {
        val TAG = MainActivityPresenter::class.java.simpleName
    }
}
