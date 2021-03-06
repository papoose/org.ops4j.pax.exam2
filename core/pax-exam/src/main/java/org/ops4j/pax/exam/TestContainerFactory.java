/*
 * Copyright 2008 Alin Dreghiciu.
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
package org.ops4j.pax.exam;

/**
 * {@link TestContainer} factory.
 *
 * Depending on the OptionDescription created by {@link #parse(Option...)} there is a contract with the {@link org.ops4j.pax.exam.OptionDescription}
 * you can put into {@link #createContainer}.
 *
 * @author Alin Dreghiciu (adreghiciu@gmail.com)
 * @since 0.3.0, December 09, 2008
 */
public interface TestContainerFactory
{

    /**
     * Creates a one or more {@link OptionDescription}. Depending on the underlying implementation.
     *
     * @param options integration test options
     *
     * @return created test container
     */
    OptionDescription[] parse( Option... options );

    /**
     * 
     * @param option
     * @return
     */
    TestContainer createContainer( OptionDescription option );


}
