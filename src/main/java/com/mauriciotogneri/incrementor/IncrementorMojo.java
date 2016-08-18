package com.mauriciotogneri.incrementor;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "incrementor")
public class IncrementorMojo extends AbstractMojo
{
    @Parameter(defaultValue = "${basedir}")
    private String projectDir;

    public void execute() throws MojoExecutionException
    {
        try
        {
            File file = new File(String.format("%s/pom.xml", projectDir));
            Incrementor incrementor = new Incrementor();
            incrementor.increment(file);
        }
        catch (Exception e)
        {
            throw new MojoExecutionException("Error incrementing version", e);
        }
    }
}