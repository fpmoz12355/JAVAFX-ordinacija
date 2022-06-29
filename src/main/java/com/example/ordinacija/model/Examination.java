package com.example.ordinacija.model;

public class Examination extends Table{

        @Entity(type = "INTEGER", size = 32, primary = true)
        int ID;
        @Entity(type = "STRING",  isnull = false)
        String date;
        @Entity(type = "STRING",  isnull = false)
        String hour;
        @Entity(type = "VARCHAR", size = 20, isnull = false)
        String status;
        @Entity(type = "VARCHAR")
        String note;
        @Entity(type = "VARCHAR", size = 20, isnull = false)
        String type;

        @ForeignKey(table = "patient", attribute = "ID")
        @Entity(type = "INTEGER", size = 32)
        int patient_fk;



        public int getID() {
            return ID;
        }


        public String getDate() { return date; }

        public void setDate ( String date) { this.date = date; }


        public String getHour() { return hour;  }

        public void setHour (String hour) { this.hour = hour;   }


        public String getStatus() { return status;  }

        public void setStatus (String status) { this.status = status;   }


        public String getNote() { return note;  }

        public void setNote (String note) { this.note = note;   }


        public String getType() { return type;  }

        public void setType (String type) { this.type = type;   }


        public int getPatient_fk() { return patient_fk;  }

        public void setPatientFk(int patient_fk) {
            this.patient_fk = patient_fk;
        }

}


