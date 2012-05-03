class ClosureTemplatesResourcesGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.5 > *"
    // the other plugins this plugin depends on
    def dependsOn = [resources:'1.0 > *']
    def loadAfter = ['resources']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/sheehan/closure-templates-resources/issues" ]
    def scm = [ url: "https://github.com/sheehan/closure-templates-resources" ]

    def title = "Closure Templates Resources Plugin"
    def author = "Matt Sheehan"
    def authorEmail = "mr.sheehan@gmail.com"
    def description = '''\
This plugin supports server-side compilation of .soy template files to JavaScript files.
'''
    def documentation = "https://github.com/sheehan/closure-templates-resources/blob/master/README.md"
}
