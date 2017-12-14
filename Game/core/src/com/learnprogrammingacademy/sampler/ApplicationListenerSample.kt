package com.learnprogrammingacademy.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Logger

class ApplicationListenerSample : ApplicationListener{

    private val log = Logger(ApplicationListenerSample::class.java.simpleName, Logger.DEBUG)
    private var renderInterrupted = true

    override fun create() {
        //Used to initialize game and load resources
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug( "create()")
    }

    override fun resize(width: Int, height: Int) {
        //Used to handle setting a new screen size
        log.debug( "resize($width, $height)")
    }

    override fun render() {
        //Used to update and render the game elements called 60 timer per second
        if(renderInterrupted){
            log.debug( "render()")
            renderInterrupted = false
        }
    }

    override fun pause() {
        //Used to save game state when it loses focus, which does not involve the actual
        //game play being paused unless the developer wants to pause
        log.debug( "pause()")
        renderInterrupted = true
    }

    override fun resume() {
        //Used to handle the game coming back from being paused and restores game state
        log.debug( "resume()")
        renderInterrupted = true
    }

    override fun dispose() {
        //Used to free resources and clean up
        log.debug( "dispose()")
    }
}