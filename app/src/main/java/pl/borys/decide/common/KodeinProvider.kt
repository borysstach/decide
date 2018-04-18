package pl.borys.decide.common

import android.arch.lifecycle.ViewModelProviders
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.factory
import pl.borys.decide.usecase.vote.model.fakeVoteModule
import pl.borys.decide.usecase.vote.viewModel.VoteViewModel

object KodeinProvider {
    var kodeinInstance = Kodein {
        bind<VoteViewModel>() with factory { fragment: Fragment -> ViewModelProviders.of(fragment).get(VoteViewModel::class.java) }
        import(fakeVoteModule)
    }
        private set

    @VisibleForTesting()
    fun override(kodein: Kodein) {
        kodeinInstance = kodein
    }
}