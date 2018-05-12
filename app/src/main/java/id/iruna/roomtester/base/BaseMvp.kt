package id.iruna.roomtester.base

interface BaseMvp {
    interface Model {

    }

    interface View<T> {

    }

    interface Presenter<T> {
        fun setView(view: T?)
        fun rxUnsubscribe()
    }
}