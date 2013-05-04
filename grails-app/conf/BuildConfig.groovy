grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
	}

	plugins {
		build ":tomcat:$grailsVersion"
		build ":release:2.0.0"
		runtime ":resources:1.1.6"
	}
}
