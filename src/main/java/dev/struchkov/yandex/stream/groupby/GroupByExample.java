package dev.struchkov.yandex.stream.groupby;

import dev.struchkov.yandex.stream.Worker;
import dev.struchkov.yandex.stream.Workers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupByExample {

    public static void main(String[] args) {
        final Collection<Worker> workers = Workers.getWorkers();

        System.out.println("Группировка по должности (списки)");
        final Map<String, List<Worker>> positionList = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        System.out.println("Группировка по должности (множества)");
        final Map<String, Set<Worker>> positionSet = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        System.out.println("Подсчет количества рабочих, занимаемых конкретную должность");
        final Map<String, Long> map3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        System.out.println("Группировка списка рабочих по их должности, при этом нас интересуют только имена");
        final Map<String, Set<String>> map4 = workers.stream()
                .collect(
                        Collectors.groupingBy(Worker::getPosition,
                                Collectors.mapping(Worker::getName, Collectors.toSet()))
                );

        System.out.println("Расчет средней зарплаты для данной должности");
        final Map<String, Double> collect = workers.stream()
                .collect(
                        Collectors.groupingBy(
                                Worker::getPosition,
                                Collectors.averagingLong(Worker::getSalary)
                        )
                );

        System.out.println("Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой");
        final Map<String, String> map6 = workers.stream()
                .collect(
                        Collectors.groupingBy(
                                Worker::getPosition,
                                Collectors.mapping(
                                        Worker::getName,
                                        Collectors.joining(", ", "{", "}")
                                )
                        )
                );

        System.out.println("Группировка списка рабочих по их должности и по возрасту.");
        final Map<String, Map<Integer, List<Worker>>> map7 = workers.stream()
                .collect(
                        Collectors.groupingBy(
                                Worker::getPosition,
                                Collectors.groupingBy(Worker::getAge)
                        )
                );

        System.out.println();
    }

}
