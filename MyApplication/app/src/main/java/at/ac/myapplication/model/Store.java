package at.ac.myapplication.model;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class Store {
    public final BehaviorSubject<Model> subject;

    @Inject
    public Store() {
        subject = BehaviorSubject.createDefault(new Model());
    }
}
