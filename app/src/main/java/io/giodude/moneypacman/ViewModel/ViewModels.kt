package io.giodude.moneypacman.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.giodude.moneypacman.Model.AdDisModel
import io.giodude.moneypacman.Model.WayModel
import io.giodude.moneypacman.Network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ViewModels: ViewModel() {

    private val apiService = ApiService()
    private val disposable = CompositeDisposable()

    val wayData = MutableLiveData<List<WayModel>?>()
    val adData = MutableLiveData<List<AdDisModel>?>()


    val homeLoadError = MutableLiveData<Boolean>()

    fun wayData(){
        getWay()
    }

    fun adData(){
        getAD()
    }

    private fun getWay(){
        disposable.add(
            apiService.getWay()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<WayModel>>() {
                    override fun onSuccess(value: List<WayModel>?) {
                        wayData.value = value!!
                        homeLoadError.value = false
                    }

                    override fun onError(e: Throwable?) {
                        homeLoadError.value = true
                    }
                })
        )
    }

    private fun getAD(){
        disposable.add(
            apiService.getAD()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<AdDisModel>>() {
                    override fun onSuccess(value: List<AdDisModel>?) {
                        adData.value = value!!
                        homeLoadError.value = false
                    }

                    override fun onError(e: Throwable?) {
                        homeLoadError.value = true
                    }
                })
        )
    }
}