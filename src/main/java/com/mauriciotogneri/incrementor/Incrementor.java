package com.mauriciotogneri.incrementor;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;

public class Incrementor
{
    public static void main(String[] args) throws Exception
    {
        File file = new File(args[0]);
        Incrementor incrementor = new Incrementor();
        incrementor.increment(file);
    }

    public void increment(File file) throws Exception
    {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(file);
        Element root = document.getRootElement();

        for (Element element : root.getChildren())
        {
            if (element.getName().equals("version"))
            {
                String currentVersion = element.getValue();
                String newVersion = nextVersion(currentVersion);

                element.removeContent();
                element.addContent(newVersion);

                XMLOutputter xmlOutput = new XMLOutputter();
                xmlOutput.setFormat(Format.getPrettyFormat().setTextMode(Format.TextMode.PRESERVE));
                xmlOutput.output(document, new FileWriter(file));

                break;
            }
        }
    }

    private String nextVersion(String version)
    {
        StringBuilder builder = new StringBuilder();
        String[] parts = version.split("\\.");

        for (int i = 0; i < (parts.length - 1); i++)
        {
            builder.append(parts[i]).append(".");
        }

        builder.append(Integer.parseInt(parts[parts.length - 1]) + 1);

        return builder.toString();
    }
}