# Closure Templates Resources plug-in for Grails

This plug-in converts HTML templates into JavaScript functions using Google's [Closure Templates](https://developers.google.com/closure/templates/).

Note: Google's Closure JavaScript library is not required to use Closure Templates.

## Templates

Closure Templates allow you to compile HTML templates into JavaScript functions. The template file includes a namespace declaration followed by one or more templates. 

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

The templates are then available as JavaScript functions on the namespace object. You can invoke the template from JavaScript like this:

    var html = grails.views.task.show({name:'Pay bills', dateDue: '11/11/2011'});

The html can then be inserted into the DOM:

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

