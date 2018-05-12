package id.iruna.roomtester.root

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import id.iruna.roomtester.database.MyDatabase
import id.iruna.roomtester.database.PersonDao
import id.iruna.roomtester.main.MainActivityComponent
import id.iruna.roomtester.repository.Repo
import id.iruna.roomtester.repository.Repository
import javax.inject.Singleton

/**
 * Created by aditrioka on 21/02/18.
 */

@Module(subcomponents = arrayOf(MainActivityComponent::class))
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun providePersonDao(database: MyDatabase): PersonDao {
        return database.personDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MyDatabase {
        return Room.databaseBuilder(app, MyDatabase::class.java, "my.db").build()
    }

    @Provides
    @Singleton
    fun provideRepository(database: MyDatabase): Repo {
        return Repository(database)
    }
}