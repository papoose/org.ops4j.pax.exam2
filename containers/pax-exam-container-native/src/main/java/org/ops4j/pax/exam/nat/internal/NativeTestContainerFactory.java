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
package org.ops4j.pax.exam.nat.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.OptionDescription;
import org.ops4j.pax.exam.TestContainer;
import org.ops4j.pax.exam.TestContainerFactory;

/**
 * Stateful
 *
 * If would be really cool if this native runner would accept more than one osgi fw in classpath. Though this might not work due to dangerous cp
 * issues.
 *
 * @author Toni Menzel
 * @since Jan 7, 2010
 */
public class NativeTestContainerFactory implements TestContainerFactory
{

    final private Map<OptionDescription, TestContainer> m_registry = new HashMap<OptionDescription, TestContainer>();

    public OptionDescription[] parse( Option... options )
    {
        // TODO add some splitter logic for separating framework options (which leads to bigger result arrays, not just single value
        // fully prepare
        // find implementations:

        NativeTestContainerParser parser = new NativeTestContainerParser( options );
        ArrayList<String> bundles = parser.getBundles();//new NativeTestContainerParser().get( options );
        TestContainer container = new NativeTestContainer( bundles );
        OptionDescription descr = parser.getDescription();

        m_registry.put( descr, container );
        return new OptionDescription[]{
            descr
        };
    }

    public TestContainer createContainer( OptionDescription option )
    {
        return m_registry.get( option );
    }
}
