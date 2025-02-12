/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink


package org.eclipse.persistence.testing.models.jpa.xml.inheritance;

import java.util.Vector;

public class InheritanceModelExamples  {

    public static Bicycle bikeExample1(Company company) {
        Bicycle example = new Bicycle();
        example.setPassengerCapacity(1);
        example.setOwner(company);
        example.setDescription("Hercules");
//        example.addPartNumber("1288H8HH-f");
//        example.addPartNumber("199448GY-s");
        return example;
    }

    public static Bicycle bikeExample2(Company company) {
        Bicycle example = new Bicycle();
        example.setPassengerCapacity(2);
        example.setOwner(company);
        example.setDescription("Atlas");
//        example.addPartNumber("176339GT-a");
//        example.addPartNumber("199448GY-s");
//        example.addPartNumber("166761UO-z");
        return example;
    }

    public static Bicycle bikeExample3(Company company) {
        Bicycle example = new Bicycle();
        example.setPassengerCapacity(3);
        example.setOwner(company);
        example.setDescription("Aone");
//        example.addPartNumber("188181TT-a");
//        example.addPartNumber("696969BO-b");
        return example;
    }

    public static Boat boatExample1(Company company) {
        Boat example = new Boat();
        example.setPassengerCapacity(10);
        example.setOwner(company);
        return example;
    }

    public static Boat boatExample2(Company company) {
        Boat example = new Boat();
        example.setPassengerCapacity(20);
        example.setOwner(company);
        return example;
    }

    public static Boat boatExample3(Company company) {
        Boat example = new Boat();
        example.setPassengerCapacity(30);
        example.setOwner(company);
        return example;
    }

    public static Bus busExample1(Company company) {
        Bus example = new Bus();

        example.setPassengerCapacity(30);
        example.setFuelCapacity(100);
        example.setDescription("SCHOOL BUS");
        example.setFuelType("Petrol");
        example.setOwner(company);
//        example.addPartNumber("188298SU-k");
//        example.addPartNumber("199211HI-x");
//        example.addPartNumber("023392SY-x");
//        example.addPartNumber("002345DP-s");
        return example;
    }

    public static Bus busExample2(Company company) {
        Bus example = new Bus();

        example.setPassengerCapacity(30);
        example.setFuelCapacity(100);
        example.setDescription("TOUR BUS");
        example.setFuelType("Petrol");
        example.setOwner(company);
//        example.addPartNumber("188298SU-k");
//        example.addPartNumber("199211HI-x");
//        example.addPartNumber("023392SY-x");
//        example.addPartNumber("002345DP-s");
        return example;
    }

    public static Bus busExample3(Company company) {
        Bus example = new Bus();

        example.setPassengerCapacity(30);
        example.setFuelCapacity(100);
        example.setDescription("TRANSIT BUS");
        example.setFuelType("Gas");
        example.setOwner(company);
//        example.addPartNumber("188298SU-k");
//        example.addPartNumber("199211HI-x");
//        example.addPartNumber("023392SY-x");
//        example.addPartNumber("002345DP-s");
        return example;
    }

    public static Car carExample1() {
        Car example = new Car();

        example.setPassengerCapacity(2);
        example.setFuelCapacity(30);
        example.setDescription("PONTIAC");
        example.setFuelType("Petrol");
//        example.addPartNumber("021776RM-b");
//        example.addPartNumber("122500JC-s");
//        example.addPartNumber("101101BI-n");
        return example;
    }

    public static Car carExample2() {
        Car example = new Car();

        example.setPassengerCapacity(4);
        example.setFuelCapacity(50);
        example.setDescription("TOYOTA");
        example.setFuelType("Petrol");
//        example.addPartNumber("021776TT-a");
//        example.addPartNumber("122500RF-g");
//        example.addPartNumber("101101ML-m");
        return example;
    }

    public static Car carExample3() {
        Car example = new Car();

        example.setPassengerCapacity(5);
        example.setFuelCapacity(60);
        example.setDescription("BMW");
        example.setFuelType("Disel");
//        example.addPartNumber("021776KM-k");
//        example.addPartNumber("122500MP-k");
//        example.addPartNumber("101101MP-d");
        return example;
    }

    public static Car carExample4() {
        Car example = new Car();

        example.setPassengerCapacity(8);
        example.setFuelCapacity(100);
        example.setDescription("Mazda");
        example.setFuelType("Coca-Cola");
//        example.addPartNumber("021776KM-k");
//        example.addPartNumber("122500MP-k");
//        example.addPartNumber("101101MP-d");
        return example;
    }

