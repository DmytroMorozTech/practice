//https://www.hackerrank.com/challenges/java-sort/problem
package JavaSort;

import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        double CgpaDiff = o2.getCgpa() - o1.getCgpa();
        if (CgpaDiff != 0) return (CgpaDiff > 0 ? 1 : -1);
        // if Cgpa value is not the same for o1 and o2, then we can sort them based on this data;
        // Otherwise we have to proceed sorting process based on other data fields, specified in task;

        int nameDiff = o1.getFname().compareTo(o2.getFname());
        if (nameDiff != 0) return nameDiff;
        // the same approach as with Cgpa.

        int idDiff = o1.getId() - o2.getId();
        // if the program has not returned a value up to this point, means that
        // Cgpa and firstName of o1 and 02 are equal. Therefore we consider ids as
        // the final source of truth for this data to be sorted (because there are no 2 repeated IDs)

        return idDiff;
    }
}

//Complete the code
public class Solution {

//    // This code snippet below is destined for HackerRank environment, when the input is read from System.in.
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int testCases = Integer.parseInt(in.nextLine());
//
//        List<Student> studentList = new ArrayList<Student>();
//        while (testCases > 0) {
//            int id = in.nextInt();
//            String fname = in.next();
//            double cgpa = in.nextDouble();
//
//            Student st = new Student(id, fname, cgpa);
//            studentList.add(st);
//
//            testCases--;
//        }
//
//        Collections.sort(studentList,new StudentComparator());
//
//        for (Student st : studentList) {
//            System.out.println(st.getFname());
//        }
//    }

    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();
        studentsList.addAll(Arrays.asList(
                new Student(33, "Rumpa", 3.68),
                new Student(85, "Ashis", 3.85),
                new Student(56, "Samiha", 3.75),
                new Student(19, "Samara", 3.75),
                new Student(22, "Fahim", 3.76)
        ));

        Collections.sort(studentsList, new StudentComparator());

        for (Student s : studentsList) {
            System.out.println(s.getFname());
        }
    }
}
//Expected output:
//  Ashis
//  Fahim
//  Samara
//  Samiha
//  Rumpa



