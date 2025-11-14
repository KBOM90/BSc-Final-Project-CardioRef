package com.example.cardioref_homepage;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class AndroidJUnit4 extends Runner {
    Class testClass;

    public AndroidJUnit4(Class testClass) {
        this.testClass = testClass;
    }

    @Override
    public Description getDescription() {
        return null;
    }

    @Override
    public void run(RunNotifier notifier) {

    }
}
