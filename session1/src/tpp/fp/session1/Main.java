package tpp.fp.session1;

import java.util.*;

/**
 * Basic examples of lambda expressions on Collections,
 * followed by a small interactive task manager on the console.
 *
 * This is the STUDENT SKELETON version:
 * - The structure of the program is complete.
 * - The lists and menus are created.
 * - The student must fill the parts marked with TODO.
 */
public class Main {

    public static void main(String[] args) {

        /* ============================================================
         * EXERCISE 1
         * Goal: print each number using forEach + lambda
         * ============================================================ */
        List<Integer> nums1 = List.of(3, 1, 4, 1, 5, 9);
        System.out.println("Exercise 1:");
        // TODO: use forEach with a lambda to print each number in nums1
        System.out.println();


        /* ============================================================
         * EXERCISE 2
         * Goal: transform each word to UPPERCASE with replaceAll
         * ============================================================ */
        List<String> words2 = new ArrayList<>(List.of("java", "lambda", "expression"));
        // TODO: use replaceAll with a lambda to transform each word to UPPERCASE
        System.out.println("Exercise 2:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 3
         * Goal: remove numbers less than 5 using removeIf
         * ============================================================ */
        List<Integer> nums3 = new ArrayList<>(List.of(10, 3, 7, 2, 5, 8));
        // TODO: use removeIf with a lambda to remove numbers < 5
        System.out.println("Exercise 3:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 4
         * Goal: sort numbers in ascending order with sort + lambda
         * ============================================================ */
        List<Integer> nums4 = new ArrayList<>(List.of(7, 4, 9, 1, 3));
        // TODO: use sort with a lambda comparator to sort nums4 in ascending order
        System.out.println("Exercise 4:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 5
         * Goal: sort strings by length using a lambda
         * ============================================================ */
        List<String> words5 = new ArrayList<>(List.of("java", "haskell", "c", "python"));
        // TODO: use sort with a lambda comparator to sort by string length
        System.out.println("Exercise 5:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 6
         * Goal: add "!" at the end of each word with replaceAll
         * ============================================================ */
        List<String> words6 = new ArrayList<>(List.of("sun", "moon", "earth"));
        // TODO: use replaceAll with a lambda to add "!" at the end of each word
        System.out.println("Exercise 6:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 7
         * Goal: remove words that start with 'm' or 'M' using removeIf
         * ============================================================ */
        List<String> words7 = new ArrayList<>(List.of("melon", "pear", "mango", "kiwi"));
        // TODO: use removeIf with a lambda to remove words starting with 'm' or 'M'
        System.out.println("Exercise 7:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 8
         * Goal: sort a list in descending order with lambda
         * ============================================================ */
        List<Integer> nums8 = new ArrayList<>(List.of(2, 9, 1, 6, 4));
        // TODO: use sort with a lambda comparator to sort nums8 in descending order
        System.out.println("Exercise 8:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 9
         * Goal: sort words in case-insensitive alphabetical order
         * ============================================================ */
        List<String> words9 = new ArrayList<>(List.of("Java", "lambda", "Expression", "code"));
        // TODO: use sort with a lambda comparator or Comparator.comparing
        //       to sort ignoring case (case-insensitive)
        System.out.println("Exercise 9:");
        // TODO: print the resulting list
        System.out.println();


        /* ============================================================
         * EXERCISE 10
         * Goal: print each number multiplied by 2 with forEach + lambda
         * ============================================================ */
        List<Double> reals10 = List.of(1.0, 2.5, 3.2, 4.8);
        System.out.println("Exercise 10:");
        // TODO: use forEach with a lambda to print each element multiplied by 2
        System.out.println();


        /* ============================================================
         * INTERACTIVE TASK MANAGER (with lambdas on Collections)
         * ============================================================ */
        TaskManagerExample.runInteractive();
    }
}

// ---------------------------------------------------------------------------
// Simple domain class for the example problem
// ---------------------------------------------------------------------------
class Task {

    private final String description;
    private final int priority;      // 1 = low, 5 = very high
    private final boolean completed;

    public Task(String description, int priority, boolean completed) {
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        String status = completed ? "COMPLETED" : "PENDING";
        return "[P" + priority + "] " + description + " (" + status + ")";
    }
}

// ---------------------------------------------------------------------------
// Example class: using lambdas on List<Task> for an interactive manager
// ---------------------------------------------------------------------------
class TaskManagerExample {

    /**
     * Main interactive demo method.
     * Shows a menu and allows the user to manage a list of tasks.
     */
    public static void runInteractive() {
        Scanner sc = new Scanner(System.in);
        List<Task> tasks = createSampleTasks();
        boolean exit = false;

        System.out.println("=== SIMPLE TASK MANAGER WITH LAMBDAS ON COLLECTIONS ===");

        while (!exit) {
            printMenu();
            int option = readInt(sc, "Choose an option:");

            switch (option) {
                case 1 :
                    showTasks(tasks);
                    break;
                case 2 :
                    addTask(sc, tasks);
                    break;
                case 3 :
                    markTaskAsCompleted(sc, tasks);
                    break;
                case 4 :
                    removeCompleted(tasks);
                    break;
                case 5 :
                    sortByPriorityAsc(tasks);
                    System.out.println("Tasks sorted by ascending priority.");
                    break;
                case 6 :
                    sortByPriorityDesc(tasks);
                    System.out.println("Tasks sorted by descending priority.");
                    break;
                case 7 :
                    sortByDescriptionLength(tasks);
                    System.out.println("Tasks sorted by description length.");
                    break;
                case 8 :
                    markUrgent(tasks);
                    System.out.println("Urgent tasks marked (priority >= 4).");
                    break;
                case 9 :
                    showHighPriorityTasks(sc, tasks);
                    break;
                case 0 :
                    exit = true;
                    System.out.println("Exiting task manager.");
                    break;
                default :
                    System.out.println("Unknown option.");
            }
            System.out.println();
        }
        // We do not close the Scanner to avoid closing System.in.
    }

    // -----------------------------------------------------------------------
    // Creates some initial tasks for demonstration.
    // -----------------------------------------------------------------------
    private static List<Task> createSampleTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Buy milk", 2, false));
        tasks.add(new Task("Finish report", 4, false));
        tasks.add(new Task("Book flight tickets", 3, true));
        tasks.add(new Task("Call the dentist", 1, false));
        tasks.add(new Task("Prepare lecture slides", 5, false));
        return tasks;
    }

    // -----------------------------------------------------------------------
    // Prints the main menu.
    // -----------------------------------------------------------------------
    private static void printMenu() {
        System.out.println("----------- MENU -----------");
        System.out.println("1. Show all tasks");
        System.out.println("2. Add new task");
        System.out.println("3. Mark a task as completed");
        System.out.println("4. Remove completed tasks");
        System.out.println("5. Sort by ascending priority");
        System.out.println("6. Sort by descending priority");
        System.out.println("7. Sort by description length");
        System.out.println("8. Mark high-priority tasks as URGENT");
        System.out.println("9. Show only high-priority tasks");
        System.out.println("0. Exit");
    }

    // -----------------------------------------------------------------------
    // Safe integer input
    // -----------------------------------------------------------------------
    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message + " ");
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number.");
            }
        }
    }

    // -----------------------------------------------------------------------
    // a) Show all tasks → forEach (lambda)
    // -----------------------------------------------------------------------
    private static void showTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks.");
            return;
        }
        // TODO: use forEach with a lambda or method reference to print each task
    }

