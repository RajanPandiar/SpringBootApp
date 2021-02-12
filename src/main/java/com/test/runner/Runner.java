package com.test.runner;

import com.test.config.AppConfig;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Runner extends JUnitStories {

    private ApplicationContext ctx;

    public Runner() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }


    public Configuration configuration () {
        return new MostUsefulConfiguration().
                useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder().
                        withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass())).withFormats(Format.CONSOLE,Format.TXT));


    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(),ctx);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),"**/*.story",null);
    }



}
