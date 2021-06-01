package org.pf4j.demo;

import java.util.List;

import org.pf4j.CompoundPluginDescriptorFinder;
import org.pf4j.DefaultPluginManager;
import org.pf4j.ManifestPluginDescriptorFinder;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.pf4j.demo.api.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Boot {
    private static final Logger logger = LoggerFactory.getLogger(Boot.class);

    public static void main(String[] args) {
        // create the plugin manager
        final PluginManager pluginManager = new DefaultPluginManager() {
            @Override
            protected CompoundPluginDescriptorFinder createPluginDescriptorFinder() {
                return new CompoundPluginDescriptorFinder()
                        // Demo is using the Manifest file
                        // PropertiesPluginDescriptorFinder is commented out just to avoid error log
                        //.add(new PropertiesPluginDescriptorFinder())
                        .add(new ManifestPluginDescriptorFinder());
            }
        };

        // load the plugins
        pluginManager.loadPlugins();

        // enable a disabled plugin
//        pluginManager.enablePlugin("welcome-plugin");

        // start (active/resolved) the plugins
        pluginManager.startPlugins();

        logger.info("Plugindirectory: ");
        logger.info("\t" + System.getProperty("pf4j.pluginsDir", "plugins") + "\n");

        // retrieves the extensions for Greeting extension point
        List<Greeting> greetings = pluginManager.getExtensions(Greeting.class);
        logger.info(String.format("Found %d extensions for extension point '%s'", greetings.size(), Greeting.class.getName()));
        for (Greeting greeting : greetings) {
            logger.info(">>> " + greeting.getGreeting());
        }

        // // print extensions from classpath (non plugin)
        // logger.info(String.format("Extensions added by classpath:"));
        // Set<String> extensionClassNames = pluginManager.getExtensionClassNames(null);
        // for (String extension : extensionClassNames) {
        //     logger.info("   " + extension);
        // }

        // print extensions for each started plugin
        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        for (PluginWrapper plugin : startedPlugins) {
            String pluginId = plugin.getDescriptor().getPluginId();
            logger.info(String.format("Extensions added by plugin '%s':", pluginId));
            // extensionClassNames = pluginManager.getExtensionClassNames(pluginId);
            // for (String extension : extensionClassNames) {
            //     logger.info("   " + extension);
            // }
        }

        // stop the plugins
        pluginManager.stopPlugins();
        /*
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                pluginManager.stopPlugins();
            }

        });
        */
    }
}
