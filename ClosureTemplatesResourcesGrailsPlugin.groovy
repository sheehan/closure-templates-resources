class ClosureTemplatesResourcesGrailsPlugin {
    def version = "0.2"
    def grailsVersion = "1.3.5 > *"
    def loadAfter = ['resources']

    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/sheehan/closure-templates-resources/issues" ]
    def scm = [ url: "https://github.com/sheehan/closure-templates-resources" ]

    def title = "Closure Templates Resources Plugin"
    def author = "Matt Sheehan"
    def authorEmail = "mr.sheehan@gmail.com"
    def description = 'This plugin supports server-side compilation of .soy template files to JavaScript files.'
    def documentation = "https://github.com/sheehan/closure-templates-resources/blob/master/README.md"
}