    // -----------------------------------------------------------------------
    // b) Add new task (no lambdas, just interaction)
    // -----------------------------------------------------------------------
    private static void addTask(Scanner sc, List<Task> tasks) {
        System.out.print("Description: ");
        String desc = sc.nextLine();
        int priority = readInt(sc, "Priority (1-5): ");
        if (priority < 1) priority = 1;
        if (priority > 5) priority = 5;

        tasks.add(new Task(desc, priority, false));
        System.out.println("Task added.");
    }

    // -----------------------------------------------------------------------
    // c) Mark a task as completed (by index)
    // -----------------------------------------------------------------------
    private static void markTaskAsCompleted(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to mark.");
            return;
        }

        showTasks(tasks);
        int idx = readInt(sc, "Index of the task to complete (0.." + (tasks.size() - 1) + "): ");

        if (idx >= 0 && idx < tasks.size()) {
            Task t = tasks.get(idx);
            tasks.set(idx, new Task(t.getDescription(), t.getPriority(), true));
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // -----------------------------------------------------------------------
    // d) Remove completed tasks → removeIf (lambda)
    // -----------------------------------------------------------------------
    private static void removeCompleted(List<Task> tasks) {
        // TODO: use removeIf with a lambda to remove tasks that are completed
        //       and show a message indicating whether any was removed.
    }

    // -----------------------------------------------------------------------
    // e) Sort by ascending priority → sort (lambda)
    // -----------------------------------------------------------------------
    private static void sortByPriorityAsc(List<Task> tasks) {
        // TODO: use sort with a lambda comparator to sort tasks by priority ascending
    }

    // -----------------------------------------------------------------------
    // f) Sort by descending priority → sort (lambda)
    // -----------------------------------------------------------------------
    private static void sortByPriorityDesc(List<Task> tasks) {
        // TODO: use sort with a lambda comparator to sort tasks by priority descending
    }

    // -----------------------------------------------------------------------
    // g) Sort by description length → sort (lambda)
    // -----------------------------------------------------------------------
    private static void sortByDescriptionLength(List<Task> tasks) {
        // TODO: use sort with a lambda comparator to sort by description length
    }

    // -----------------------------------------------------------------------
    // h) Mark urgent tasks (priority >= 4) → replaceAll (lambda)
    // -----------------------------------------------------------------------
    private static void markUrgent(List<Task> tasks) {
        // TODO: use replaceAll with a lambda:
        //       - if priority >= 4 and the description does not start with "[URGENT] ",
        //         return a new Task with "[URGENT] " + description.
        //       - otherwise, return the original task.
    }

    // -----------------------------------------------------------------------
    // i) Show only high-priority tasks → forEach + if (lambda)
    // -----------------------------------------------------------------------
    private static void showHighPriorityTasks(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks.");
            return;
        }

        int min = readInt(sc, "Show tasks with priority >= ");
        System.out.println("Tasks with priority >= " + min + ":");

        // TODO: use forEach with a lambda:
        //       inside the lambda, use an if to print only tasks with priority >= min
    }
}
