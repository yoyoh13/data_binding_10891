package com.yohanes.data_binding_10891

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

object FakeRepository {
    private val fruitNames: List<String> = listOf(
        "Apel", "mangga", "Pisang", "Anggur", "Stroberi",
        "Jambu", "Rasberi", "Bambu", "Kiwi", "Pir"
    )

    private  val _currentRandomFruit = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruit

    init {
        _currentRandomFruit.value = fruitNames.first()
    }

    fun getRandomfruitName(): String {
        val random = Random.nextInt(fruitNames.size)
        return fruitNames[random]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruit.value = getRandomfruitName()
    }
}