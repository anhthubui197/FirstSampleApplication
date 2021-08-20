package com.anhthubui.ultils;

import io.reactivex.Scheduler;

public interface ISchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
