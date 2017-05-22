[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/incrementor-maven-plugin/blob/master/LICENSE.md)
[![Download](https://api.bintray.com/packages/mauriciotogneri/maven/incrementormavenplugin/images/download.svg)](https://bintray.com/mauriciotogneri/maven/incrementormavenplugin/_latestVersion)

# Incrementor
A Maven plugin that increments the version number after an execution phase (e.g. compile, install, deploy, etc.).

## Configuration

Add the following code to your **pom.xml**:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.mauriciotogneri</groupId>
            <artifactId>incrementormavenplugin</artifactId>
            <version>1.2.0</version>
            <executions>
                <execution>
                    <phase>compile</phase>
                    <goals>
                        <goal>incrementor</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>

<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com</url>
    </repository>
</repositories>
```

If you want to run the plugin after another phase than `compile`, replace it by any of this values:
* `validate`
* `test`
* `package`
* `verify`
* `install`
* `deploy`