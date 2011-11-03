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

    def title = "Closure Templates Resources Plugin" // Headline display name of the plugin
    def author = "Matt Sheehan"
    def authorEmail = ""
    def description = '''\
This plugin supports server-side compilation of .soy template files to JavaScript files.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/closure-templates-resources"
}
