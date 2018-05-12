package id.iruna.roomtester.main

import dagger.Module
import dagger.Provides
import id.iruna.roomtester.repository.Repo

/**
 * Created by aditrioka on 21/02/18.
 */

@Module
class MainActivityModule {

    @Provides
    fun providePresenter(model: MainMvp.Model): MainMvp.Presenter {
        return MainActivityPresenter(model)
    }

    @Provides
    fun provideModel(repo: Repo): MainMvp.Model {
        return MainActivityModel(repo)
    }
}