Enterprise Java Beans (EJB) Setup
==============

## Maven

The Liberty Maven plug-in and WebSphere Developer Tools support creating loose applications. This example creates a loose EAR application when building using Maven. After running the full build, you will see the application installed as `sample.ejb/ejb-ear/target/liberty/wlp/usr/servers/ejbServer/apps/ejb-ear.ear.xml`.

### Using Eclipse with Maven

1. Clone this project and import into Eclipse as an 'Existing Maven Project'.
2. Right-click the project and select **Run As > Maven Clean**.
3. Right-click the project and select **Run As > Maven Install**.
4. Right-click the project and select Run As -> Run on Server.
5. You should see the following in the console: `Application EJBSample started in XX.XX seconds.`

### Using the command-line with Maven 

This project can be built with Apache Maven. The project uses the [Liberty Maven Plug-in] to automatically download and install the Liberty Java EE 7 Full Platform 7 runtime from [Maven Central]. The Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server. 

Use the following steps to run the application with Maven:

1. Execute the full Maven build. The Liberty Maven Plug-in will download and install the Liberty server in the `ejb-ear` project. It will also run all tests.
    ```bash
    $ mvn clean install
    ```

2. To run the server in the `ejb-ear` subproject:
    ```bash
    $ mvn --projects ejb-ear liberty:run-server
    ```
    The `--projects` and `-pl` are equivalent options.

# Notice

© Copyright IBM Corporation 2017.

# License

```text
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````

[Liberty Maven Plug-in]: https://github.com/WASdev/ci.maven
[Maven Central]: https://search.maven.org/
