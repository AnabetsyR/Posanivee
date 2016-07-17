package com.company;

import static com.company.CampPosanivee.Size;


/****************************************************************************
     * Camper class The camper class is intended to create a comparable class of
     * campers. The data structure includes name, age, and gender and the
     * information is stored in a binary search tree using a queue.
     *
     * @author Name
     * @version 1.0
     * @date Date
     * @course MCIS-0503 Fall 2012 Data Structures and Algorithms
     * @instructor Dr. Jeremy Lanman
     *****************************************************************************/
    public class Camper implements Comparable<Camper> {
        @Override
        public int compareTo(Camper o) {

            return 0;
        }

        public String name;
        public int age;
        public String gender;
        public String Size;


        //n means name, a means age, and g means gender
        public Camper(String n, int a, String g){
            name = n;
            age= a;
            gender = g;
        }

        //Method for accessing the name of the object.
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {

            return name;
        }

        @Override
        public String toString() {

            return getName()+":"+getAge()+" ";
        }

        //Method for accessing the size of the object.
        public void setAge(int age) {

            this.age = age;
        }

        public int getAge() {

            return age;
        }

        // Method for accessing the arrival time of the party.
        public void setGender(int gender) {
            this.gender = String.valueOf((char) gender);
        }
        public int getGender() {

            return getGender();
        }

        public void setSize(int Size) {
            this.Size = String.valueOf((int) Size);
        }
        public String getSize()
        {
            return Size;
        }


    }




