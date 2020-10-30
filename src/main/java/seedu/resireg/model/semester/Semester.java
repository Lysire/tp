package seedu.resireg.model.semester;

import static seedu.resireg.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.resireg.model.allocation.Allocation;

/**
 * Represents a Semester in ResiReg.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Semester {

    // Identity fields
    private final int academicYear;
    private final int semesterNumber;

    // Data fields
    private final List<Allocation> allocations;

    /**
     * SemesterNumber should be present and not null.
     */
    public Semester(int academicYear, int semesterNumber) {
        this.academicYear = academicYear;
        this.semesterNumber = semesterNumber;
        allocations = new ArrayList<>();
    }

    /**
     * Helper constructor for initializing a new semester.
     */
    public Semester() {
        this(LocalDate.now().getYear(), 1);
    }

    /**
     * All fields should be present and not null.
     */
    public Semester(int academicYear, int semesterNumber, List<Allocation> allocations) {
        requireAllNonNull(allocations);
        this.academicYear = academicYear;
        this.semesterNumber = semesterNumber;
        this.allocations = allocations;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    /**
     * Returns true if both semesters have the same academic year and semester number.
     * This defines a weaker notion of equality between two semesters, and includes semesters that begin in the same
     * year and period, but different allocations and fees;
     */
    public boolean isSameSemester(Semester otherSemester) {
        if (otherSemester == this) {
            return true;
        }

        return otherSemester != null
                && Objects.equals(otherSemester.getAcademicYear(), getAcademicYear())
                && Objects.equals(otherSemester.getSemesterNumber(), getSemesterNumber());
    }

    /**
     * Returns the successor of a given Semester. A next semester should be the second semester of the academic year if
     * the given semester is in sem 1, otherwise it should be the first semester of the next academic year.
     *
     * @return the successor of this semester
     */
    public Semester getNextSemester() {
        if (semesterNumber == 1) {
            return new Semester(academicYear, 2);
        } else {
            return new Semester(academicYear + 1, 1);
        }
    }

    /**
     * @return a shortened String representation of the semester in form of "AY" + year + "S" + semesterNumber.
     */
    public String getShortRepresentation() {
        return String.format("AY%sS%s", academicYear, semesterNumber);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Semester)) {
            return false;
        }

        Semester otherSemester = (Semester) other;
        return otherSemester.getAcademicYear() == getAcademicYear()
                && otherSemester.getSemesterNumber() == getSemesterNumber()
                && Objects.equals(otherSemester.getAllocations(), getAllocations());
    }

    @Override
    public String toString() {
        return " Academic Year: " + getAcademicYear() + " Semester: " + getSemesterNumber();
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }
}
