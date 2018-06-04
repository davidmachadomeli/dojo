import com.mercadolibre.dojo.ClassroomsPool;
import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.RequestForClassroom;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.classrooms.specs.BlackBoard;
import com.mercadolibre.dojo.classrooms.specs.Computers;
import com.mercadolibre.dojo.classrooms.specs.Persons;
import com.mercadolibre.dojo.classrooms.specs.SquareMeters;
import com.mercadolibre.dojo.matchers.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DojoTest {

    private ClassroomsPool pool;

    private Classroom labA;
    private Classroom labB;
    private Classroom labC;
    private Classroom labD;

    @BeforeEach
    void setup() {
        this.labA = new Classroom(
                new Label("Lab A"),
                new Persons(5),
                new SquareMeters(10)
        );
        this.labB = new Classroom(
                new Label("Lab B"),
                new Persons(20),
                new SquareMeters(20),
                new BlackBoard()
        );
        this.labC = new Classroom(
                new Label("Lab C"),
                new Persons(15),
                new SquareMeters(50)
        );
        this.labD = new Classroom(
                new Label("Lab D"),
                new Persons(15),
                new SquareMeters(50),
                new Computers()
        );

        this.pool = new ClassroomsPool(this.labA, this.labB, this.labC, this.labD);
    }

    @AfterEach
    void tearDown() {
        this.labA = null;
        this.labB = null;

        this.pool = null;
    }

    @Test
    void search_classroom_for_at_least_30_persons_should_return_that_there_is_no_classroom_with_that_specs() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(new CapacityOfAtLeast(new Persons(30)))
        );

        // EXPECT
        assertEquals(NoClassroom.class, classroomWithMatchingRequisition.getClass());
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
    void search_classroom_for_at_least_10_persons_and_30_square_meters_should_return_labC() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(
                        new And(
                                new CapacityOfAtLeast(new Persons(10)),
                                new CapacityOfAtLeast(new SquareMeters(30))
                        )
                )
        );

        // EXPECT
        assertEquals(this.labC, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_10_persons_and_30_square_meters_and_has_computers_should_return_labC() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(
                        new And(
                                new CapacityOfAtLeast(new Persons(10)),
                                new CapacityOfAtLeast(new SquareMeters(30)),
                                new CountsWith(new Computers())
                        )
                )
        );

        // EXPECT
        assertEquals(this.labD, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_20_persons_and_20_square_meters_and__has_computers_or_has_a_blackboard_should_return_labB() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(
                        new And(
                                new CapacityOfAtLeast(new Persons(20)),
                                new Or(
                                        new CountsWith(new Computers()),
                                        new CountsWith(new BlackBoard())
                                ),
                                new CapacityOfAtLeast(new SquareMeters(20))
                        )
                )
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

    @Test
    void search_classroom_for_at_least_10_persons_and_less_than_30_square_meters_and__has_computers_or_has_a_blackboard_should_return_labB() {
        // GIVEN
        final IClassroom classroomWithMatchingRequisition = this.pool.searchClassroomFor(
                new RequestForClassroom(
                        new And(
                                new CapacityOfAtLeast(new Persons(10)),
                                new Or(
                                        new CountsWith(new Computers()),
                                        new CountsWith(new BlackBoard())
                                ),
                                new CapacityOfLessThan(new SquareMeters(30))
                        )
                )
        );

        // EXPECT
        assertEquals(this.labB, classroomWithMatchingRequisition);
    }

}
