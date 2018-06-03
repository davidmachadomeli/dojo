import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.conditions.Persons;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class MainClass {

    static void intersection(Integer[]... inputArrays) {
        //Printing input arrays
        out.println("Input Arrays :");
        out.println("======================");
        stream(inputArrays).forEach(x -> out.println(Arrays.toString(x)));

        //Creating HashSet object for first input array
        HashSet<Integer> intersectionSet = new HashSet<>(asList(inputArrays[0]));

        //Calling retainAll() method of first object by passing 2nd, 3rd, 4th... objects
        stream(inputArrays).forEach(x -> intersectionSet.retainAll(new HashSet<>(asList(x))));

        out.println("===========================");
        out.println("Intersection Of All Input Arrays :");
        out.println("===========================");
        out.println(intersectionSet);
    }

    static void intersection(List<IClassroom>... classrooms) {
        //Printing input arrays
        out.println("Input Classrooms :");
        out.println("======================");
        stream(classrooms).forEach(x -> out.println(x.stream().map(Object::toString).collect(Collectors.joining(" - "))));

        //Creating HashSet object for first input array
        final HashSet<IClassroom> intersectionSet = new HashSet<>(classrooms[0]);

        //Calling retainAll() method of first object by passing 2nd, 3rd, 4th... objects
        stream(classrooms).forEach(x -> intersectionSet.retainAll(new HashSet<>(x)));

        out.println("===========================");
        out.println("Intersection Of All Input Arrays :");
        out.println("===========================");
        out.println(intersectionSet);
    }

    public static void main(String[] args) {
//        Integer[] inputArray1 = {2, 3, 4, 7, 1};
//
//        Integer[] inputArray2 = {4, 1, 3, 5};
//
//        Integer[] inputArray3 = {8, 4, 6, 2, 1};
//
//        Integer[] inputArray4 = {7, 9, 4, 1};
//
//        intersection(inputArray1, inputArray2, inputArray3, inputArray4);

        final IClassroom labA = new Classroom(new Label("Lab A"), new Persons(1));
        final IClassroom labB = new Classroom(new Label("Lab b"), new Persons(1));
        final IClassroom labC = new Classroom(new Label("Lab C"), new Persons(1));
        final IClassroom labD = new Classroom(new Label("Lab D"), new Persons(1));
        final IClassroom no = new NoClassroom();

//        IClassroom[] matches1 = {labA, labB, no, no};
//        IClassroom[] matches2 = {labA, labC, no, no};
//        IClassroom[] matches3 = {labA, labD, no, no};

        List<IClassroom> matches1 = Arrays.asList(labA, labB, no, no);
        List<IClassroom> matches2 = Arrays.asList(labC, no, labA, no);
        List<IClassroom> matches3 = Arrays.asList(labD, no, no, labA);

        intersection(matches1, matches2, matches3);
    }

}