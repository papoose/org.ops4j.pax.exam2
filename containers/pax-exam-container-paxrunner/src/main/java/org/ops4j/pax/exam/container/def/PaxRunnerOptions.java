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
package org.ops4j.pax.exam.container.def;

import java.util.ArrayList;
import java.util.List;
import static org.ops4j.lang.NullArgumentException.*;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.container.def.options.*;
import org.ops4j.pax.exam.options.DefaultCompositeOption;
import org.ops4j.pax.exam.options.UrlReference;

/**
 * Factory methods for Pax Runner options.
 *
 * @author Alin Dreghiciu (adreghiciu@gmail.com)
 * @since 0.3.0, December 08, 2008
 */
public class PaxRunnerOptions
{

    /**
     * Utility class. Ment to be used via the static factory methods.
     */
    private PaxRunnerOptions()
    {
        // utility class
    }

    /**
     * Creates a composite option of {@link ProfileOption}.
     *
     * @param profiles profile options
     *
     * @return composite option of profiles options
     */
    public static Option profiles( final ProfileOption... profiles )
    {
        return new DefaultCompositeOption( profiles );
    }

    /**
     * Creates a {@link ProfileOption} by profile name.
     *
     * @param name profile name
     *
     * @return profile option
     */
    public static ProfileOption profile( final String name )
    {
        return new ProfileOption( name );
    }

    /**
     * Creates a {@link ProfileOption} by profile name and version.
     *
     * @param name    profile name
     * @param version profile version
     *
     * @return profile option
     */
    public static ProfileOption profile( final String name,
                                         final String version )
    {
        return new ProfileOption( name, version );
    }

    /**
     * Creates a Http Service {@link ProfileOption} (--profiles=web).
     *
     * @return web profile option
     */
    public static ProfileOption webProfile()
    {
        return new ProfileOption( "web" );
    }

    /**
     * Creates a Log Service {@link ProfileOption} (--profiles=log).
     *
     * @return log profile option
     */
    public static ProfileOption logProfile()
    {
        return new ProfileOption( "log" );
    }

    /**
     * Creates a Configuration Admin Service {@link ProfileOption} (--profiles=config).
     *
     * @return config profile option
     */
    public static ProfileOption configProfile()
    {
        return new ProfileOption( "config" );
    }

    /**
     * Creates a Declarative Service {@link ProfileOption} (--profiles=ds).
     *
     * @return ds profile option
     */
    public static ProfileOption dsProfile()
    {
        return new ProfileOption( "ds" );
    }

    /**
     * Creates a Log Service {@link ProfileOption} (--profiles=compendium).
     *
     * @return log profile option
     */
    public static ProfileOption compendiumProfile()
    {
        return new ProfileOption( "compendium" );
    }
    
    /**
     * Creates a {@link CleanCachesOption}.
     *
     * @return clean caches option
     */
    public static CleanCachesOption cleanCaches()
    {
        return new CleanCachesOption();
    }

   

    /**
     * Creates a composite option of {@link VMOption}s.
     *
     * @param vmOptions virtual machine options (cannot be null or containing null entries)
     *
     * @return composite option of virtual machine options
     *
     * @throws IllegalArgumentException - If urls array is null or contains null entries
     */
    public static Option vmOptions( final String... vmOptions )
    {
        validateNotEmptyContent( vmOptions, true, "VM options" );
        final List<VMOption> options = new ArrayList<VMOption>();
        for( String vmOption : vmOptions )
        {
            options.add( vmOption( vmOption ) );
        }
        return vmOptions( options.toArray( new VMOption[options.size()] ) );
    }

    /**
     * Creates a composite option of {@link VMOption}s.
     *
     * @param vmOptions virtual machine options
     *
     * @return composite option of virtual machine options
     */
    public static Option vmOptions( final VMOption... vmOptions )
    {
        return new DefaultCompositeOption( vmOptions );
    }

    /**
     * Creates a {@link VMOption}.
     *
     * @param vmOption virtual machine option
     *
     * @return virtual machine option
     */
    public static VMOption vmOption( final String vmOption )
    {
        return new VMOption( vmOption );
    }

    /**
     * Creates a {@link org.ops4j.pax.exam.container.def.options.RawPaxRunnerOptionOption}.
     *
     * @param key   option name (key)
     * @param value option value
     *
     * @return a PaxRunner Option instance.
     */
    public static RawPaxRunnerOptionOption rawPaxRunnerOption( final String key,
                                                               final String value )
    {
        return new RawPaxRunnerOptionOption( key, value );
    }

    /**
     * Creates a {@link org.ops4j.pax.exam.container.def.options.RawPaxRunnerOptionOption}.
     *
     * @param option full Pax Runner option (including --)
     *
     * @return a PaxRunner Option instance.
     */
    public static RawPaxRunnerOptionOption rawPaxRunnerOption( final String option )
    {
        return new RawPaxRunnerOptionOption( option );
    }

    /**
     * Creates a composite option of {@link RepositoryOption}s.
     *
     * @param repositoryUrls virtual machine options (cannot be null or containing null entries)
     *
     * @return composite option of virtual machine options
     *
     * @throws IllegalArgumentException - If urls array is null or contains null entries
     */
    public static Option repositories( final String... repositoryUrls )
    {
        validateNotEmptyContent( repositoryUrls, true, "Repository URLs" );
        final List<RepositoryOption> options = new ArrayList<RepositoryOption>();
        for( String repositoryUrl : repositoryUrls )
        {
            options.add( repository( repositoryUrl ) );
        }
        return repositories( options.toArray( new RepositoryOption[options.size()] ) );
    }

