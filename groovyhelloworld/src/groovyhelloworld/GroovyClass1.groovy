package groovyhelloworld

class GroovyClass1
{
  static void main(def args) {
    println "Hello Groovy!"
    
    def field4 = "one tag, , two tag"
    //def field4 = " "
    println "field4: |${field4}|"
    
    println "tokenize: |${field4.replaceAll('"', '').tokenize(",")}|"
    
    
    def tags    = field4.replaceAll('"', '').tokenize(",").collect { it.trim() }
    
    println "tags: |${tags}|"

    println "tags found in csv: ${tags.size()}"
    println "tags value in csv: ${tags}"
    println "tags value in csv: |${tags[0]}|"

    if ( tags )
    {
      println "tags is true"
    }
    else
    {
      println "tags is false"
    }

    def tags2    = field4.replaceAll('"', '').tokenize(",").collect { it.trim() }.findAll{it.length() > 0}
    
    println "tags2: |${tags2}|"
    
    println "tags2 found in csv: ${tags2.size()}"
    println "tags2 value in csv: ${tags2}"
    println "tags2 value in csv: |${tags2[0]}|"
    
    if ( tags2 )
    {
      println "tags2 is true"
    }
    else
    {
      println "tags2 is false"
    }
    
    System.exit(0);
    
    
    
    //DEBUG: org: [org id: d1a32d152d4f4c638b6e07b46e543b1b, name: CSV tags: [[tag id: d1d59eda9ade4b72b41686d889157ae0, name:fooTag, description:Proper description for fooTag required, color:red], [tag id: 1b0042c84c3f4755a4ace25006ec1f87, name:newTag, description:Proper description for newTag required, color:red]]]
    
    //DEBUG: tagNames: [newTag, fooTag]
    //def tagNames = ["newTag", "fooTag"]
    def tagNames = ["Distributed"]
    
    
    //DEBUG: hierarchyTags: [[tag id: 20f25a11a0ad4302a45f7d933c29ffe3, name:Distributed, description:Applications that are provided for consumption outside the company, color:yellow], 
    //                       [tag id: 32f2f7a03b3242bbbabce04cdadbebdf, name:Hosted, description:Applications that are hosted such as services or software as a service., color:light-purple], 
    //                       [tag id: d58c84b2baff4d828030b58ff768d95f, name:Internal, description:Applications that are used only by your employees, color:dark-green], 
    //                       [tag id: 0f58ec1debba49eeb359c233f52e6b7f, name:PCI, description:PCIDSS, color:dark-red]]
    def hierarchyTags = [
      [ id: 123, name: "Distributed", description: "Applications that are provided for consumption outside the company", color: "yellow"],
      [ id: 456, name: "Hosted", description: "Applications that are hosted such as services or software as a service", color: "light-purple"],
      [ id: 789, name: "Internal", description: "Applications that are used only by your employees", color: "dark-green"],
      ]
    
    println "DEBUG: tagNames ${tagNames}"
    println "DEBUG: hierarchyTags ${hierarchyTags}"
    
    def orgTags = tagNames.collect { tagName ->
      ["tagId": hierarchyTags.find{ it.name == tagName }.id]
    }
  
    println "DEBUG: orgTags: ${orgTags}"
  
    
//    def json = new groovy.json.JsonBuilder()
//    json {
//      id "d1a32d152d4f4c638b6e07b46e543b1b"
//      name "CSV"
//      tags 1,2,3
//    }
//    println "saving org: " + json.toPrettyString()

        //def o = new Organization(json)
    //println "Org: ${o}"
    
    
    
    
    
    
    
    
  }
}

/**
 *
 * Value object for Organization
 *
 */
class Organization {
  def id
  def name
  def tags

  public Organization(o){
    this.id = o.id
    this.name = o.name
    this.tags = o.tags.collect { new Tag(it) }
  }

  String toString(){
    return "[org id: ${id}, name: ${name} tags: ${tags}]\n"
  }
}

/**
 *
 * Value object for Tags (within the organization)
 *
 */
class Tag {
  def id
  def name
  def description
  def color

  public Tag(o){
    this.id = o.id
    this.name = o.name
    this.description = o.description
    this.color = o.color
  }
  String toString() {
    return "[tag id: ${id}, name:${name}, description:${description}, color:${color}]"
  }
}
