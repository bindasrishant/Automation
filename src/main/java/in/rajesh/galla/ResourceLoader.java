package in.rajesh.galla;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Galla on 2/26/2015.
 */
public class ResourceLoader {

    public static Properties loadGradleResource(String fileName) throws Exception {

        File resourceFile = new File(fileName);
        if (resourceFile.exists()) {

            Properties properties = new Properties();
            FileInputStream props = new FileInputStream(resourceFile);
            properties.load(props);
            return properties;
        }
        return null;
    }

}
