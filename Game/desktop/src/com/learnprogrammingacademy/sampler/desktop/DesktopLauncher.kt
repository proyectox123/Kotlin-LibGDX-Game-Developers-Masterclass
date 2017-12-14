package com.learnprogrammingacademy.sampler.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.learnprogrammingacademy.sampler.GdxSamplerGame

fun main(args: Array<String>) {
    LwjglApplication(GdxSamplerGame(), LwjglApplicationConfiguration())
}