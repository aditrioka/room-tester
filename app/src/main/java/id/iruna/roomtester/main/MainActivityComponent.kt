package id.iruna.roomtester.main

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by aditrioka on 21/02/18.
 */

@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent: AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>() {

    }
}