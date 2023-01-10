import java.util.*;
import java.io.*;

class streams {
    public static void main(String arg[]) throws IOException, EOFException {
        FileInputStream fis = new FileInputStream("digit.txt");
        DataInputStream dis = new DataInputStream(fis);
        FileOutputStream fos = new FileOutputStream("eligibility.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        FileOutputStream awr = new FileOutputStream("digit.txt");
        DataOutputStream def = new DataOutputStream(awr);
        double array[] = { 77.2, 69.7, 86.2, 93.5, 76.8 };
        for (int i = 0; i < array.length; i++) {
            def.writeDouble(array[i]);
        }
        byte k = 0;
        double avg = 0;
        while (dis.available() > 0) {
            array[k] = dis.readDouble();
            k++;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    double temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        System.out.println("Marks in sorted order: ");
        for (int i = 0; i < array.length; i++) {
            avg += array[i];
            System.out.print(array[i] + " ");
        }
        if ((avg / (array.length * 100) > 0.85)) {
            System.out.println("\nSecured " + (avg / array.length)
                    + " percentage\nEligble and exempted from aptitude exams(both oral and written)");
            dos.writeUTF("Secured " + (avg / array.length)
                    + " percentage\nEligble and exempted from aptitude exams(both oral and written)");
        } else if (0.75 <= (avg / (array.length * 100)) && (avg / (array.length *
                100)) <= 0.85) {
            System.out.println("\nSecured " + (avg / array.length)
                    + " percentage\nEligble and exempted from aptitude exams(written)");
            dos.writeUTF("Secured " + (avg / array.length)
                    + " percentage\nEligble and exempted from aptitude exams(written)");
        } else {
            System.out.println("\nSecured " + (avg / (array.length * 100)) + " percentage\nNot Eligible for interview");
            dos.writeUTF("Secured " + (avg / array.length) + " percentage\nNot Eligble for interview");
        }
        dis.close();
        dos.close();
    }
}