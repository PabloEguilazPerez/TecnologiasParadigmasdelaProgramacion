package gestionDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalDB {

	// Inner class for Employee data
	public static class Employee {
		private long id;
		private String name;
		private String department;
		private String role;
		private double salary;
		private int age;
		private int yearsAtCompany;
		private String city;
		private double performanceScore;

		public Employee(long id, String name, String department, String role, double salary, int age,
				int yearsAtCompany, String city, double performanceScore) {
			this.id = id;
			this.name = name;
			this.department = department;
			this.role = role;
			this.salary = salary;
			this.age = age;
			this.yearsAtCompany = yearsAtCompany;
			this.city = city;
			this.performanceScore = performanceScore;
		}

		// Getters
		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getDepartment() {
			return department;
		}

		public String getRole() {
			return role;
		}

		public double getSalary() {
			return salary;
		}

		public int getAge() {
			return age;
		}

		public int getYearsAtCompany() {
			return yearsAtCompany;
		}

		public String getCity() {
			return city;
		}

		public double getPerformanceScore() {
			return performanceScore;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' + ", dept='" + department + '\'' + ", role='" + role + '\''
					+ ", salary=" + salary + '}';
		}
	}

	public static void main(String[] args) {
		// 0. Load Data
		List<Employee> employees = loadEmployees("employees.csv");
		if (employees.isEmpty()) {
			System.out.println("No employees loaded. Check file path.");
			return;
		}
		System.out.println("Loaded " + employees.size() + " employees.");

		Scanner scanner = new Scanner(System.in);
		while (true) {
			printMenu();
			System.out.print("Choose an option: ");
			String input = scanner.nextLine();

			try {
				int option = Integer.parseInt(input);
				if (option == 0) {
					System.out.println("Exiting...");
					break;
				}

				switch (option) {
				case 1:
					showEmployeeDirectory(new ArrayList<>(employees)); // Pass a copy to avoid sorting the master list
																		// permanently
					break;
				case 2:
					showTalentRetention(employees);
					break;
				case 3:
					showCompensationAnalysis(employees);
					break;
				case 4:
					showHRAnalytics(employees);
					break;
				case 5:
					showDataQualityReport(employees);
					break;
				case 6: // Optional 1: Dynamic Filtering
					List<Predicate<Employee>> rules = new ArrayList<>();
					rules.add(e -> e.getSalary() > 50000);
					rules.add(e -> e.getDepartment().equals("IT"));
					filterEmployees(employees, rules);
					break;
				case 7: // Optional 2: Comparator Composition
					sortEmployeesComplex(new ArrayList<>(employees));
					break;
				case 8: // Optional 3: Average salary per Dept
					showAverSalaryDepartment(employees);
					break;
				default:
					System.out.println("Invalid option. Please try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
			System.out.println("\nPress Enter to continue...");
			scanner.nextLine();
		}
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("\n--------------------------------------------------");
		System.out.println("HR MANAGEMENT SYSTEM");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Employee Directory (Sort by Name)");
		System.out.println("2. Talent Retention (Senior High-Performers)");
		System.out.println("3. Compensation (Bonus Calculations)");
		System.out.println("4. HR Analytics Dashboard");
		System.out.println("5. Data Quality Report");
		System.out.println("6. [Optional] Dynamic Filtering");
		System.out.println("7. [Optional] Complex Sorting Comp.");
		System.out.println("8. [Optional] Average salary per Dept");
		System.out.println("0. Exit");
		System.out.println("--------------------------------------------------");
	}

	// 1. Employee Directory (Sort by Name)
	private static void showEmployeeDirectory(List<Employee> employees) {
		System.out.println("\n--- 1. Employee Directory (Sorted by Name) ---");
		System.out.println("Sorting employees by name using Collections.sort() with a lambda expression...");
		
		// TODO Sort employees by name with a lambda expression

		employees.stream()
				.sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()))
				.limit(5)
				.forEach(e -> System.out.println(e));
	}

	// 2. Talent Retention (Senior High-Performers)
	private static void showTalentRetention(List<Employee> employees) {
		System.out.println("\n--- 2. Talent Retention (Senior High-Performers) ---");

		// TODO Show the name of the employees of the to 10 sorted in descending order
		// by performance score with a score equal or grater than 4.5 and more than 5
		// year at the company
		
		employees.stream()
				.filter(e -> e.getPerformanceScore() >= 4.5 && e.getYearsAtCompany() > 5)
				.sorted((e1, e2) -> Double.compare(e2.getPerformanceScore(), e1.getPerformanceScore()))
				.limit(10)
				.forEach(e -> System.out.println(e.getPerformanceScore() + " - " + e.getName()));

	}

	// 3. Compensation (Bonus Calculations)
	private static void showCompensationAnalysis(List<Employee> employees) {
		System.out.println("\n--- 3. Compensation (Bonus Calculations) ---");

		// TODO Show for the first 5 employees the name and the salary with a bonus of
		// 10% with the salary formatted as currency
		// NOTE: Use functional composition when possible
		
		Function<Employee, Double> calculateBonus = e -> e.getSalary() * 0.10;
		Function<Employee, String> formatSalary = e -> String.format("$%,.2f", e.getSalary() + calculateBonus.apply(e));
		
		
		employees.stream()
			.sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
			.limit(5)
			.forEach(e -> System.out.println(e.getName() + " - Salario: " + e.getSalary() + " (Total: " + formatSalary.apply(e) + ")"));
			

	}

	// 4. HR Analytics Dashboard
	private static void showHRAnalytics(List<Employee> employees) {
		System.out.println("\n--- 4. HR Analytics Dashboard ---");

		// TODO Show:
		// 1st -> The name of all departments without duplicates
		System.out.println("Departamentos");
		employees.stream()
			.map(Employee::getDepartment)
			.filter(dept -> dept != null && !dept.trim().isEmpty())
			.map(String::toUpperCase)
			.distinct()
			.sorted()
			.forEach(dept -> System.out.println(dept));
		
		
		// 2nd -> Roles split into words without duplicates nor null or empty value in
		// upper case and sorted alphabetically
		System.out.println("");
		System.out.println("Roles");
		employees.stream()
			.map(Employee::getRole)
			.filter(rol -> rol != null && !rol.trim().isEmpty())
			.sorted((e1, e2) -> e1.compareToIgnoreCase(e2))
			.map(String::toUpperCase)
			.distinct()
			.sorted()
			.forEach(dept -> System.out.println(dept));

		// 3rd -> The total amount of working experience of all employees
		System.out.println("Cantidad total");
		int total = employees.stream()
		.map(Employee::getYearsAtCompany)
		.reduce(0, Integer::sum);
		
		System.out.println("Anios totales: "  + total);

		// 4th -> The employee with highest salary
		Employee masSueldo = employees.stream()
				.max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
				.orElse(null);
		
		System.out.println("Empleado con mas sueldo: " + masSueldo.getSalary());

	}

	// 5. Data Quality Report
	private static void showDataQualityReport(List<Employee> employees) {
		System.out.println("\n--- 5. Data Quality Report ---");
		System.out.println("Identifying missing or invalid fields (marked as 0 or Unknown)...");

		// TODO Show:
		// 1st -> The number of employees with salary as 0.0
		int missingSalaries = (int) employees.stream()
				.filter(e -> e.getSalary() == 0.0)
				.count();

		// 2nd -> The number of employees with age as 0
		int missingAges = (int) employees.stream()
				.filter(e -> e.getAge() == 0)
				.count();


		// 3rd -> The number of employees with department as "Unknown"
		long unknownDepts = employees.stream()
				.map(Employee::getDepartment)
				.filter(e -> e == "Unknown" || e == null || e.trim().isEmpty() || e.equalsIgnoreCase("Unknown"))
				.count();

		// 4th -> The number of employees with role as "Unknown"
		long unknownRoles = employees.stream()
				.map(Employee::getRole)
				.filter(e -> e == "Unknown" || e == null || e.trim().isEmpty() || e.equalsIgnoreCase("Unknown"))
				.count();
		

		System.out.println("----------------------------------------------");
		System.out.printf("Missing Salaries  : %d%n", missingSalaries);
		System.out.printf("Missing Ages      : %d%n", missingAges);
		System.out.printf("Unknown Depts     : %d%n", unknownDepts);
		System.out.printf("Unknown Roles     : %d%n", unknownRoles);
		System.out.println("----------------------------------------------");
		System.out.println("Total Issues found: " + (missingSalaries + missingAges + unknownDepts + unknownRoles));
	}

	// 6. [Optional] Dynamic Filtering (Combining Predicates with Reduce)
	private static void filterEmployees(List<Employee> employees, List<Predicate<Employee>> predicates) {
		System.out.println("\n--- 6. (Optional) Dynamic Filtering ---");

		// TODO Combine all the predicates with the and operator, filter the employees
		// based on the combined predicate and show the result
		Predicate<Employee> combinedPredicate = predicates.stream()
				.reduce(e -> true, Predicate::and);
		
		employees.stream()
				.filter(combinedPredicate)
				.forEach(e -> System.out.println(e.getName() + " - " + e.getDepartment() + " - " + e.getSalary()));
		
		
		

	}

	// 7. [Optional] Complex Sorting (Comparator composition)
	private static void sortEmployeesComplex(List<Employee> employees) {
		System.out.println("\n--- 7. (Optional) Complex Sorting ---");

		System.out.println("Sorting by Dept (ASC) -> Performance (DESC) -> Salary (DESC)...");

		// TODO Show the top 10 employees in ascending order by department, and in
		// descending order by performance and salary
		
		employees.stream()
		.sorted((e1, e2) -> {
			int deptCompare = e1.getDepartment().compareToIgnoreCase(e2.getDepartment());
			if (deptCompare != 0) return deptCompare;
			
			int perfCompare = Double.compare(e2.getPerformanceScore(), e1.getPerformanceScore());
			if (perfCompare != 0) return perfCompare;
			
			return Double.compare(e2.getSalary(), e1.getSalary());
		})
		.limit(10)
		.forEach(e -> System.out.println(e.getName() + " - " + e.getDepartment() + " - " + e.getPerformanceScore() + " - " + e.getSalary()));
		

	}

	// 8. [Optional] Average salary per Department (Using GroupingBy)
	private static void showAverSalaryDepartment(List<Employee> employees) {
		System.out.println("\n--- 8. (Optional) Average salary per Department ---");

		// TODO Show the departments and their average salary in descending order by
		// salary
		
		employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
			.entrySet().stream()
				.sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
				.forEach(entry -> System.out.println(entry.getKey() + " - Average Salary: " + String.format("$%,.2f", entry.getValue())));
		
		
		

	}

	private static List<Employee> loadEmployees(String filePath) {
		List<Employee> list = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
			// Skip header and parse
			list = lines.skip(1).map(line -> {
				String[] parts = line.split(",");
				// Handling potential empty strings if simple split is used,
				// but since we cleaned the CSV, we assume valid data.
				long id = Long.parseLong(parts[0]);
				String name = parts[1];
				String dept = parts[2];
				String role = parts[3];
				double salary = Double.parseDouble(parts[4]);
				int age = Integer.parseInt(parts[5]);
				int years = Integer.parseInt(parts[6]);
				String city = parts[7];
				double perf = Double.parseDouble(parts[8]);

				return new Employee(id, name, dept, role, salary, age, years, city, perf);
			}).collect(Collectors.toList());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Error parsing number: " + e.getMessage());
		}
		return list;
	}
}
