# usage
##resources/
    save all static resources
##static/
    save all static resources
    e.g. js,css,images
##templates/
    save all template page
    Spring Boot use default jar insertion Tomcat, provides no support for jsp pages
##application.properties
    global configuration file of a SpringBoot apps
    application.properties / application.yml
    
    properties/tmal can be placed in:
        1.file:./config/
        2.file:./
        3.classpath:/config/
        4.classpath:/
    (order by priority desc)
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
 
 ##thymeleaf
    according to thymeleaf:
        public static final String DEFAULT_PREFIX = "classpath:/templates/";
        public static final String DEFAULT_SUFFIX = ".html";
    find files in resources/templates, append .html
    
 ###thymeleaf grammar
    1. use html head <html lang="en" xmlns:th="http://www.thymeleaf.org"> import thymeleaf namespace
    2. use thymeleaf grammar
        