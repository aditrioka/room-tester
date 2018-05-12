package id.iruna.roomtester.dependencyinjection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import id.iruna.roomtester.root.AppModule
import id.iruna.roomtester.root.RoomApp
import javax.inject.Singleton

/**
 * Created by aditrioka on 21/02/18.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class
        ))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: RoomApp)
}