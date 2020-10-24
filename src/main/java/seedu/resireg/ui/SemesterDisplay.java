package seedu.resireg.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.resireg.commons.core.LogsCenter;
import seedu.resireg.model.semester.Semester;

/**
 * Label containing the current semester.
 */
public class SemesterDisplay extends UiPart<Region> {
    private static final String FXML = "SemesterDisplay.fxml";
    private final Logger logger = LogsCenter.getLogger(SemesterDisplay.class);

    private final Semester semester;

    @FXML
    private Label semesterLabel;

    /**
     * Creates a {@code SemesterDisplay} with the given {@code Semester} and index to display.
     */
    public SemesterDisplay(Semester semester) {
        super(FXML);
        this.semester = semester;
        logger.info("Created SemesterDisplay panel");

        semesterLabel.setText("Current Semester: AY" + semester.getAcademicYear()
            + " Semester " + semester.getSemesterNumber());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SemesterDisplay)) {
            return false;
        }

        // state check
        SemesterDisplay display = (SemesterDisplay) other;
        return semesterLabel.getText().equals(display.semesterLabel.getText())
            && semester.equals(display.semester);
    }
}
