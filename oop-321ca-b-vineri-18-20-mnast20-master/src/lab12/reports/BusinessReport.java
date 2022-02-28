package lab12.reports;

import lab12.entities.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess

        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDisability));
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count

        List<Employee> femaleEmployees = business.getEmployees().stream().filter(employee -> employee.getGender() == Gender.FEMALE).toList();
        return femaleEmployees.stream().map(Employee::getProjects).flatMap(List::stream).collect(Collectors.toSet()).size();
    }

    public static SortedSet<Employee> getEmployeesMaxByReligionMinByGenderSortedByCitySortedByAge(Business business) {
        // Get the employees with majority by religion, from this group select the subgroup that has the minority by gender
        // Sort the set by city and, in case of equality, by age
        Map<Religion, List<Employee>> employeesByReligion =
                business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion));

        Map.Entry<Religion, List<Employee>> religionListEntry = employeesByReligion.entrySet().
                stream().max(Comparator.comparingInt(map -> map.getValue().size())).orElseThrow(IllegalArgumentException::new);

        List<Employee> employeesMajorityReligion = religionListEntry.getValue();

        Map<Gender, List<Employee>> employeesByGenderWithMajorityReligion =
                employeesMajorityReligion.stream().collect(Collectors.groupingBy(Employee::getGender));

        Map.Entry<Gender, List<Employee>> genderListEntryMin = employeesByGenderWithMajorityReligion.entrySet().
                stream().min(Comparator.comparingInt(map -> map.getValue().size())).orElseThrow(IllegalArgumentException::new);

        List<Employee> minorityGenderEmployees = genderListEntryMin.getValue();

        Comparator<Employee> comparator = Comparator.comparing(Employee::getCity).thenComparing(Employee::getAge);

        Supplier<TreeSet<Employee>> sortedEmployees = () -> new TreeSet<>(comparator);

        return minorityGenderEmployees.stream().collect(Collectors.toSet()).
                stream().collect(Collectors.toCollection(sortedEmployees));
    }

    public static Religion getReligionOfEmployeesWithMostAccounts(Business business) {
        // Group employees by religion, count the accounts in each group, return the religion with biggest score

        Map<Religion, List<Employee>> employeesByReligion =
                business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion));

        Map.Entry<Religion, List<Employee>> religionListEntry = employeesByReligion.entrySet().
                        stream().max(Comparator.comparingInt(map -> map.getValue().
                        stream().map(Employee::getAccounts).flatMap(Set::stream).
                        collect(Collectors.toSet()).size())).orElseThrow(IllegalArgumentException::new);

        return religionListEntry.getKey();
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        // Map the employees by religion (Map<Religion, List<Employee>>) then map each of the lists by gender (Map<Gender, List<Employee>>)
        // Hint: use Collectors.groupingBy(Function, Collector)

        return business.getEmployees().stream().
                collect(Collectors.groupingBy(Employee::getReligion, Collectors.groupingBy(Employee::getGender)));
    }

    public static Map<Project, Map<String, List<Employee>>> getEmployeesOnSameProjectAndCity(Business business) {
    // Map the employees to the business projects (not to their respective projects)

        Map<Project, Map<String, List<Employee>>> employeesOnSameProjectAndCity = new HashMap<>();

        for (Project project : business.getProjects()) {
            List<Employee> employeesWhoWorkedOnBusinessProject =
                business.getEmployees().stream().filter(e -> e.getProjects().contains(project)).toList();

            employeesOnSameProjectAndCity.put(project, employeesWhoWorkedOnBusinessProject.stream().
                    collect(Collectors.groupingBy(Employee::getCity)));
        }

        return employeesOnSameProjectAndCity;
    }
}