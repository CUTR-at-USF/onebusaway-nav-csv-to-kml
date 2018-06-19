# onebusaway-nav-csv-to-kml [![Build Status](https://travis-ci.org/CUTR-at-USF/onebusaway-nav-csv-to-kml.svg?branch=master)](https://travis-ci.org/CUTR-at-USF/onebusaway-nav-csv-to-kml)
Converts a trip recorded using the OneBusAway navigation feature from CSV format to KML, so it can be visualized using [Google Earth](https://www.google.com/earth/).

A work-in-progress pull request for destination alerts for OneBusAway Android is at https://github.com/OneBusAway/onebusaway-android/pull/873.

## Usage

Run the `Main.java main()` method, with the command line parameter `-i` of the path to the CSV file(s).

For example, if your CSV files are in `c:\test files`, you would pass `-i "c:\test files"`.

Note that you should *NOT* include a final `\` at the end of the file path.

## Input CSV file format

When recording data using OneBusAway, the log file is a CSV file written to the "ObaNavLog" folder on your external storage root directory. The filename format is `<TestID>-<Date/time of test>.csv`. For example, `1-Thu, Aug 25 2016, 04:20 PM.csv`. 
  
The first line of the file includes the following information in this order (delimited by commas): 

1. trip ID
1. destination Stop ID
1. latitude of the destination
1. longitude of the destination
1. stop ID of the Stop before the final Stop
1. latitude of the stop before the final stop
1. longitude of the stop before the last stop

Starting from the second line, here are the columns that contain the position data:

1. coordinateID - unique ID for each location fix in the file
1. getReadyFlag - true if the "Get Ready" alert has been announced to the user, false if it has not
1. pullTheCordNowFlag - true if the "Pull the Cord Now" alert has been announced to the user, false if it has not
1. the time in nanoseconds since the application started
1. the time in UTC
1. latitude
1. longitude
1. altitude
1. speed
1. bearing
1. horizontal accuracy
1. number of satellites used in fix
1. location provider

For example:

~~~
Hillsborough Area Regional Transit_144477,Hillsborough Area Regional Transit_6497,28.066021,-82.429922,Hillsborough Area Regional Transit_3075,28.065622,-82.427307,,,,,,
0,FALSE,FALSE,1327025000000,1466618929014,28.050549,-82.416169,0,0,0,36,0,network
1,FALSE,FALSE,1327025000000,1466618929014,28.050549,-82.416169,0,0,0,36,0,network
2,FALSE,FALSE,1327025000000,1466618929014,28.050549,-82.416169,0,0,0,36,0,network
3,FALSE,FALSE,1340292932060,1466618943000,28.051408,-82.416176,11,13.25,0.4,19,11,gps
4,FALSE,FALSE,1340292932060,1466618943000,28.051408,-82.416176,11,13.25,0.4,19,11,gps
5,FALSE,FALSE,1341291856798,1466618944000,28.051546,-82.416175,2,14.25,359.899994,5,11,gps
...
~~~

## KML output

A KML file compatible with [Google Earth](https://www.google.com/earth/) will be generated for each CSV file matching the above format in the provided directory.

The KML file will contain the following markers, typically encountered in this order when looking at a trip from start to finish:

* Yellow markers - Real-time locations recorded by the app (e.g., GPS fixes)
* Red marker - The real-time location that triggered the "Get ready" alert
* Bus stop icon with title "Previous stop" - the transit stop prior to the destination stop
* Green marker - The real-time location that triggered the "Pull the cord now" alert
* Bus stop icon with title "End" - The destination stop of the user where they indicated they wanted to exit the transit vehicle

Here's a sample screenshot of Google Earth showing these markers (from `nav_trip11.csv` in the OneBusAway Android project):

 ![image](https://user-images.githubusercontent.com/928045/41626682-0af1e62e-73eb-11e8-8524-b55ebc17b433.png)
