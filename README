# Closure Templates Resources plug-in for Grails

This plug-in converts HTML templates into JavaScript functions using Google's [Closure Templates](http://code.google.com/closure/templates/).

Note: Google's Closure JavaScript library is not required to use Closure Templates.

## Templates

Closure Templates allow you to compile HTML templates into JavaScript functions. 

Given this template: 

    {namespace example.templates}

    /**
     * @param name
     */
    {template .hello}
      <h1>Hello, {$name}</h1>
    {/template}

You can invoke the template from JavaScript like this:

    var html = example.templates.hello({name:'Matt'})

Full documentation can be found [here](http://code.google.com/closure/templates/docs/overview.html).

## Usage

Example file: webapp/soy/task.soy

    {namespace grails.views.task}

    /**
     * @param taskInstance
     */
    {template .show}
      <div>
        <div>Name: {$taskInstance.name}</div>
        <div>Date Due: {$taskInstance.dateDue}</div>
      </div>
    {/template}

    /**
     * @param taskInstanceList
     */
    {template .list}
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Date Due</th>
          </tr>
        </thead>
        <tbody>
          {foreach $taskInstance in $taskInstanceList}
            <tr>
              <td>{$taskInstance.name}</td>
              <td>{$taskInstance.dateDue}</td>
            </tr>
           {/foreach}
        </tbody>
      </table>
    {/template}

## Declaring in resources

    modules = {
    
        task {
            dependsOn 'soyutils'

            resource url:'js/some-other-file.js'
            resource url: '/soy/task.soy', attrs:[type:'js']
        }
    }
