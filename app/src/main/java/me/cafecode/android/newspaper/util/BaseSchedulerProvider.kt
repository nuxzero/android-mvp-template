package me.cafecode.android.newspaper.util

import io.reactivex.Scheduler
import org.jetbrains.annotations.NotNull

interface BaseSchedulerProvider {

    @NotNull fun computation(): Scheduler

    @NotNull fun io(): Scheduler

    @NotNull fun ui(): Scheduler

}
