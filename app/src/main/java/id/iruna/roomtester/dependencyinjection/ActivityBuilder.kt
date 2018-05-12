package id.iruna.roomtester.dependencyinjection

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import id.iruna.roomtester.main.MainActivity
import id.iruna.roomtester.main.MainActivityComponent

/**
 * Created by aditrioka on 21/02/18.
 */

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}