package dev.struchkov.yandex.stream;

import java.util.Collection;

public class Company {

    private Collection<Worker> workers;

    public Company(Collection<Worker> workers) {
        this.workers = workers;
    }

    public Collection<Worker> getWorkers() {
        return workers;
    }

}
