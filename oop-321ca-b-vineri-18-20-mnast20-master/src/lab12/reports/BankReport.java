package lab12.reports;

import lab12.entities.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {

        return bank.getClients().stream()
                .map(Business::getEmployees)
                .toList().stream().mapToInt(Set::size).sum();
    }

    public static int getNumberOfAccounts(Bank bank) {

        return bank.getClients().stream().map(Business::getEmployees).
                flatMap(Set::stream).collect(Collectors.toSet()).
                stream().map(Employee::getAccounts).flatMap(Set::stream).collect(Collectors.toSet()).size();
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order

        Comparator<Employee> byName = Comparator.comparing(Employee::getName);

        Set<Employee> employeeSet = bank.getClients().stream().map(Business::getEmployees).
                flatMap(Set::stream).collect(Collectors.toSet());
        Supplier<TreeSet<Employee>> sortedEmployee = () -> new TreeSet<>(byName);

        return employeeSet.stream().collect(Collectors.toCollection(sortedEmployee));
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances

        return bank.getClients().stream().map(Business::getEmployees).flatMap(Set::stream).
                collect(Collectors.toSet()).stream().map(Employee::getAccounts).flatMap(Set::stream).
                collect(Collectors.toSet()).stream().mapToDouble(Account::getBalance).sum();
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance
        Comparator<Account> byBalance = Comparator.comparing(Account::getBalance).thenComparing(Account::getId);

        Set<Account> accountSet = bank.getClients().stream().
                map(Business::getEmployees).flatMap(Set::stream).collect(Collectors.toSet()).
                stream().map(Employee::getAccounts).flatMap(Set::stream).collect(Collectors.toSet());

        Supplier<TreeSet<Account>> sortedAccount = () -> new TreeSet<>(byBalance);

        return accountSet.stream().collect(Collectors.toCollection(sortedAccount));
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts

        Set<Employee> employeeSet = bank.getClients().stream().
                map(Business::getEmployees).flatMap(Set::stream).collect(Collectors.toSet());

        return employeeSet.stream().collect(Collectors.toMap(Function.identity(), Employee::getAccounts));
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities

        Set<Employee> employeeSet = bank.getClients().stream().
                map(Business::getEmployees).flatMap(Set::stream).collect(Collectors.toSet());

        return employeeSet.stream().
                collect(Collectors.groupingBy(Employee::getCity));
    }

    public static Project getProjectWorkedOnByMostCustomers(Bank bank) {
        // Get all the projects from the employees and find the most repeated one in the list

        Set<Employee> employeeSet = bank.getClients().stream().
                map(Business::getEmployees).flatMap(Set::stream).collect(Collectors.toSet());

        List<Project> projects = bank.getClients().stream().
                map(Business::getEmployees).flatMap(Set::stream).collect(Collectors.toSet()).
                stream().map(Employee::getProjects).flatMap(List::stream).collect(Collectors.toList());

        Project maxProject = null;
        long maxAppearances = 0L;

        for (Project project: projects) {

            Function <Employee, Long> getAppearance =
                    employee -> employee.getProjects().stream().filter(p -> p == project).count();

            Long appearances = employeeSet.stream().map(getAppearance).toList().
                    stream().reduce(0L, Long::sum);

            if (appearances > maxAppearances) {
                maxProject = project;
            }
        }

        return maxProject;
    }

    public static Gender getGenderWhoWorkedOnMostProjects(Bank bank) {
        // Get all the pairs <gender, project> or <gender, List<project>>, then reduce the array to only one pair
        // of each gender and retrieve the one with most counted projects (you are expected to count duplicates as well).

        Set<Employee> employeeSet = bank.getClients().stream().
                map(Business::getEmployees).flatMap(Set::stream).collect(Collectors.toSet());

        List<Pair<Gender, List<Project>>> projectsByGenders = new ArrayList<>();

        List<Pair<Gender, List<Project>>> pairs =
                employeeSet.stream().map(employee -> new Pair<>(employee.getGender(), employee.getProjects())).toList();

        projectsByGenders.add(pairs.stream().reduce((p1, p2) -> {
            List<Project> projectGender = new ArrayList<>();

            if (p1.key != Gender.FEMALE && p2.key == Gender.FEMALE) {
                return p2;
            }

            if (p1.key == p2.key && p1.key == Gender.FEMALE) {
                projectGender.addAll(p1.value);
                projectGender.addAll(p2.value);

                return new Pair<>(p1.key, projectGender);
            }

            return p1;
        }).orElseThrow(IllegalArgumentException::new));

        projectsByGenders.add(pairs.stream().reduce((p1, p2) -> {
            List<Project> projectGender = new ArrayList<>();

            if (p1.key != Gender.MALE && p2.key == Gender.MALE) {
                return p2;
            }

            if (p1.key == p2.key && p1.key == Gender.MALE) {
                projectGender.addAll(p1.value);
                projectGender.addAll(p2.value);

                return new Pair<>(p1.key, projectGender);
            }
            return p1;
        }).orElseThrow(IllegalArgumentException::new));

        return projectsByGenders.stream().max(Comparator.comparingInt(pair -> pair.value.size())).
                orElseThrow(IllegalArgumentException::new).key;
    }
}