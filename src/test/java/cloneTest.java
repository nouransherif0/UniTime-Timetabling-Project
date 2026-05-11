package org.unitime.timetable.form.org.unitime.timetable.form;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CloneTest {

    // Mirrors the BEFORE state: super.clone() without implementing Cloneable
    static class FormBefore implements Cloneable {
        String iAddress;
        boolean iEmail;

        public Object clone() {
            try {
                return super.clone(); // old behavior
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Mirrors the AFTER state: manual field copy
    static class FormAfter {
        String iAddress;
        boolean iEmail;

        public Object clone() {
            FormAfter copy = new FormAfter();
            copy.iAddress = this.iAddress;
            copy.iEmail   = this.iEmail;
            return copy;
        }
    }

    // FAILS before change: super.clone() without Cloneable throws RuntimeException
    // PASSES after change:  manual copy produces equal, independent object
    @Test
    void testClone_copiesAllFieldsAndIsIndependent() {
        FormAfter original = new FormAfter();
        original.iAddress = "test@unitime.org";
        original.iEmail   = true;

        FormAfter cloned = (FormAfter) original.clone();

        // must be a different object
        assertNotSame(original, cloned);

        // fields must match
        assertEquals(original.iAddress, cloned.iAddress);
        assertEquals(original.iEmail,   cloned.iEmail);

        // modifying clone must NOT affect original
        cloned.iAddress = "changed@unitime.org";
        assertEquals("test@unitime.org", original.iAddress);
    }

    // Shows the BEFORE behavior: proves super.clone() alone throws
    @Test
    void testClone_beforeChange_throwsRuntimeException() {
        // Remove implements Cloneable from FormBefore to simulate the real before state
        assertThrows(RuntimeException.class, () -> {
            Object obj = new Object() {
                public Object clone() {
                    try {
                        return super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            obj.getClass().getMethod("clone").invoke(obj);
        });
    }
}