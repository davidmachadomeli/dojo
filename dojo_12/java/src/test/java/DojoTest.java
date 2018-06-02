import com.mercadolibre.dojo.*;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
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

        this.pool = new ClassroomsPool(this.labB, this.labA);
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
                new Requisition(new CapacityOfAtLeast(new Persons(10)))
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

}
