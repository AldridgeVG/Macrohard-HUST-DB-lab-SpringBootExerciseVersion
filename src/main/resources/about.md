# usage
##static/
    save all static resources
    e.g. js,css,images
##templates/
    save all template page
    Spring Boot use default jar insertion Tomcat, provides no support for jsp pages
##application.properties
    global configuration file of a SpringBoot apps
    application.properties / application.yml
##YAML
###YAML grammar
    k: v signifys a key-value pair
    space count signifys level of domain
    
    String(default no quotation mark):
        sample string : output "sample string"
        'sample \n string': output "sample /n string"
        "sample \n string": output "sample
                                    string"
    
    MAP
        friends:
            lm: Geogre
            ag: 40                           
            
    List/Set
        pets:(signify elem of array by " - elem")
            - cat
            - dog
            - pig
        
        pets: [cat,dog,pig]