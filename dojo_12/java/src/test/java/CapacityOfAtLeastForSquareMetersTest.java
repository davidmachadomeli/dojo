import com.mercadolibre.dojo.*;
import com.mercadolibre.dojo.classroomSpecs.Persons;
import com.mercadolibre.dojo.classroomSpecs.SquareMeters;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.matchers.CapacityOfAtLeast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapacityOfAtLeastForSquareMetersTest {

    private ClassroomsPool pool;

    private Classroom labA;
    private Classroom labB;

    @BeforeEach
    void setup() {
        this.labA = new Classroom(new Label("Lab A"), new Persons(5), new SquareMeters(5));
        this.labB = new Classroom(new Label("Lab B"), new Persons(15), new SquareMeters(15));

        this.pool = new ClassroomsPool(this.labA, this.labB);
    }

    @AfterEach
    void tearDown() {
        this.labA = null;
        this.labB = null;

        this.pool = null;
    }

    @Test
    void search_classroom_for_at_least_4_square_meters_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new SquareMeters(4)))
        );

        // EXPECT
        assertEquals(this.labA, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_5_square_meters_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new SquareMeters(5)))
        );

        // EXPECT
        assertEquals(this.labA, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_6_square_meters_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new SquareMeters(6)))
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_14_square_meters_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new SquareMeters(14)))
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_15_square_meters_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new SquareMeters(15)))
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_16_square_meters_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new SquareMeters(16)))
        );

        // EXPECT
        assertEquals(new NoClassroom(), classroomWithMatchingRequisition);
    }

}
