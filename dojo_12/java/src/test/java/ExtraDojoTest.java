import com.mercadolibre.dojo.ClassroomsPool;
import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.Persons;
import com.mercadolibre.dojo.RequestForClassroom;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.matchers.CapacityOfAtLeast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtraDojoTest {

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
    void search_classroom_for_at_least_5_persons_should_return_labA() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new Persons(5)))
        );

        // EXPECT
        assertEquals(this.labA, classroomWithMatchingRequisition);
    }

}
