# Wildlife-Tracker

#### By **Matthew F Nicholas**

## Description
A web application designed to help rangers track sightings of wild animals.

## Setup/Installation Requirements
* open the directory in the console
* build the database with the following command:
    -Connect to psql and run:
        # CREATE DATABASE wildlife_tracker;
    -Now from the command line run:
        $ psql wildlife_tracker < database.sql
* compile and run App.class


### BDD
| Behavior:                                          | Input Example:                             | Output Example:                            |
|----------------------------------------------------|--------------------------------------------|--------------------------------------------|
| Can log animal species                             | "Deer"                                     |  "Deer"                                    |
| Can log animal age                                 | "Young"                                    |  "Young"                                   |
| Can log animal health                              | "Okay"                                     |  "Okay"                                    |
| Can log sighting ranger                            | "Matt"                                     |  "Matt"                                    |
| Can log sighting location                          | "The back 40"                              |  "The back 40"                             |
| Can edit details about a sighting                  | "Whitetail Deer"                           | "Whitetail Deer"                           |
| Displays error message if a for field is empty     | "Whitetail Deer"                           | "Whitetail Deer"                           |
| Sightings can be deleted                           | null                                       | null                                       |
|                                                    |                                            |                                            |
| Sightings can be filtered by attributes            | "Loacation"                                | Only sightings from same location will be  | |displayed                                           |


## Support and contact details
Matt Nicholas: fostermatt82@gmail.com

## Technologies Used
  This site was designed using HTML, Bootstrap, Java, Spark, Junit, Velocity, and PostgreSQL. View the source code at https://github.com/Matt-Nicholas/java-w3-solo-hair-salon
### License
*This site is Licensed under the MIT licensing*

Copyright (c) 2016 **_Matt Nicholas_**