    public static Company companyExample1() {
        Company example = new Company();
        Vector vehicle = new Vector();
        vehicle.addElement(busExample1(example));
        vehicle.addElement(bikeExample1(example));
        vehicle.addElement(busExample2(example));
        vehicle.addElement(busExample3(example));
        vehicle.addElement(nonFueledVehicleExample1(example));
        example.setName("TOP");
        example.setVehicles(vehicle);
        return example;
    }

    public static Company companyExample2() {
        Company example = new Company();
        Vector vehicle = new Vector();
        vehicle.addElement(boatExample1(example));
        vehicle.addElement(bikeExample2(example));
        vehicle.addElement(busExample2(example));
        vehicle.addElement(fueledVehicleExample1(example));
        vehicle.addElement(nonFueledVehicleExample1(example));
        example.setName("ABC");
        example.setVehicles(vehicle);
        return example;
    }

    public static Company companyExample3() {
        Company example = new Company();
        Vector vehicle = new Vector();
        vehicle.addElement(boatExample1(example));
        vehicle.addElement(bikeExample3(example));
        vehicle.addElement(boatExample2(example));
        vehicle.addElement(boatExample3(example));
        vehicle.addElement(nonFueledVehicleExample1(example));
        example.setName("XYZ");
        example.setVehicles(vehicle);
        return example;
    }

    public static FueledVehicle fueledVehicleExample1(Company company) {
        FueledVehicle example = new FueledVehicle();
        example.setPassengerCapacity(1);
        example.setFuelCapacity(10);
        example.setDescription("Motercycle");
        example.setOwner(company);
        return example;
    }

    public static Car imaginaryCarExample1()
    {
        ImaginaryCar example = new ImaginaryCar();
        example.setPassengerCapacity(2);
        example.setFuelCapacity(30);
        example.setDescription("PONTIAC");
        example.setFuelType("Petrol");
    //    example.addPartNumber("021776RM-b");
    //    example.addPartNumber("122500JC-s");
    //    example.addPartNumber("101101BI-n");
        return example;
    }
    public static Car imaginaryCarExample2()
    {
        ImaginaryCar example = new ImaginaryCar();
        example.setPassengerCapacity(4);
        example.setFuelCapacity(50);
        example.setDescription("TOYOTA");
        example.setFuelType("Petrol");
    //    example.addPartNumber("021776TT-a");
    //    example.addPartNumber("122500RF-g");
    //    example.addPartNumber("101101ML-m");
        return example;
    }
    public static Car imaginaryCarExample3()
    {
        ImaginaryCar example = new ImaginaryCar();
        example.setPassengerCapacity(5);
        example.setFuelCapacity(60);
        example.setDescription("BMW");
        example.setFuelType("Disel");
    //    example.addPartNumber("021776KM-k");
    //    example.addPartNumber("122500MP-k");
    //    example.addPartNumber("101101MP-d");
        return example;
    }
    public static Car imaginaryCarExample4()
    {
        Car example = new Car();
        example.setPassengerCapacity(8);
        example.setFuelCapacity(100);
        example.setDescription("Mazda");
        example.setFuelType("Coca-Cola");
    //    example.addPartNumber("021776KM-k");
    //    example.addPartNumber("122500MP-k");
    //    example.addPartNumber("101101MP-d");
        return example;
    }

    public static NonFueledVehicle nonFueledVehicleExample1(Company company) {
        NonFueledVehicle example = new NonFueledVehicle();
        example.setPassengerCapacity(1);
        example.setOwner(company);
        return example;
    }

    public static Person personExample1() {
        Person example = new Person();
        example.setName("Raymen");
        example.setCar(carExample1());
        return example;
    }

    public static Engineer personExample2() {
        Engineer example = new Engineer();
        example.setName("Steve");
        example.setCar(carExample2());
        example.bestFriend = personExample5();
        example.representitive = personExample4();
        return example;
    }

    public static Lawyer personExample3() {
        Lawyer example = new Lawyer();
        example.setName("Richard");
        example.setCar(carExample3());
        return example;
    }

    public static Lawyer personExample4() {
        Lawyer example = new Lawyer();
        example.setName("Biff");
        example.setCar(sportsCarExample1());
        return example;
    }

    public static Engineer personExample5() {
        Engineer example = new Engineer();
        example.setName("Jenny");
        example.setTitle("Software Engineer");
        return example;
    }

    public static Person personExample6() {
        Person example = new Person();
        example.setName("Brendan");
        example.setCar(carExample4());
        return example;
    }

    public static Car sportsCarExample1() {
        SportsCar example = new SportsCar();
        example.setPassengerCapacity(2);
        example.setFuelCapacity(60);
        example.setDescription("Corvet");
        example.setFuelType("Disel");
        return example;
    }
}
