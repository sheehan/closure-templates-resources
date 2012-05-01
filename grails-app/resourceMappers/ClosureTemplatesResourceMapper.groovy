/**
 * @author Matt Sheehan
 *
 * Mapping file to compile .soy files into .js files.
 */

import com.google.template.soy.SoyFileSet
import com.google.template.soy.jssrc.SoyJsSrcOptions
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.grails.plugin.resource.mapper.MapperPhase

class ClosureTemplatesResourceMapper implements GrailsApplicationAware {

    GrailsApplication grailsApplication

    def phase = MapperPhase.GENERATION

    static defaultIncludes = ['**/*.soy']

    def map(resource, config) {
        File originalFile = resource.processedFile
        File target

        if (resource.sourceUrl) {
            File input = getOriginalFileSystemFile(resource.sourceUrl);
            target = new File(generateCompiledFileFromOriginal(originalFile.absolutePath))

            if (log.debugEnabled) {
                log.debug "Compiling soy file [${originalFile}] into [${target}]"
            }
            try {
                List files = [input] // TODO bundle
                def builder = new SoyFileSet.Builder()
                files.each { builder.add it }
                SoyFileSet sfs = builder.build()
                List<String> compileToJsSrc = sfs.compileToJsSrc(new SoyJsSrcOptions(), null)

                def w = target.newWriter()
                w << compileToJsSrc.join("\n")
                w.close()

                resource.processedFile = target
                resource.sourceUrlExtension = 'js'
                resource.actualUrl = generateCompiledFileFromOriginal(resource.originalUrl)
                resource.contentType = 'text/javascript'
            } catch (e) {
                log.error("error compiling soy file: ${originalFile}", e)
                e.printStackTrace()
            }
        }
    }

    private String generateCompiledFileFromOriginal(String original) {
        original.replaceAll(/(?i)\.soy/, '.js')
    }

    private File getOriginalFileSystemFile(String sourcePath) {
        grailsApplication.parentContext.getResource(sourcePath).file
    }
}
