# Closure Templates Resources plug-in for Grails

This plug-in converts HTML templates into JavaScript functions using Google's Closure Templates.

Closure Templates Documentation: https://developers.google.com/closure/templates/

Note: Google's Closure JavaScript library is not required to use Closure Templates.

## Templates

Closure Templates allow you to compile HTML templates into JavaScript functions. The template file includes a namespace declaration followed by one or more templates.

Example file: webapp/soy/task.soy

    {namespace grails.views.task}

    /**
     * @param $name
     * @param $dateDue
     */
    {template .show}
      <div>
        <div>Name: {$name}</div>
        <div>Date Due: {$dateDue}</div>
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

You can invoke the template from JavaScript using the namespace and the template name like this:

    var html = grails.views.task.show({name:'Pay bills', dateDue: '11/11/2011'});

The resulting html can then be inserted into the DOM:

    document.getElementById('myContainer').innerHTML = html;

Full documentation can be found [here](https://developers.google.com/closure/templates/docs/overview).

## Usage

    modules = {
    
        task {
            dependsOn 'soyutils'

            resource url:'js/some-other-file.js'
            resource url: '/soy/task.soy', attrs:[type:'js']
        }
    }
    
Note:

*   The template file must have a .soy extension
*   attrs[type] must be set to 'js'
*   'soyutils' must be in the dependsOn list. If you're using Google Closure JavaScript library, 'soyutils_usegoog' should be used instead.