    /**
     * Creates a composite option of {@link RepositoryOption}s.
     *
     * @param repositoryOptions repository options
     *
     * @return composite option of repository options
     */
    public static Option repositories( final RepositoryOption... repositoryOptions )
    {
        return new DefaultCompositeOption( repositoryOptions );
    }

    /**
     * Creates a {@link LocalRepositoryOption}.
     *
     * @param path localRepository path or url
     *
     * @return localRepository option
     */
    public static LocalRepositoryOption localRepository( final String path )
    {
        return new LocalRepositoryOption( path );
    }

    /**
     * Creates a {@link RepositoryOption}.
     *
     * @param repositoryUrl repository url
     *
     * @return repository option
     */
    public static RepositoryOption repository( final String repositoryUrl )
    {
        return new RepositoryOptionImpl( repositoryUrl );
    }

    /**
     * Creates a {@link ExcludeDefaultRepositoriesOption}.
     *
     * @return option
     */
    public static ExcludeDefaultRepositoriesOption excludeDefaultRepositories()
    {
        return new ExcludeDefaultRepositoriesOption();
    }

    /**
     * Creates a {@link RawScannerProvisionOption}.
     *
     * @param provisionSpec raw provisioning spec
     *
     * @return raw scanner option
     */
    public static RawScannerProvisionOption scan( final String provisionSpec )
    {
        return new RawScannerProvisionOption( provisionSpec );
    }

    /**
     * Creates a {@link DirScannerProvisionOption}.
     *
     * @param directory directory to be scanned
     *
     * @return directory scanner option
     */
    public static DirScannerProvisionOption scanDir( final String directory )
    {
        return new DirScannerProvisionOption( directory );
    }

    /**
     * Creates a {@link PomScannerProvisionOption}.
     *
     * @param url to pom
     *
     * @return pom scanner option
     */
    public static PomScannerProvisionOption scanPom( final String url )
    {
        return new PomScannerProvisionOption( url );
    }

    /**
     * Creates a {@link PomScannerProvisionOption}.
     *
     * @return pom scanner option
     */
    public static PomScannerProvisionOption scanPom()
    {
        return new PomScannerProvisionOption();
    }

    /**
     * Creates a {@link FileScannerProvisionOption}.
     *
     * @param fileUrl url of the file to be scanned
     *
     * @return file scanner option
     */
    public static FileScannerProvisionOption scanFile( final String fileUrl )
    {
        return new FileScannerProvisionOption( fileUrl );
    }

    /**
     * Creates a {@link FileScannerProvisionOption}.
     *
     * @param fileUrl url of the file to be scanned
     *
     * @return file scanner option
     */
    public static FileScannerProvisionOption scanFile( final UrlReference fileUrl )
    {
        return new FileScannerProvisionOption( fileUrl );
    }

    /**
     * Creates a {@link FeaturesScannerProvisionOption}.
     *
     * @param repositoryUrl url of features respository to be scanned
     * @param features      features to be scanned
     *
     * @return file scanner option
     */
    public static FeaturesScannerProvisionOption scanFeatures( final String repositoryUrl,
                                                               final String... features )
    {
        return new FeaturesScannerProvisionOption( repositoryUrl, features );
    }

    /**
     * Creates a {@link FileScannerProvisionOption}.
     *
     * @param repositoryUrl url of features respository to be scanned
     * @param features      features to be scanned
     *
     * @return file scanner option
     */
    public static FeaturesScannerProvisionOption scanFeatures( final UrlReference repositoryUrl,
                                                               final String... features )
    {
        return new FeaturesScannerProvisionOption( repositoryUrl, features );
    }

    /**
     * Creates a {@link CompositeScannerProvisionOption}.
     *
     * @param fileUrl url of the file to be scanned
     *
     * @return composite scanner option
     */
    public static CompositeScannerProvisionOption scanComposite( final String fileUrl )
    {
        return new CompositeScannerProvisionOption( fileUrl );
    }

    /**
     * Creates a {@link CompositeScannerProvisionOption}.
     *
     * @param fileUrl url of the file to be scanned
     *
     * @return composite scanner option
     */
    public static CompositeScannerProvisionOption scanComposite( final UrlReference fileUrl )
    {
        return new CompositeScannerProvisionOption( fileUrl );
    }

    /**
     * Creates a {@link AutoWrapOption}.
     *
     * @return AutoWrapOption
     */
    public static AutoWrapOption autoWrap()
    {
        return new AutoWrapOption();
    }

    /**
     * Creates a {@link BundleScannerProvisionOption}.
     *
     * @param bundleUrl url of the bundle to be scanned
     *
     * @return bundle scanner option
     */
    public static BundleScannerProvisionOption scanBundle( final String bundleUrl )
    {
        return new BundleScannerProvisionOption( bundleUrl );
    }

    /**
     * Creates a {@link BundleScannerProvisionOption}.
     *
     * @param bundleUrl url of the bundle to be scanned
     *
     * @return bundle scanner option
     */
    public static BundleScannerProvisionOption scanBundle( final UrlReference bundleUrl )
    {
        return new BundleScannerProvisionOption( bundleUrl );
    }

    /**
     * Creates a {@link WorkingDirectoryOption}.
     *
     * @param directory url of the bundle to be scanned
     *
     * @return working directory option
     */
    public static WorkingDirectoryOption workingDirectory( final String directory )
    {
        return new WorkingDirectoryOption( directory );
    }

}
