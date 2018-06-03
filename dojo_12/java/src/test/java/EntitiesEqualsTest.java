import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.Persons;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EntitiesEqualsTest {

    @Test
    void label_equals_classroom_should_be_false() {
        // GIVEN
        final Label label = new Label("label");
        final IClassroom classroom = new Classroom(new Label("class"), new Persons(1));

        // EXPECT
        assertFalse(label.equals(classroom));
    }

    @Test
    void label_a_equals_label_b_should_be_false() {
        // GIVEN
        final Label labelA = new Label("label a");
        final Label labelB = new Label("label b");

        // EXPECT
        assertFalse(labelA.equals(labelB));
    }

    @Test
    void label_equals_same_label_should_be_true() {
        // GIVEN
        final Label label = new Label("label");

        // EXPECT
        assertTrue(label.equals(label));
    }

    @Test
    void label_equals_label_should_be_true() {
        // GIVEN
        final Label labelA = new Label("label");
        final Label labelB = new Label("label");

        // EXPECT
        assertTrue(labelA.equals(labelB));
    }

    @Test
    void no_classroom_equals_label_should_be_false() {
        // GIVEN
        final IClassroom noClassroom = new NoClassroom();
        final Label label = new Label("label");

        // EXPECT
        assertFalse(noClassroom.equals(label));
    }

    @Test
    void no_classroom_equals_same_no_classroom_should_be_true() {
        // GIVEN
        final IClassroom noClassroom = new NoClassroom();

        // EXPECT
        assertTrue(noClassroom.equals(noClassroom));
    }

    @Test
    void no_classroom_equals_no_classroom_should_be_true() {
        // GIVEN
        final IClassroom noClassroomA = new NoClassroom();
        final IClassroom noClassroomB = new NoClassroom();

        // EXPECT
        assertTrue(noClassroomA.equals(noClassroomB));
    }

}
