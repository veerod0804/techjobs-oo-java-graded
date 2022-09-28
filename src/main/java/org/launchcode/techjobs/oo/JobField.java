package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

        private int id;
        private static int nextId = 1;
        private String value;

        public JobField() {
            id = nextId;
            nextId++;
        }

        public JobField(String value) {
            this();
            this.value = value;
        }

        // TODO: Add a custom toString() method that returns the data stored in 'value'.

        @Override
        public String toString() {return value;}

        // TODO: Add custom equals and hashCode methods. Consider two PositionType objects "equal" when
        //  their id fields match.

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            org.launchcode.techjobs.oo.PositionType that = (org.launchcode.techjobs.oo.PositionType) o;
            return id == that.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }


        // Getters and Setters:

        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
}
