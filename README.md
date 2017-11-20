A very basic starter application to demonstrate a single machine single server setup with only one topic. 
Messages sent to the topic will be stored in MongoDB for future reference.

This application usage Spring boot 2.0.0 so you should have a local installation of gradle with version>=4 with JDK8

To run the application
Make Sure zookeeper and kafka is running on your machine

1. Clone repository
2. change application.properties as per your mongo username and password.
2. cd to the <Directory> where build.gradle is residing.
3. execute "gradle build" from command prompt you can also execute "gradle test" to verify tests are running.
4. If tests are successfull you should be seeing some records in collection "payload" in mongo.
5. For any modification or to have the complete view of Source open project in intellij idea or add eclipse plugin in build.gradle(for better classpath setup).
 
