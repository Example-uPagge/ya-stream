package dev.struchkov.yandex.stream.example;

import dev.struchkov.yandex.stream.Company;
import dev.struchkov.yandex.stream.Worker;
import dev.struchkov.yandex.stream.Workers;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dev.struchkov.yandex.stream.Workers.getWorkers;
import static dev.struchkov.yandex.stream.Workers.getWorkersTwo;

public class StreamExample {

    public static void main(String[] args) {
        final Collection<Worker> workers = getWorkers();

        exampleOne(workers);
        exampleFlatMap();
        exampleConcat();
        exampleReduce();
        exampleMatch();
//        exampleSort();
    }

    private static void exampleOne(Collection<Worker> workers) {
        final Stream<Worker> developerStream = workers.stream()
                .filter(worker -> Workers.DEVELOPER.equals(worker.getPosition()));

        final Stream<Worker> zamSeoStream = workers.stream()
                .filter(worker -> Workers.ZAM_SEO.equals(worker.getPosition()));

        final List<Worker> developers = developerStream
                .collect(Collectors.toList());

//        final List<Worker> twoDevelopers = developerStream
//                .filter(worker -> worker.getAge() > 30)
//                .toList();

        final List<String> collect = workers.stream()
                .filter(worker -> worker.getAge() < 31)
                .map(Worker::getName)
                .toList();
        System.out.println(collect);
    }

    private static void exampleFlatMap() {
        final Company companyOne = new Company(getWorkers());
        final Company companyTwo = new Company(getWorkersTwo());

        final List<Company> companies = List.of(companyOne, companyTwo);
        final Map<Integer, Worker> workerMap = companies.stream()
                .flatMap(company -> company.getWorkers().stream())
                .filter(worker -> worker.getAge() > 40)
                .collect(Collectors.toMap(Worker::getAge, worker -> worker));
    }

    private static void exampleConcat() {
        final Stream<Worker> workers = getWorkers().stream();
        final Stream<Worker> workersTwo = getWorkersTwo().stream();

        final Optional<Worker> worker = Stream.concat(
                workers, workersTwo
        ).findFirst();
    }

    private static void exampleReduce() {
        final Integer sum = Stream.iterate(1, n -> n + 2)
                .limit(10)
                .peek(System.out::println)
                .reduce((a, b) -> a + b)
                .get();
        System.out.println();
        System.out.println(sum);
    }

    private static void exampleMatch() {
        final Collection<Worker> workers = getWorkers();
        final boolean isKate = workers.stream()
                .anyMatch(worker -> "Катя".equals(worker.getName()));
        System.out.println(isKate);
        final boolean isAllKate = workers.stream()
                .allMatch(worker -> "Катя".equals(worker.getName()));
        System.out.println(isAllKate);
    }

    private static void exampleSort() {
        final Collection<Worker> workers = getWorkers();
        System.out.println();
        workers.stream()
                .forEach(System.out::println);

        System.out.println();
        workers.stream()
                .sorted(new Comparator<Worker>() {
                    @Override
                    public int compare(Worker w1, Worker w2) {
                        return w1.getAge() - w2.getAge();
                    }
                }).forEach(System.out::println);
    }

}
