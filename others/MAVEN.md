# Maven

To use **maven** in the **command line**, you must install it first:
```bash
sudo apt update
sudo apt install maven -y
```
:warning: **Note**: these commands are for **debian** distros. :warning:

## Create Project

To create a **maven project**, run this command:
```bash
mvn archetype:generate -DgroupId=something.example -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

- `-DgroupId` : indicates the main package of the project
- `-DartifactId` : name of the project
- `-DarchetypeArtifactId` : indicates the model for the java project
- `-DinteractiveMode` : avoids interactive questions

Go into the generated folder.

The **project structure** should be like this:
```plaintext
my-project/
    |--- src/
    |     |--- main/
    |     |     |--- java/
    |     |           |--- something/
    |     |                    |--- example/
    |     |                           |--- App.java
    |     |--- test/
    |           |--- java/
    |                 |--- something/
    |                          |--- example/
    |                                 |--- AppTest.java
    |--- pom.xml
```

## Commands

Maven has multiple **commands** to operate on the project, here is a few:
- `mvn compile` : compiles the code and places the `.class` files in a folder called `target`
- `mvn clean` : removes the `target` folder
- `mvn test` : runs the tests

## Version problems

When running `mvn compile` there may be some problems with the version of Java, to sort that out check the version of the java compiler or java:
```bash
javac -version
java -version
```

Open the `pom.xml` file, and place this before the **dependencies**:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>17</source>   <!-- change this to match your Java version -->
                <target>17</target>   <!-- change this to match your Java version -->
            </configuration>
        </plugin>
    </plugins>
</build>
```
