import com.mercadolibre.dojo.*;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.matchers.CapacityOfAtLeast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DojoTest {

    private ClassroomsPool pool;

    private Classroom labA;
    private Classroom labB;

    @BeforeEach
    void setup() {
        this.labA = new Classroom(new Label("Lab A"), new Persons(5));
        this.labB = new Classroom(new Label("Lab B"), new Persons(15));

        this.pool = new ClassroomsPool(this.labA, this.labB);
    }

    @AfterEach
    void tearDown() {
        this.labA = null;
        this.labB = null;

        this.pool = null;
    }

    @Test
    void search_classroom_for_at_least_10_persons_should_return_labB() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new Persons(10)))
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_30_persons_should_return_that_there_is_no_classroom_with_that_specs() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new Persons(30)))
        );

        // EXPECT
        assertEquals(new NoClassroom(), classroomWithMatchingRequisition);
    }

}
