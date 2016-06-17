**Purpose**

The purpose of this application is to convert csv files to kml files to be able to
look the recorded trip on Google Earth.

**How It Works**

The expected format of the csv file should have 7 values on the first line that indicate the trip ID, the destination stop ID,
the latitude of the destination,the longitude of the destination, the previous stop ID, the latitude of the previous stop,
and the longitude of the previous stop. The rest of the lines should have 10 values which indicate the coordinateID, the getReadyFlag,
the time in nanoseconds since the application was started, the time in UTC, the latitude, the longitude, the altitude,
the speed, the bearing, the accuracy, the accuracy, the number of satellites, and the provider.In order to execute the
application, the user should click on run and then click on edit configurations. On the next window, the user should click on
the program arguments box and put the desire input file, i.e "-i /Users/Documents/Research/csv_files".
The only command option value is "i" and is used to be able to indicate the path of the input file.