# Incrementor
A Maven plugin that increments the version number after an execution phase (e.g. compile, install, deploy, etc.).

## Configuration

Add the following code to your **pom.xml**:

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>com.github.mauriciotogneri</groupId>
                <artifactId>incrementor-maven-plugin</artifactId>
                <version>1.0.0</version>
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
    
    <pluginRepositories>
        <pluginRepository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </pluginRepository>
    </pluginRepositories>
```

If you want to run the plugin after another phase than `compile`, replace it by any of this values:
* `validate`
* `test`
* `package`
* `verify`
* `install`
* `deploy`