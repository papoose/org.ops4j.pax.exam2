/*
 * Copyright 2009 Toni Menzel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.exam.tutorial1;

import org.junit.Test;
import org.ops4j.pax.exam.OptionDescription;
import org.ops4j.pax.exam.TestContainer;
import org.ops4j.pax.exam.TestContainerFactory;
import org.ops4j.pax.exam.container.def.internal.PaxRunnerTestContainerFactory;
import org.ops4j.pax.exam.spi.ProbeCall;
import org.ops4j.pax.exam.spi.TestProbeProvider;
import org.ops4j.pax.exam.spi.container.PaxExamRuntime;

import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.*;
import static org.ops4j.pax.exam.spi.container.DefaultRaw.*;

/**
 * @author Toni Menzel
 * @since Jan 29, 2010
 */
public class T2S3_HandrolledTest
{

    @Test
    public void testPlan()
        throws Exception
    {
        TestContainerFactory factory = PaxExamRuntime.getTestContainerFactory( PaxRunnerTestContainerFactory.class );
        OptionDescription[] testTargets = factory.parse(
            options(
                logProfile(),
                rawPaxRunnerOption( "log", "debug" ),
                mavenBundle().groupId( "org.apache.felix" ).artifactId( "org.apache.felix.dependencymanager" ).version( "3.0.0-SNAPSHOT" )
            )
        );

        for( OptionDescription description : testTargets )
        {

            // here we take a handrolled probe bundle

            TestProbeProvider probe = probe( fromURL( "file:samples/probe1/target/samples.probe1-2.0.0-SNAPSHOT.jar" ), "mytest" );
            TestContainer testContainer = factory.createContainer( description );
            try
            {
                testContainer.install( probe.getStream() );
                for( ProbeCall call : probe.getTests() )
                {
                    execute( testContainer, call );
                }
            } finally
            {
                testContainer.stop();
            }
        }
    }


}
