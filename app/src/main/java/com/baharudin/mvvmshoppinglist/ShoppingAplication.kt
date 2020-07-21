package com.baharudin.mvvmshoppinglist

import android.app.Application
import com.baharudin.mvvmshoppinglist.data.db.ShoppingDatabase
import com.baharudin.mvvmshoppinglist.data.repository.ShoppingRepository
import com.baharudin.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingAplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingAplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton {
            ShoppingRepository(
                instance()
            )
        }
        bind() from provider {
            ShoppingViewModelFactory(
                instance())
        }

    }

}