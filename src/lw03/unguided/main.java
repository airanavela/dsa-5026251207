package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> enrollment = new LinkedHashMap<>();

        List<String> checkResults = new ArrayList<>();
        int rejected = 0;
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String operation = parts[0];
            String course = parts[1];

            if (operation.equals("CHECK")) {

                if (enrollment.containsKey(course)) {
                    checkResults.add(course + ": " + enrollment.get(course) + " students");
                } else {
                    checkResults.add(course + ": Not found");
                }

            } else {

                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    rejected++;
                } else if (operation.equals("REGISTER")) {
                    if (enrollment.containsKey(course)) {
                        int current = enrollment.get(course);
                        enrollment.put(course, current + count);
                    } else {
                        enrollment.put(course, count);
                    }

                } else if (operation.equals("WITHDRAW")) {
                    if (enrollment.containsKey(course) && enrollment.get(course) >= count) {
                        int current = enrollment.get(course);
                        enrollment.put(course, current - count);
                    } else {
                        rejected++;
                    }
                }
            }
        }

        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for (int i = 0; i < checkResults.size(); i++) {
            System.out.println(checkResults.get(i));
        }

        System.out.println("===== Final Enrollment =====");
        for (String course : enrollment.keySet()) {
            System.out.println(course + ": " + enrollment.get(course) + " students");
        }

        System.out.println("Rejected operations: " + rejected);
    }
}
