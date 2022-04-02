package com.ebookfrenzy.lifecycleawareness

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import com.ebookfrenzy.lifecycleawareness.ui.main.MainViewModel


class DemoObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        MainViewModel.print("onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        MainViewModel.print("onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        MainViewModel.print("onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        MainViewModel.print("onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        MainViewModel.print("onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        MainViewModel.print("onDestroy")
    }

    //@OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    //fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
    //    MainViewModel.print("onAny")
    //}

}